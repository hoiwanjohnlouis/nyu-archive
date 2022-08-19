package edu.nyu.jws.hoi7;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


public class RandomServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 7032649979936876190L;
    /**
     *
     */
    private static final Logger logger = Logger.getLogger(RandomServlet.class);


    // GET method
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                      throws ServletException, IOException {

        Integer lowerBound = 0;
        Integer upperBound = 0;
        Integer howMany    = 0;
        Integer diff       = 0;
        String  title      = null;
        TreeSet<Integer> tree = new TreeSet<Integer>();
        Integer counter = 0;
        Integer results = 0;

        logger.info("doGet - begins");
        logger.debug("Build response - begins");

        // set output content type
        response.setContentType("text/html");

        // load data into locals
        try {
            lowerBound = Integer.parseInt(request.getParameter("lower_bound"));
            upperBound = Integer.parseInt(request.getParameter("upper_bound"));
            howMany    = Integer.parseInt(request.getParameter("how_many"));
            diff       = (upperBound - lowerBound + 1);

            // verify data
            if  (
                    (lowerBound >= upperBound) ||           // condition 3
                    (lowerBound < 0) ||                     // condition 2a (no negatives)
                    (upperBound < 0) ||                     // condition 2a (no negatives)
                    (howMany    < 0) ||                     // condition 2a (no negatives)
                    (howMany    >= diff)                    // condition 4
                ) {
                logger.debug("...got BAD data; in SC_SERVICE_UNAVAILABLE");

                response.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE,
                                   "Sorry, the service is unvailable due to bad input data.");
            }
            else {
                logger.debug("...got good data");

                // formated output list of data goes here
                while(tree.size() < howMany) {
                    results = (int)( ((upperBound - lowerBound + 1) * Math.random())  + lowerBound);
                    tree.add(results);
                }

                // get the writer
                PrintWriter out = response.getWriter();

                // print response
                out.println("<html>");

                    out.println("<head>");
                    out.println("<title>");

                    // title has it's own variable since we print it more than once
                    title = "Here are the " +
                            howMany         +
                            " random numbers between " +
                            lowerBound +
                            " and " +
                            upperBound +
                            ".";

                    out.println(title);
                    out.println("</title>");
                    out.println("</head>");

                    out.println("<body>");
                    out.println("<H3>");
                    out.println(title);
                    out.println("</H3>");
                    out.println("</body>");

                    out.println("<hr>");
                    out.println("<table>");
                    counter = 0;
                    Iterator<Integer> it = tree.iterator();
                    while(it.hasNext()) {
                        counter++;
                        out.println("<TR>");
                        out.println("<TD>" + counter + ")</TD><TD>" + it.next() + "</TD>");
                        out.println("</TR>");
                    }
                    out.println("</table>");
                    out.println("<hr>");

                out.println("</html>");

                out.close();
            }
        } catch (NumberFormatException nfe){
            //  condition 2b (no junk data)
            response.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE,
                    "Sorry, the service is unvailable due to bad input data.");
        }

        logger.debug("Build response - ends");
        logger.info("doGet - ends");
    }


    // POST method
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

