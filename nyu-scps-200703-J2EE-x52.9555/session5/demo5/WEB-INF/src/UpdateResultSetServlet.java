// Code 5C
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

public class UpdateResultSetServlet extends HttpServlet{
	private static final Logger logger = Logger.getLogger(UpdateResultSetServlet.class);

	public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
		doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{

		Connection con = null;
		Statement result = null;
		ResultSet categories = null;
	
		// set the content type of response.
		response.setContentType("text/html");
	
		// get a handle on the print writer of response.
	    PrintWriter out=response.getWriter();
	
		// generate response.
     	out.println("<HTML>");
    	out.println("<HEAD>");
    	out.println("<TITLE>");
    	out.println("Display Category Servlet");
    	out.println("</TITLE>");
    	out.println("</HEAD>");
    	out.println("<BODY>");
    	try{
			// load the driver class.
			Class.forName("COM.cloudscape.core.JDBCDriver");
	
			// string url to the database.
			String url = "jdbc:cloudscape:c:/data/VSTORE";
	
			// connect to the database 
			con = DriverManager.getConnection(url);
			logger.debug("Got Connection");
	
			// create a statement
			result = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			logger.debug("Got ResultSet");
			// execute a result using the statement.
			// this will return a resultset.
			categories = result.executeQuery("select * from categories order by category_id");
	
			// if not updatable - let use know.
			if (!(categories.getConcurrency()==ResultSet.CONCUR_UPDATABLE)){
	    		out.println("<H3>Driver does not support update.");
	    		logger.debug("Driver does not support update");
				return;
			}
    		out.println("<H3>Here are the categories before ID changes");
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
			logger.debug("Updating ResultSet");
			int current_id=0;
			while (categories.previous()){
			        current_id=categories.getInt("category_id");
			        current_id=100-current_id;
			        categories.updateInt("category_id",current_id);
			}
    	}
		catch(SQLException e){
			while (e != null)
			{
				logger.error("Message:		" + e.getMessage());
				logger.error("SQLState:		" + e.getSQLState());
				logger.error("Vendor ErrorCode:	" + e.getErrorCode());
				e = e.getNextException();
			}
		}
		catch(ClassNotFoundException e){
			logger.error("Exception",e);
		}
		finally
		{
			out.println("</BODY>");
			out.println("</HTML>");
			// since close methods throw sqlexception - catch 'em.
			try{
				logger.debug("Closing connection");
				if (categories!=null){
					categories.close();
				}
				if (result!=null){
					result.close();
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
