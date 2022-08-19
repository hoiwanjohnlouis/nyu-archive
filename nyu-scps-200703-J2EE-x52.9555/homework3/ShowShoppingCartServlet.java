// Code 3J
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class ShowShoppingCartServlet extends HttpServlet{

    private static final Logger logger = Logger.getLogger(ShowShoppingCartServlet.class);

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        logger.info("In doPost");
        doGet(request,response);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{

        logger.info("In doGet");

        boolean found = true;
        Object attribute=null;
        ShoppingCart shoppingCart=null;
        Item item=null;
        HttpSession session = null;
        PrintWriter out = null;
        Iterator iterator = null;
        ShoppingCartItem  shoppingCartItem = null;

        try{
            // set the content type of response.
            response.setContentType("text/html");

            // get a handle on the print writer of response.
            out=response.getWriter();

            // generate response.
            out.println("<HTML>");
            out.println("<HEAD>");
            out.println("<TITLE>");
            out.println("Shopping Cart");
            out.println("</TITLE>");
            out.println("</HEAD>");
            out.println("<BODY>");

            // get the session but don't create it.
            session = request.getSession(false);

            // if null - error.
            if (session==null){

                logger.debug("There was no session");
                found=false;
            }

            // get the shoppingcart object from session.
            // if null - error.
            if (found){

                attribute = session.getAttribute("shoppingcart");

                if (attribute==null){

                    logger.debug("There was no shopping cart in the session");
                    found=false;
                }
            }

            // if found is false - it is an error condition.
            // return from here.
            if (!(found)){

                logger.debug("Either the shopping cart or the session not found");
                out.println("<H3>Shopping cart is empty</H3>");
                return;

            }

            // cast attribute to ShoppingCart object.
            // make sure there is something to show.
            shoppingCart = (ShoppingCart) attribute;
            if ((shoppingCart.getNumberOfProducts() == 0)){

                logger.debug("The shopping cart is currently empty");
                out.println("<H3>Shopping cart is currently empty</H3>");
                return;

            }

            // make sure there is data
            
            out.println("<H3>View Shopping Cart</H3>");
            out.println("<TABLE BORDER=1>");
            out.println("<TR>");
            out.println("<TD>Artist</TD>");
            out.println("<TD>Title</TD>");
            out.println("<TD>Category</TD>");
            out.println("<TD>Quantity</TD>");
            out.println("<TD>Unit Price</TD>");

           	// homework3, remove
            out.println("<TD>Remove Item</TD>");

            out.println("</TR>");

            logger.debug("Reading Shopping Cart");
            // get the iterator and loop
            iterator = shoppingCart.iterator();
            while (iterator.hasNext()){

                // get the cartitem out of the cart.
                shoppingCartItem = (ShoppingCartItem) iterator.next();

                logger.debug("ShoppingCart Item found: " + shoppingCartItem.toString());

                // get the item out of the cartitem.
                item=shoppingCartItem.getItem();

                out.println("<TR>");

                //print artist,title and cagetory from item.
                out.println("<TD>" + item.getArtist() + "</TD>");
                out.println("<TD>" + item.getTitle() + "</TD>");
                out.println("<TD>" + item.getCategory() + "</TD>");

                // print quantity from cartitem not item.
                out.println("<TD>" + shoppingCartItem.getQuantity() + "</TD>");
            
                // print price.
                out.println("<TD>" + item.getPrice() + "</TD>");

                // add reference to remove
                out.println("<TD>" + "<A HREF=" + "RemoveItemFromShoppingCartServlet?id=" + item.getId() + ">" + "Remove" + "</A></TD>");
                             
                out.println("</TR>");

            }

            // total stuff
            out.println("<TR>");
            out.println("</TR>");
            out.println("<TR>");
            out.println("</TR>");
            out.println("<TR>");
            out.println("</TR>");
            out.println("<TR>");
            out.println("<TD><b>Total</b></TD>");
            out.println("<TD></TD>");
            out.println("<TD></TD>");
            out.println("<TD><b>" + shoppingCart.getNumberOfProducts() + "</b></TD>");
            out.println("<TD><b>" + shoppingCart.getTotal() + "</b></TD>");
            out.println("</TR>");

            out.println("</TABLE>");
        
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
        }
        logger.info("Finished doGet");
    }
}
