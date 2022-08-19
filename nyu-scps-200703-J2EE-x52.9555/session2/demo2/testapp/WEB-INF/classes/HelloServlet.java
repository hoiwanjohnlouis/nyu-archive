// Code 2D
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class HelloServlet extends HttpServlet {

	private static final Logger logger = Logger.getLogger(HelloServlet.class);

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
		logger.debug("In doGet()");

    	// get the writer and set output content type
    	PrintWriter out = response.getWriter();
    	response.setContentType("text/html");

		logger.debug("Sending response");
    	// print response
    	out.println("<html>");
    	out.println("<head>");
		out.println("<title>");
		out.println("Response from HelloServlet");
		out.println("</title>");
		out.println("</head>");
		out.println("<body>");
		if ((request.getParameter("firstname").equals("")) || request.getParameter("lastname").equals("")){
			out.println("<h1>You did not enter your name properly</h1>");
		}
		else{
			out.println("<h1>Hello " + request.getParameter("firstname") + " " + request.getParameter("lastname") + "</h1>");
			if (request.getParameter("programmer")==null){
				out.println("<h3>I am sorry, you are in the wrong class. You must know Java for this class</h3>");
			}
			else{
				out.println("<h3>Wonderful, since you know Java, we can start talking Java now.</h3>");
			} 
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
		logger.debug("Finished doGet()");
    }
}

