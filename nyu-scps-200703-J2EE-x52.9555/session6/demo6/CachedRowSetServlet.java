// Code 6J
import java.io.IOException;
import java.io.PrintWriter;
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

import sun.jdbc.rowset.CachedRowSet;
public class CachedRowSetServlet extends HttpServlet
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
	Context context =null;
	DataSource datasource =null;
	Connection con = null;
	PreparedStatement query = null;
	CachedRowSet videos = null;
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
		videos = new CachedRowSet();

		// populate
		videos.populate(rs);
		
		// close the connection but the RowSet should still hold data.
		con.close();
	
		// move from BOF to the first record.
		// if the resultset is empty - print a message.
		if (!videos.next()){
	    		out.println("<H3>There is no video title containing: " + title + "</H3>");
			return;
		}

	
		// update the rowset.
		double value;
		videos.beforeFirst();
		while (videos.next()){
			//add tax to the price
			value = Math.round(videos.getDouble("price") * 1.0850);
			videos.updateDouble("price",value);
		}
		


    	out.println("<H3>Here are the video titles containing: " + title + "</H3>");
		out.println("<TABLE BORDER=1>");
		out.println("<TR>");
		out.println("<TH>Title</TH>");
		out.println("<TH>Category</TH>");
		out.println("<TH>Price + Tax </TH>");
		out.println("</TR>");
		
		videos.beforeFirst();

		//loop through all the items. 
		while (videos.next()){
			out.println("<TR>");
			out.println("<TD>" + videos.getString("video_title") + "</TD>");
			out.println("<TD>" + videos.getString("category_name") + "</TD>");
			out.println("<TD>" + videos.getDouble("price") + "</TD>");
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
			videos.close();
			query.close();
		}
		catch(Exception e){
			//don't do anything - it is probably just a null pointer exception.
		}

	}
    }
}
