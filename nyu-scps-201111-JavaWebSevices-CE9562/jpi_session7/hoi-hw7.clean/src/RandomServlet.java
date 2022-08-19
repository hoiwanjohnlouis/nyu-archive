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

        logger.info("In doGet");

        // doPost does the same thing
        doPost(request, response);

        logger.info("Finished doGet");
    }

    // POST method
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
                       throws ServletException, IOException {

        Integer lowerBound;
        Integer upperBound;
        Integer howMany;
        String  title;
        TreeSet<Integer> tree = new TreeSet<Integer>();
        Integer counter = 0;
        Integer results = 0;

        logger.info("In doPost");

        // set output content type
        response.setContentType("text/html");

        logger.debug("Sending response");

        // load data into locals
        try {
            lowerBound = Integer.parseInt(request.getParameter("lower_bound"));
            upperBound = Integer.parseInt(request.getParameter("upper_bound"));
            howMany    = Integer.parseInt(request.getParameter("how_many"));

            // verify data
            if  (
                    (lowerBound >= upperBound) ||                   // condition 3
                    (lowerBound < 0) ||                             // condition 2a (no negatives)
                    (upperBound < 0) ||                             // condition 2a (no negatives)
                    (howMany    < 0) ||                             // condition 2a (no negatives)
                    (howMany    >= (upperBound - lowerBound + 1))   // condition 4
                ) {
                response.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE,
                                   "Sorry, the service is unvailable due to bad input data.");
            }

            // formated output list of data goes here
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
        } catch (NumberFormatException nfe){
            //  condition 2b (no junk data)
            response.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE,
                    "Sorry, the service is unvailable due to bad input data.");
        }

        logger.info("Finished doPost");

    }
}

