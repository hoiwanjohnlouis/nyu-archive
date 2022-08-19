//Code 5D
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class MusicSearchServlet extends HttpServlet{

	private static final Logger logger = Logger.getLogger(DisplayCategoryServlet.class);

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
    	logger.info("In doPost");
		doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{

    	logger.info("In doGet");

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
    	out.println("Music Search Servlet");
    	out.println("</TITLE>");
    	out.println("</HEAD>");
    	out.println("<BODY>");
    	if (title==null){
    		logger.debug("No search criteria found");
	    	out.println("<H3>You did not specify any serach criteria</H3>");
	    	out.println("</BODY>");
	    	out.println("</HTML>");
	    	return;
    	}
    	Connection con = null;
    	PreparedStatement query = null;
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
	
			String querystring = "select music_tracks.track_title,"
				+"music_recordings.artist_name,"
				+"music_recordings.album_title,"
				+"music_recordings.category_name,"
				+"music_recordings.price "
				+"from music_recordings,"
				+"music_tracks where "
				+"music_recordings.recording_id=music_tracks.recording_id "
				+"and music_tracks.track_title "
				+"like ? order by "
				+"music_tracks.track_title";  
	
	 		logger.debug("Executing sql...");
	
	 		// create a prepared statement.
	 		query = con.prepareStatement(querystring);
	
	 		// provide the data for the question mark.
	 		query.setString(1,"%" + title + "%");
	
	 		// execute a query
	 		// this will return a resultset.
	 		videos = query.executeQuery();
		
	 		// move from BOF to the first record.
	 		// if the resultset is empty - print a message.
	 		if (!videos.next()){
		 		logger.debug("No marching title found");
	    		out.println("<H3>There is no music title containing: " + title + "</H3>");
	    		return;
	 		}
    		out.println("<H3>Here are the music titles containing: " + title + "</H3>");
    		out.println("<TABLE BORDER=1>");
    		out.println("<TR>");
    		out.println("<TH>Title</TH>");
    		out.println("<TH>Artist</TH>");
    		out.println("<TH>Album</TH>");
    		out.println("<TH>Category</TH>");
    		out.println("<TH>Price</TH>");
    		out.println("</TR>");
			
    		//loop through all the items. 
    		do {
    	 		logger.debug("Title: " + videos.getString("track_title"));
    	 		out.println("<TR>");
    			out.println("<TD>" + videos.getString("track_title") + "</TD>");
    			out.println("<TD>" + videos.getString("artist_name") + "</TD>");
    			out.println("<TD>" + videos.getString("album_title") + "</TD>");
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
    			logger.error("Exception",e);
    		}
    	}
	}
}
