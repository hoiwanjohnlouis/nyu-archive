// Code 5B
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
public class DisplayCategoryServlet extends HttpServlet{
	private static final Logger logger = Logger.getLogger(DisplayCategoryServlet.class);

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
    	logger.info("In doPost");
		doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{

    	logger.info("In doGet");

    	// set the content type of response.
    	response.setContentType("text/html");

    	// get a handle on the print writer of response.
    	PrintWriter out=response.getWriter();

    	Connection con = null;
    	Statement statement = null;
    	ResultSet categories = null;
    	
    	try{

    		logger.debug("Loading driver");
    	 	// load the driver class.
    		Class.forName("COM.cloudscape.core.JDBCDriver");

    		// string url database.
    		String url = "jdbc:cloudscape:c:/data/VSTORE";

    	 	logger.debug("Connecting to the database...");
    		// connect to the database.
    		con = DriverManager.getConnection(url);

    		// create a statement
    		statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

    	 	logger.debug("Connection established, executing sql...");
    		// execute a query using the statement.
    		// this will return a resultset.
    		categories = statement.executeQuery("select * from categories order by category_id");

    		// if can't scroll backward - let user know.
    		if (!(categories.getType()==ResultSet.TYPE_SCROLL_INSENSITIVE)){
    			out.println("<H3>Driver does not support backward-scroll.");
        	 	logger.debug("Driver does not support backward-scroll");
    			return;
    		}
    		out.println("<H3>Here are the categories in reverse ID order");
    		out.println("<TABLE BORDER=1>");
    		out.println("<TR>");
    		out.println("<TH>ID</TH>");
    		out.println("<TH>Name</TH>");
    		out.println("<TH>Type</TH>");
    		out.println("</TR>");
		
    	 	//move to the last item
    	 	categories.afterLast();

    	 	//loop through all the items.
    	 	while (categories.previous()){
        	 	logger.debug("category id: " + categories.getInt("category_id"));
    	 		out.println("<TR>");
    	 		out.println("<TD>" + categories.getInt("category_id") + "</TD>");
    	 		out.println("<TD>" + categories.getString("category_name") + "</TD>");
    	 		out.println("<TD>" + categories.getString("category_type") + "</TD>");
    	 		out.println("</TR>");
    	 	}
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
        		if (categories!=null){
        			categories.close();
        		}
        		if (statement!=null){
        			statement.close();
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
