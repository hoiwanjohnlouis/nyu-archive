// Code 6K
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.jdbc.rowset.JdbcRowSet;
public class JdbcRowSetServlet extends HttpServlet
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


	// set the content type of response.
	response.setContentType("text/html");

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
			out.println("<H3>You did not specify any serach criteria</H3>");
		out.println("</BODY>");
		out.println("</HTML>");
		return;
	}
	JdbcRowSet videos = null;
	try{

		// load the driver class.
		Class.forName("COM.cloudscape.core.JDBCDriver");

		// string url to the database.
		String url = "jdbc:cloudscape:c:/data/VSTORE";

		// instantiate
		videos = new JdbcRowSet();

		// set the url
		videos.setUrl(url);

		// set the query
		videos.setCommand("select * from Video_Recordings where video_title like " + "'%" + title + "%'");


		// execute the query.
		videos.execute();

	
		// if the resultset is empty - print a message.
		if (!videos.next()){
				out.println("<H3>There is no video title containing: " + title + "</H3>");
			return;
		}


		
		out.println("<H3>Here are the video titles containing: " + title + "</H3>");
		out.println("<TABLE BORDER=1>");
		out.println("<TR>");
		out.println("<TH>Title</TH>");
		out.println("<TH>Category</TH>");
		out.println("<TH>Price");
		out.println("</TR>");

		
		//loop through all the items. 
		do{
			out.println("<TR>");
			out.println("<TD>" + videos.getString("video_title") + "</TD>");
			out.println("<TD>" + videos.getString("category_name") + "</TD>");
			out.println("<TD>" + videos.getDouble("price") + "</TD>");
			out.println("</TR>");
		}while (videos.next()); 

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
		}
		catch(Exception e){
			//don't do anything - it is probably just a null pointer exception.
		}

	}
	}
}
