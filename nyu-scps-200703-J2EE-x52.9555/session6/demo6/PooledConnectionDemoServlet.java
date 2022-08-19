// Code 6H
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.ConnectionPoolDataSource;
import javax.sql.PooledConnection;
public class PooledConnectionDemoServlet extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
		doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {

	// set the content type of response.
	response.setContentType("text/html");

	// get a handle on the print writer of response.
    	PrintWriter out=response.getWriter();


	PooledConnection pool =null;
	Connection con = null;
	Statement statement = null;
	ResultSet categories = null;

	try{

		// load Database.properties file
		PropertyResourceBundle bundle = (PropertyResourceBundle) ResourceBundle.getBundle("PooledConnection");

		// get the initial context factory class name from the bundle
		String contextfactory = bundle.getString("connection.contextfactory");

		// get the provider url from the bundle.
		String providerurl = bundle.getString("connection.providerurl");


		// create a hash table and put parameters to create the context
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY,contextfactory);
		env.put(Context.PROVIDER_URL,providerurl);
		
		//create the context
		Context context = new InitialContext(env);

		// find the datasource
		ConnectionPoolDataSource datasource = (ConnectionPoolDataSource) context.lookup("myconnectionpooldatasource");

		// get a Pooled connection
		pool = datasource.getPooledConnection();

		// get a connection from the pool
		con = pool.getConnection();


		// create a statement
		statement = con.createStatement();


		// execute a query using the statement.
		// this will return a resultset.
		categories = statement.executeQuery("select * from categories order by category_id");

		out.println("<H3>Here are the categories");
		out.println("<TABLE BORDER=1>");
		out.println("<TR>");
		out.println("<TH>ID</TH>");
		out.println("<TH>Name</TH>");
		out.println("<TH>Type</TH>");
		out.println("</TR>");


		//loop through all the items.
		while (categories.next()){
			out.println("<TR>");
			out.println("<TD>" + categories.getInt("category_id") + "</TD>");
			out.println("<TD>" + categories.getString("category_name") + "</TD>");
			out.println("<TD>" + categories.getString("category_type") + "</TD>");
			out.println("</TR>");
		}
		out.println("</TABLE>");

		
	}
	catch(SQLException e){
		System.out.println("\n--- SQLException caught ---\n");
		while (e != null)
		{
			System.out.println("Message:		" + e.getMessage());
			System.out.println("SQLState:		" + e.getSQLState());
			System.out.println("Vendor ErrorCode:	" + e.getErrorCode());
			e = e.getNextException();
			System.out.println();
		}
	}
	catch(NamingException e){
		System.out.println(e.toString());
	}
	finally
	{
		out.println("</BODY>");
		out.println("</HTML>");
		// since close methods throw sqlexception - catch 'em.
		try{
			categories.close();
			statement.close();
			con.close();
			pool.close();
		}
		catch(Exception e){
			//don't do anything - it is probably just a null pointer exception.
		}

	}
    }
}
