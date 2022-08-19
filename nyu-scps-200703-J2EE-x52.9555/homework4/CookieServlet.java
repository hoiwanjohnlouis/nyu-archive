//Code 3A
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class CookieServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(CookieServlet.class);

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        logger.info("In doPost");
        doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{

        PrintWriter out = null;
        Cookie[] cookies = null;

        logger.info("In doGet");

        // set the content type.
        response.setContentType("text/html");

        // create an array to hold 3 Cookies.
        cookies = new Cookie[3];

        // create a session-long Cookie(Default)
        cookies[0] = new Cookie("Session-Long-Cookie","S");
        logger.debug("Created Session Cookie");

        // create a minute long Cookie
        cookies[1] = new Cookie("Minute-Long-Cookie","M");

        // set 60 sec. age.
        cookies[1].setMaxAge(60);

        logger.debug("Created Minute Cookie");

        // create instant Cookie.
        cookies[2] = new Cookie("Instant-Cookie","I");

        // set 0 sec. age.
        cookies[2].setMaxAge(0);

        logger.debug("Created Instant Cookie");

        // add Cookies to the response object.
        response.addCookie(cookies[0]);
        response.addCookie(cookies[1]);
        response.addCookie(cookies[2]);

        logger.debug("Added cookies to response");

        // get a handle on the response printwriter.
        out=response.getWriter();

        logger.debug("Generating Response");

        // generate response.
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>");
        out.println("Cookie Servlet");
        out.println("</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<H3>This page has set the following Cookies</H3>");
        out.println("<TABLE BORDER=1>");
        out.println("<TR>");
        out.println("<TD>Name</TD>");
        out.println("<TD>Value</TD>");
        out.println("</TR>");

        // loop through the array of Cookies and print their name and value.
        for (int i=0;i<cookies.length;i++){
            out.println("<TR>");
            out.println("<TD>" + cookies[i].getName() + "</TD>");
            out.println("<TD>" + cookies[i].getValue() + "</TD>");
            out.println("</TR>");
        }
        out.println("</TABLE>");
        out.println("<BR>");

        // link to ShowCookies Servlet to see the Cookies again.
        out.println("To see them again, visit <A HREF=\"./ShowCookiesServlet\"> ShowCookies servlet</A>");

        out.println("</BODY>");
        out.println("</HTML>");
        logger.info("Finished doGet");
    }
}

