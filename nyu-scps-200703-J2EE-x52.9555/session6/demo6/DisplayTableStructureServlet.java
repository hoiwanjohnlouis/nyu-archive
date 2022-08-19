// Code 6B
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayTableStructureServlet extends HttpServlet
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


	String tablename =null;
	Connection con = null;
	Statement statement = null;
	ResultSet videos = null;

	try{

		// get the table name from the servlet input parameter
		tablename = request.getParameter("tablename");

		// load the driver class.
		Class.forName("COM.cloudscape.core.JDBCDriver");

		// string url to the database
		String url = "jdbc:cloudscape:c:/data/VSTORE";

		// connect to the database.
		con = DriverManager.getConnection(url);

		// create a statement
		statement = con.createStatement();

		// execute a query using the statement.
		// this will return an empty resultset since 2+2<>5.
		videos = statement.executeQuery("select * from " + tablename + " where 2+2=5");


		// get the resultset metadata		
		ResultSetMetaData metadata = videos.getMetaData();


		out.println("<H3>Here is the structure of " + tablename + " Table");
		out.println("<TABLE BORDER=1>");
		out.println("<TR>");
		out.println("<TH>Field Name</TH>");
		out.println("<TH>Type</TH>");
		out.println("<TH>Size</TH>");
		out.println("</TR>");

		//loop through all the items.
		for (int i=1; i<= metadata.getColumnCount();i++){
			out.println("<TR>");
			out.println("<TD>" + metadata.getColumnName(i) + "</TD>");
			out.println("<TD>" + metadata.getColumnTypeName(i) + "</TD>");
			out.println("<TD>" + metadata.getColumnDisplaySize(i) + "</TD>");
 

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
	catch(ClassNotFoundException e){
		System.out.println(e.toString());
	}
	finally
	{
		out.println("</BODY>");
		out.println("</HTML>");
		// since close methods throw sqlexception - catch 'em.
		try{
			videos.close();
			statement.close();
			con.close();
		}
		catch(Exception e){
			//don't do anything - it is probably just a null pointer exception.
		}

	}
    }
}
