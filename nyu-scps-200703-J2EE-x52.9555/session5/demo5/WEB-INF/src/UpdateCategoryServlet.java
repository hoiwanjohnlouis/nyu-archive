// Code 5E
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

public class UpdateCategoryServlet extends HttpServlet{
	private static final Logger logger = Logger.getLogger(UpdateCategoryServlet.class);

	public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
		doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{

		Connection con = null;
	    PreparedStatement psSelect=null;
	    PreparedStatement psUpdate=null;
		ResultSet categories = null;
	
		// get the flag from request
		String flag = (String) request.getParameter("flag");
	
		// set the content type of response.
		response.setContentType("text/html");

		// get a handle on the print writer of response.
    	PrintWriter out=response.getWriter();

    	// generate response.
     	out.println("<HTML>");
    	out.println("<HEAD>");
    	out.println("<TITLE>");
    	out.println("Update Category Servlet");
    	out.println("</TITLE>");
    	out.println("</HEAD>");
    	out.println("<BODY>");
    	try{
			// load the driver class.
			Class.forName("COM.cloudscape.core.JDBCDriver");
	
			// string url to the database.
			String url = "jdbc:cloudscape:c:/data/VSTORE";
	
			// connect to the database.
			con = DriverManager.getConnection(url);
			
			logger.debug("Got Connection");
			
			//let's control transaction manully.
            con.setAutoCommit(false);

            logger.debug("Auto Commit is off");

            // create a statement
            psSelect = con.prepareStatement("select * from categories order by category_id",ResultSet.CONCUR_READ_ONLY,ResultSet.TYPE_SCROLL_INSENSITIVE);

            // execute a result using the statement
            // this will return a resultset.
            categories = psSelect.executeQuery();

            logger.debug("Got ResultSet");

    		out.println("<H3>Here are the categories BEFORE ID changes");
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

			categories = psSelect.executeQuery();
			psUpdate = con.prepareStatement("Update Categories Set category_id = ? where category_id=?");
			int current_id=0;
			int old_id=0;
            while (categories.next()){
            	old_id=categories.getInt("category_id");
            	current_id=100-old_id;
            	psUpdate.setInt(1,current_id);
            	psUpdate.setInt(2,old_id);
            	psUpdate.execute();
                logger.debug("Executed Update for " + current_id);
            }
            // if the user sends rollback flag as querystring then rollbac
            // otherwise commit.
            if (!(flag==null) && (flag.equals("rollback"))){
            	con.rollback();
            	logger.debug("Rolled Back");
            }
            else{
            	con.commit();
            	logger.debug("Commited");
            }
            // execute a result using the statement.
            // this will return a resultset.
            categories = psSelect.executeQuery();
        	logger.debug("Got ResultSet again");

            out.println("<H3>Here are the categories AFTER ID changes");
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
				if (psSelect!=null){
					psSelect.close();
				}
				if (psUpdate!=null){
					psUpdate.close();
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
