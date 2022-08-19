// Code 6J
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import sun.jdbc.rowset.WebRowSet;
public class WebRowSetServlet extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
		doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {

	// get the title from request
	String title = (String) request.getParameter("title");



	// get a handle on the print writer of response.
    	PrintWriter out=response.getWriter();

		// generate response.
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>");
		out.println("Video Search Servlet");
		out.println("</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
	if (title==null){
		// set the content type of response.
		response.setContentType("text/html");
    	out.println("<H3>You did not specify any serach criteria</H3>");
		out.println("</BODY>");
		out.println("</HTML>");
		return;
	}
	Context context =null;
	DataSource datasource =null;
	Connection con = null;
	PreparedStatement query = null;
	WebRowSet videos = null;
	ResultSet rs = null;
	try{

		//create the context
		context = new InitialContext();

		// find the datasource
		datasource = (DataSource) context.lookup("java:comp/env/jdbc/VStore");

		// get a connection from the pool
		con = datasource.getConnection();

		// get data
		query = con.prepareStatement("select * from Video_Recordings where video_title like ?");
		query.setString(1,"%"+title+"%");
		rs = query.executeQuery();

		// instantiate
		videos = new WebRowSet();

		// populate
		videos.populate(rs);
		
		// close the connection but the RowSet should still hold data.
		con.close();
		StringWriter s = new StringWriter();
		videos.writeXml(s);
		out.println("<TEXTAREA name='xml' rows='40' cols='80' wrap='soft'>");
		out.println(s.toString());
		out.println("</TEXTAREA>");
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
			videos.close();
			query.close();
		}
		catch(Exception e){
			//don't do anything - it is probably just a null pointer exception.
		}

	}
    }
}
