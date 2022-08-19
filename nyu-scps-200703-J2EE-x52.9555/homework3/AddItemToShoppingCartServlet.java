// Code 3G
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class AddItemToShoppingCartServlet extends HttpServlet
{
    private static final Logger logger = Logger.getLogger(AddItemToShoppingCartServlet.class);

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        logger.info("In doPost");
        doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        logger.info("In doGet");
        PrintWriter out = null;
        boolean found = true;
        ShoppingCart shoppingcart=null;
        Item item=null;
        String id = null;
        HttpSession session = null;

        try{
            // set the content type of response.
            response.setContentType("text/html");
            // get a handle on the print writer of response.
            out=response.getWriter();
            out.println("<HTML>");
            out.println("<HEAD>");
            out.println("<TITLE>");
            out.println("Shopping Cart Problem");
            out.println("</TITLE>");
            out.println("</HEAD>");
            out.println("<BODY>");

            // get Item Id from request parameter
            id=request.getParameter("id");

            // if parameter id not found.
            if (id==null)
            {
                logger.debug("Item Id was not in request");
                found=false;
            }
            if (found)
            {
                logger.debug("Item Id: " + id);
                // get the item from the RecordHolder using id.

                item =RecordHolder.get(id);

                // if item not found in RecordHolder.
                if (item==null)
                {
                    logger.debug("Item Id: " + id + " does not exist in RecordHolder");
                    found=false;
                }
            }

            // if not found for any of the above reasons
            // send back error message.
            if (!(found))
            {
                // generate error response.
                out.println("<H3>Sorry,could not add to shopping cart</H3>");
                return;
            }

            // get or create a session;
            session = request.getSession();

            // get shoppingcart out as object from session and cast it.
            shoppingcart = (ShoppingCart) session.getAttribute("shoppingcart");

            //if no shoppingcart exists - create one.
            if (shoppingcart==null)
            {
                logger.debug("Shopping cart not found, creating a new shopping cart");
                shoppingcart= new ShoppingCart();

            }

            //add the item to the cart.
            shoppingcart.add(item);

            // don't forget to add it to the session if
            // this is the first time we are creating session object.
            // or somehow the shoppingcart has been removed from the session.
            if (session.isNew() || (session.getAttribute("shoppingcart")==null)){
                logger.debug("Adding shopping cart to the session since there was none");
                session.setAttribute("shoppingcart",shoppingcart);
            }

            logger.debug("Redirecting user to the ShowShoppingCartServlet");
            // redirect the response to ShowShoppingCartServlet.
            response.sendRedirect("ShowShoppingCartServlet");
        }catch(Exception e){

            logger.error("In Exception Block",e);

            // the catch block was really
            // not to catch any exception
            // but to have a finally block
            throw new ServletException(e);
        }
        finally{
            logger.debug("In Finally Block");

            out.println("</BODY>");
            out.println("</HTML>");
            out.close();
        }
        logger.info("Finished doGet");
    }
}
