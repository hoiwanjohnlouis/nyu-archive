package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
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


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String caller = "doGet:";

        logger.info(caller + "Show Cart Starts");

        try{

            logger.debug(caller + "Sending Response");

            // get the session
            HttpSession session = request.getSession();

            //get cart from session
            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");


            //if null return
            if ( (cart==null) || (cart.iterator()==null)|| (!cart.iterator().hasNext())) {
            }
            else {

                // simple list variable for shoppingcart.jsp
                List<CartLineItem> lineItems = new ArrayList<CartLineItem>();

                Iterator<CartLineItem> iterator = cart.iterator();
                while (iterator.hasNext()) {

                	CartLineItem lineItem = iterator.next();

                    ProductDAOIF dao = new ProductDAO();
                    if (lineItem.getType().equalsIgnoreCase("Music")){
                        Music music   = null;
                        music = dao.getMusic(lineItem.getId());
                        if (null == music) {
                        }
                        else {
                            logger.debug("Found music item id: " + lineItem.getId());

                            // only set title and artist once.
                        	// next time, make music and artists use the same layout to
                        	// simplify the jsp
                            if (null == lineItem.getTitle() || null == lineItem.getArtists() ) {
                                lineItem.setArtists(music.getArtist().getName());
                                lineItem.setTitle(music.getTitle());
                            }

                            // save a list for jsp
                            lineItems.add(lineItem);
                        }
                    }
                    else
                    if (lineItem.getType().equalsIgnoreCase("Video")) {
                        Video video   = null;
                        video = dao.getVideo(lineItem.getId());
                        if (null == video) {
                        }
                        else {
                            logger.debug("Found video item id: " + lineItem.getId());

                            // only set title and artist once.
                        	// next time, make music and artists use the same layout to
                        	// simplify the jsp
                            if (null == lineItem.getTitle() || null == lineItem.getArtists() ) {
                                lineItem.setTitle(video.getTitle());

                                // video.actors is a list, process acccordingly
                                List<Actor> actors = new ArrayList<Actor>();
                                actors = video.getActors();

                                Iterator<Actor> iteratorActors = actors.iterator();
                                while (iteratorActors.hasNext()) {
                                    Actor oneActor = iteratorActors.next();
                                    lineItem.setArtists(oneActor.getName());
                                }
                            }
                        	
                            // save a list for jsp
                            lineItems.add(lineItem);
                        }
                    }
                }
                request.setAttribute("lineItemList", lineItems);
                RequestDispatcher dispatcher = request.getRequestDispatcher("showshoppingcart.jsp");
                dispatcher.forward(request, response);
            }
        }
        catch(Exception e){
            throw new ServletException(e.toString());
        }
        finally{
            logger.info(caller + "Show Cart Finally");
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
