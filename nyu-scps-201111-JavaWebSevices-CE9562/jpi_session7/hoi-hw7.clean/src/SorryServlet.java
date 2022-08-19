import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


public class SorryServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3505688626901374215L;
    /**
	 * 
	 */
	private static final Logger logger = Logger.getLogger(SorryServlet.class);

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                      throws ServletException, IOException {

        logger.info("In doGet");

        // doPost does the same thing
        // doPost(request, response);

        // Try something new
        response.setContentType("text/html");

        logger.debug("Sending response");
        response.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE,
                           "Sorry, the service is unvailable due to excessive call volume.");

        logger.info("Finished doGet");
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
                       throws ServletException, IOException {

        logger.info("In doPost");

        // get the writer and set output content type
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        logger.debug("Sending response");
        // print response
        out.println("<html>");

            out.println("<head>");
            out.println("<title>");
            out.println("Sorry, the service is unvailable due to excessive call volume.");
            out.println("</title>");
            out.println("</head>");

            out.println("<body>");
            out.println("<H3>");
            out.println("Sorry, the service is unvailable due to excessive call volume.");
            out.println("</H3>");
            out.println("</body>");

        out.println("</html>");
        out.close();

        logger.info("Finished doPost");

    }
}

