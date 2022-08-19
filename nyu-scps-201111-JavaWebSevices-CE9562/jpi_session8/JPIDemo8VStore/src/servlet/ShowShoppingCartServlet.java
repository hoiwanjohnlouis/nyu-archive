package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Actor;
import model.Music;
import model.Video;

import org.apache.log4j.Logger;

import cart.CartLineItem;
import cart.ShoppingCart;

import dao.ProductDAO;
import dao.ProductDAOIF;

public class ShowShoppingCartServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private static final Logger logger = Logger.getLogger(ShowShoppingCartServlet.class);

  private int    cummQuantity = 0;
  private double cummCost = 0.0;
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String caller = "doGet:";

    logger.info(caller + "Show Cart Starts");
    PrintWriter out = null;

    try{
      // set the content type of response.
      response.setContentType("text/html");

      // get a handle on the print writer of response.
      out=response.getWriter();

      logger.debug(caller + "Sending Response");
      cummQuantity = 0;
      cummCost = 0.0;

      // generate response.
      out.println("<HTML>");
      out.println("<HEAD>");
      out.println("<TITLE>");
      out.println("ShowShoppingCartServlet");
      out.println("</TITLE>");
      out.println("</HEAD>");
      out.println("<BODY>");

      // get the session
      HttpSession session = request.getSession();

      //get cart from session
      ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

      //if null return
      if ( (cart==null) || (cart.iterator()==null)|| (!cart.iterator().hasNext())){
        out.println("The cart is empty");
        return;
      }
      else{
        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<th>Id</th>");
        out.println("<th>Type</th>");
        out.println("<th>Title</th>");
        out.println("<th>Price</th>");
        out.println("<th>Quantity</th>");
        out.println("<th>Artist</th>");
        out.println("</tr>");
        Iterator<CartLineItem> iterator = cart.iterator();
        while (iterator.hasNext()){
          CartLineItem lineItem = iterator.next();
          ProductDAOIF dao = new ProductDAO();
          if (lineItem.getType().equalsIgnoreCase("Music")){
            Music music = dao.getMusic(lineItem.getId());
            logger.debug("Found music item id: " + lineItem.getId());
            out.println("<tr>");
            out.println("<td>" + music.getId() + "</td>");
            out.println("<td>" + lineItem.getType() + "</td>");
            out.println("<td>" + music.getTitle() + "</td>");
            out.println("<td>" + lineItem.getPrice() + "</td>");
            out.println("<td>" + lineItem.getQuantity() + "</td>");
            out.println("<td>" + music.getArtist().getName() + "</td>");
            out.println("<TD>" + 
                        "<A HREF=" + "RemoveFromShoppingCartServlet?" + 
                                     "id=" + music.getId() + 
                                     "&type=" + music.getCategory().getType() + 
                                     "&price=" + music.getPrice() + ">" + "Remove" + "</A>" + 
                        "</TD>");
            out.println("</tr>");

            // calculate cummulative quantity and cost
            cummQuantity = cummQuantity + lineItem.getQuantity();
            cummCost     = cummCost + (lineItem.getPrice() * lineItem.getQuantity());
          }
          else
          if (lineItem.getType().equalsIgnoreCase("Video")) {
              Video video = dao.getVideo(lineItem.getId());
              logger.debug("Found video item id: " + lineItem.getId());
              out.println("<tr>");
              out.println("<td>" + video.getId() + "</td>");
              out.println("<td>" + lineItem.getType() + "</td>");
              out.println("<td>" + video.getTitle() + "</td>");
              out.println("<td>" + lineItem.getPrice() + "</td>");
              out.println("<td>" + lineItem.getQuantity() + "</td>");

              // video.actors is a list, process acccordingly
              out.print("<td>");
              List<Actor> actors = new ArrayList<Actor>();
              actors = video.getActors();
              Iterator<Actor> iteratorActors = actors.iterator();
              while (iteratorActors.hasNext()) {
            	  Actor oneActor = iteratorActors.next();
            	  out.print(oneActor.getName() + " ");
              }
              out.println("</td>");

              out.println("<TD>" + 
                          "<A HREF=" + "RemoveFromShoppingCartServlet?" + 
            		                   "id=" + video.getId() + 
            		  	               "&type=" + video.getCategory().getType() + 
            		  	               "&price=" + video.getPrice() + ">" + "Remove" + "</A>" +
            		  	  "</TD>");
              out.println("</tr>");

              // calculate cummulative quantity and cost
              cummQuantity = cummQuantity + lineItem.getQuantity();
              cummCost     = cummCost + (lineItem.getPrice() * lineItem.getQuantity());
          }
        }

        // print cummulative quantity and cost
        out.println("<tr>");
        out.println("<td></td>");
        out.println("<td></td>");
        out.println("<td></td>");
        
        // make sure cost does have rounding problem
        out.print("<td>");
        out.format("%.2f%n", cummCost);
        out.println("</td>");

        out.println("<td>" + cummQuantity + "</td>");
        out.println("<td></td>");
        out.println("<td></td>");
        out.println("</tr>");
        out.println("</table>");
      }
    }
    catch(Exception e){
      throw new ServletException(e.toString());
    }
    finally{
      out.println("</BODY>");
      out.println("</HTML>");
      logger.info("Finished doGet");
    }

    logger.info(caller + "Show Cart Ends");
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String caller = "doPost:";
    logger.info(caller + "Show Cart Starts");
    doGet(request,response);
    logger.info(caller + "Show Cart Ends");
  }

}
