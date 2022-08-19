// Code 6M
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
public class TomcatContextDemoServlet extends HttpServlet
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


	Connection con = null;
	Statement statement = null;
	ResultSet categories = null;

	try{

		
		//create the context
		Context context = new InitialContext();

		// find the datasource
		DataSource datasource = (DataSource) 
			context.lookup("java:comp/env/jdbc/VStore");

		// get a connection from the pool
		con = datasource.getConnection();


		// create a statement
		statement = con.createStatement();


		// execute a query using the statement.
		// this will return a resultset.
		String sql="select * from categories order by category_id";
		categories = statement.executeQuery(sql);
		out.println("<H1>" + datasource.getClass().getName() +"</H1>");
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
		}
		catch(Exception e){
			//don't do anything - it is probably just a null pointer exception.
		}

	}
    }
}
