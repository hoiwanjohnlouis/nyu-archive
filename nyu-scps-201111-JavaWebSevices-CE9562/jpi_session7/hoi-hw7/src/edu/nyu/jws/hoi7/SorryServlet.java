package edu.nyu.jws.hoi7;


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

        logger.info("doGet - begins");
        logger.debug("Build response - begins");

        // Set some header stuff
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);

        // get the writer and set output content type
        PrintWriter out = response.getWriter();

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

        logger.debug("Build response - ends");
        logger.info("doGet - ends");
    }


    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
                       throws ServletException, IOException {

        logger.info("doPost - begins");

        // doGet does the same thing
        logger.info("going to doGet");
        doGet(request, response);
        logger.info("back from doGet");

        logger.info("doPost - ends");

    }
}

