// Code 3C
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class HitCounterServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(HitCounterServlet.class);

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        logger.info("In doPost");
        doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        logger.info("In doGet");
        int hitcount=0;
        boolean found=false;
        Cookie[] cookies = null;
        Cookie cookie = null;
        PrintWriter out = null;

        logger.debug("Getting cookies from request");
        // extract the array of Cookies from request object.
        cookies = request.getCookies();

        // if Cookie exists.
        if (!(cookies==null)){
            logger.debug("Found " + cookies.length + " cookies");

            // loop through the array of Cookies and find Hit_Counter.
            for (int i=0;i<cookies.length;i++){
                // if Hit_Counter cookie found.
                if (cookies[i].getName().equals("Hit_Counter")){
                    logger.debug("Found 'Hit_Counter' cookie");

                    // set the flag.
                    found=true;

                    // retrieve the current value and add 1
                    hitcount=Integer.parseInt(cookies[i].getValue()) + 1;

                    // set the new value after converting to String.
                    cookies[i].setValue(String.valueOf(hitcount));

                    logger.debug("Incremented cookie value to " + cookies[i].getValue());

                    // although browser has this cookie
                    // add it to the response.
                    // so that brower's cookie value gets overridden by incremented value
                    // VERY IMPORTANT
                    response.addCookie(cookies[i]);
                    logger.debug("Added the cookie to the response");
                }
            }
        }

        // if Hit_Counter cookie not found.
        if (!(found)){
            logger.debug("'Hit_Counter cookie not found");

            // initialize hitcounter with 1.
            hitcount=1;
            // create a new session level Hit_Counter cookie.
            cookie = new Cookie("Hit_Counter",String.valueOf(hitcount));

            logger.debug("Added a new cookie to the response");

            // add it to the response.
            // VERY IMPORTANT
            response.addCookie(cookie);
        }

        logger.debug("Sending response");

        // set the content type of response.
        response.setContentType("text/html");

        // get a handle on the print writer of response.
        out=response.getWriter();

        // generate response.
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>");
        out.println("Hit Count Servlet");
        out.println("</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<H3>You've visited this page " + hitcount + " time(s) during this session</H3>");
        out.println("</BODY>");
        out.println("</HTML>");
        logger.info("Finished doGet");
    }
}


