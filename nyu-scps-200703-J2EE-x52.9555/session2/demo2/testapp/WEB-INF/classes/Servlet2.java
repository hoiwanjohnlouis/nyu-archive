// Code 2B
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

public class Servlet2 extends GenericServlet
{
	private static final Logger logger = Logger.getLogger(Servlet2.class);

	public void service(ServletRequest request, ServletResponse response)
    		throws ServletException, IOException
  	{
			logger.debug("In Service()");
			String name = request.getParameter("name");
			//set the content type to html
			logger.debug("Setting content Type");

			response.setContentType("text/html");
 
			logger.debug("Getting printWriter");

			// get the writer object and write.
    		PrintWriter out = response.getWriter();

    		logger.debug("Sending response");

    		out.println("<HTML>");
    		out.println("<HEAD>");
    		out.println("<TITLE>");
    		out.println("Welcome to Servlet");
    		out.println("</TITLE>");
    		out.println("</HEAD>");
    		out.println("<BODY>");
    		if (name==null){
				out.println("<H1>Welcome to the wonderful world of servlet</H1>");
    		}
    		else{
				out.println("<H1> " + name + ", Welcome to the wonderful world of servlet</H1>");
    		}	
    		out.println("</BODY>");
    		out.println("</HTML>");
			out.close();
			logger.debug("Service() complete");
	}
}
