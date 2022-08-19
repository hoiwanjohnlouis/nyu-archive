import java.io.IOException;
// import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


public class ErrorServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6278151676307083994L;
    /**
	 * 
	 */
	private static final Logger logger = Logger.getLogger(ErrorServlet.class);

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                      throws ServletException, IOException {

        logger.info("In doGet");

        // get the writer and set output content type
        // PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        logger.debug("Sending response");
        response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED, "The Url you have requested returned Error.");

        logger.info("Finished doGet");
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
                       throws ServletException, IOException {

        logger.info("In doPost");

        // doGet does the same thing
        logger.debug("  going to doGet");
        doGet(request, response);
        logger.debug("  back from doGet");
        
        logger.info("Finished doPost");
    }
}

