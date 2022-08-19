// Code 3D
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ShowRecordsServlet extends HttpServlet{

    private static final Logger logger = Logger.getLogger(ShowRecordsServlet.class);

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        logger.info("In doPost");
        doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        logger.info("In doGet");
        String category = null;
        PrintWriter out = null;
        ArrayList matched = null;
        Iterator iterator = null;
        Item item = null;

        // get the category
        category = (String) request.getParameter("category");

        // set the content type of response
        response.setContentType("text/html");

        // get a handle on the print writer of response.
        out=response.getWriter();

        logger.debug("Finding Records that match category: " + category);

        //get a list of records
        matched = RecordHolder.getByCategory(category);

        logger.debug("Found: " + matched.size() + " records");

        // generate response.
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>");
        out.println("Show Records Servlet");
        out.println("</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        if (matched.size()==0){
            out.println("<H3>Nothing Matched Category: " + category +"</H3>");
        }
        else{
            out.println("<H3>Here are the records under category: " + category +"</H3>");
            out.println("<TABLE BORDER=1>");
            out.println("<TR>");
            out.println("<TD>Artist</TD>");
            out.println("<TD>Title</TD>");
            out.println("<TD>Unit Price</TD>");
            out.println("<TD>ShoppingCart</TD>");
            out.println("</TR>");

            // get the iterator from the collection.
            iterator = matched.iterator();

            //loop through all the items.
            while (iterator.hasNext()){
                // get the next item
                item = (Item) iterator.next();
                logger.debug("Matching Item: " + item.toString());
                logger.debug("Sending to response");

                out.println("<TR>");
                out.println("<TD>" + item.getArtist() + "</TD>");
                out.println("<TD>" + item.getTitle() + "</TD>");
                out.println("<TD>" + item.getPrice() + "</TD>");
                out.println("<TD>" + "<A HREF=" + "AddItemToShoppingCartServlet?id=" + item.getId() + ">" + "Add" + "</A></TD>");
                out.println("</TR>");
            }
            out.println("</TABLE>");
        }
        out.println("</BODY>");
        out.println("</HTML>");
        out.close();
        logger.info("Finished doGet");
    }
}
