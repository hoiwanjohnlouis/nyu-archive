// Code 5A
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class VideoSearchServlet extends HttpServlet{
	private static final Logger logger = Logger.getLogger(VideoSearchServlet.class);
	
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
		doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{

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
    		logger.debug("Video search criteria missing");
	    	out.println("<H3>You did not specify any serach criteria</H3>");
	    	out.println("</BODY>");
	    	out.println("</HTML>");
	    	return;
    	}
    	Connection con = null;
    	Statement query = null;
    	ResultSet videos = null;
    	try{

    		logger.debug("Loading driver");
    		// load the driver class.
    		Class.forName("COM.cloudscape.core.JDBCDriver");

    		// string url database.
    		String url = "jdbc:cloudscape:c:/data/VSTORE";

    		logger.debug("Connecting to the database...");
    		// connect to the database.
    		con = DriverManager.getConnection(url);

    		// create a statement.
    		query = con.createStatement();

    		logger.debug("Executing sql...");
    		// execute a query using the statement.
    		// this will return a resultset.
    		videos = query.executeQuery("select * from Video_Recordings where video_title like " + "'%" + title + "%'");

    		// move from BOF to the first record.
    		// if the resultset is empty - print a message.
    		if (!videos.next()){
        		logger.debug("No match found");
	    		out.println("<H3>There is no video title containing: " + title + "</H3>");
	    		return;
    		}
    		out.println("<H3>Here are the video titles containing: " + title + "</H3>");
    		out.println("<TABLE BORDER=1>");
    		out.println("<TR>");
    		out.println("<TH>Title</TH>");
    		out.println("<TH>Year</TH>");
    		out.println("<TH>Category</TH>");
    		out.println("<TH>Price</TH>");
    		out.println("</TR>");
		
    		//loop through all the items. 
    		do {
        		logger.debug("Title: " + videos.getString("video_title") );
    			out.println("<TR>");
    			out.println("<TD>" + videos.getString("video_title") + "</TD>");
    			out.println("<TD>" + videos.getInt("year_released") + "</TD>");
    			out.println("<TD>" + videos.getString("category_name") + "</TD>");
    			out.println("<TD>" + videos.getDouble("price") + "</TD>");
    			out.println("</TR>");
    		} while (videos.next());

    		out.println("</TABLE>");
    	}
    	catch(SQLException e){
			logger.error("Exception", e);
			while (e != null){
				logger.error("Message:		" + e.getMessage());
				logger.error("SQLState:		" + e.getSQLState());
				logger.error("Vendor ErrorCode:	" + e.getErrorCode());
				e = e.getNextException();
			}
    	}
    	catch(ClassNotFoundException e){
    		logger.error("Exception", e);
    	}
    	finally{
    		logger.debug("In finally");
    		out.println("</BODY>");
    		out.println("</HTML>");
    		// since close methods throw sqlexception - catch 'em.
    		try{
        		logger.debug("Closing connection");
        		if (videos!=null){
        			videos.close();
        		}
        		if (query!=null){
        			query.close();
        		}
        		if ((con!=null) && (!con.isClosed())){
        			con.close();
        		}
    		}
    		catch(Exception e){
    			logger.error("Exception", e);
    		}

    	}
    }
}
