// Code 3B
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ShowCookiesServlet extends HttpServlet{

    private static final Logger logger = Logger.getLogger(ShowCookiesServlet.class);

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        logger.info("In doPost");
        doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{

        logger.info("In doGet");

        PrintWriter out = null;
        Cookie[] cookies = null;

        // set the content type of response.
        response.setContentType("text/html");

        // get a handle on the print writer of response.
        out=response.getWriter();

        logger.debug("Sending Response");

        // generate response.
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>");
        out.println("Show Cookies Servlet");
        out.println("</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<H3>This page has received the following Cookies</H3>");
        out.println("<TABLE BORDER=1>");
        out.println("<TR>");
        out.println("<TD>Name</TD>");
        out.println("<TD>Value</TD>");
        out.println("</TR>");

        // extract the array of Cookies from request object.
        cookies = request.getCookies();

        logger.debug("Got cookies from request");

        // if any Cookie received at all.
        if (!(cookies==null)){

            logger.debug("Found " + cookies.length + " cookies");

            // loop through the array of Cookies and print their name and value.
            for (int i=0;i<cookies.length;i++){

                logger.debug("Cookie Name=" + cookies[i].getName() + " Value= " + cookies[i].getValue());
                out.println("<TR>");
                out.println("<TD>" + cookies[i].getName() + "</TD>");
                out.println("<TD>" + cookies[i].getValue() + "</TD>");
                out.println("</TR>");
            }
        }
        out.println("</TABLE>");
        out.println("</BODY>");
        out.println("</HTML>");
        logger.info("Finished doGet");
    }
}

