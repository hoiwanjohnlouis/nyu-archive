// Code 6A
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayTableNamesServlet extends HttpServlet
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
	ResultSet tables = null;

	try{

		// load the driver class.
		Class.forName("COM.cloudscape.core.JDBCDriver");

		// string url to the database.
		String url = "jdbc:cloudscape:c:/data/VSTORE";

		// connect to the database.
		con = DriverManager.getConnection(url);


		// get the database metadata		
		DatabaseMetaData metadata = con.getMetaData();

		out.println("<H3>Database Info:");
		// get features of the database
		out.println("<TABLE BORDER=1>");
		out.println("<TR><TD>Database Name</TD>");
		out.println("<TD>"+ metadata.getDatabaseProductName() + "</TD><TR>");
		out.println("<TR><TD>Database version</TD>");
		out.println("<TD>"+ metadata.getDatabaseProductVersion() + "</TD><TR>");
		out.println("<TR><TD>Driver Name</TD>");
		out.println("<TD>" + metadata.getDriverName() + "</TD><TR>");
		out.println("<TR><TD>Driver Verison</TD>");
		out.println("<TD>" + metadata.getDriverVersion() + "</TD><TR>");
		out.println("<TR><TD>Supports Forward only Resultset</TD>");
		out.println("<TD>" + metadata.supportsResultSetType(
			ResultSet.TYPE_FORWARD_ONLY) + "</TD><TR>");
		out.println("<TR><TD>Supports scroll sensitive Resultset</TD>");
		out.println("<TD>" + metadata.supportsResultSetType(
			ResultSet.TYPE_SCROLL_SENSITIVE) + "</TD><TR>");
		out.println("<TR><TD>Supports scroll insensitive Resultset</TD>");
		out.println("<TD>" + metadata.supportsResultSetType(
			ResultSet.TYPE_SCROLL_INSENSITIVE) + "</TD><TR>");
		out.println("<TR><TD>Supports updatable Resultset</TD>");
		out.println("<TD>" + metadata.supportsResultSetConcurrency(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE) + "</TD><TR>");
		out.println("</TABLE>");
		
		String[] types = {"TABLE"};
		String schema = "APP";	//for Cloudscape
		tables = metadata.getTables(null,"APP",null,types);

		out.println("<H3>Here are the tables");
		out.println("<TABLE BORDER=1>");

		//loop through all the items.
		while (tables.next()){
			out.println("<TR>");
			out.println("<TD>" + tables.getString("TABLE_NAME") + "</TD>");
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
			tables.close();
			statement.close();
			con.close();
		}
		catch(Exception e){
			//don't do anything - it is probably just a null pointer exception.
		}

	}
    }
}
