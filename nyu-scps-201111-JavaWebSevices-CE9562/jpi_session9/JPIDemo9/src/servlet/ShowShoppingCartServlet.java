package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Music;

import org.apache.log4j.Logger;

import cart.CartLineItem;
import cart.ShoppingCart;

import dao.ProductDAO;
import dao.ProductDAOIF;

public class ShowShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ShowShoppingCartServlet.class);
      

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	PrintWriter out = null;
		try{
	    	// get the session
			HttpSession session = request.getSession();
			
			//get cart from session
			ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
			
			//if null return
			if ( (cart==null) || (cart.getIterator()==null)|| (!cart.getIterator().hasNext())){
			}
			else{
				Iterator<CartLineItem> iterator = cart.getIterator();
				while (iterator.hasNext()){
					CartLineItem lineItem = iterator.next();
					ProductDAOIF dao = new ProductDAO();
					if (lineItem.getType().equals("music")){
						Music music = dao.getMusic(lineItem.getId());
						if (music!=null){
							logger.debug("Found music item id: " + lineItem.getId());
							lineItem.setArtists(music.getArtist().getName());
							lineItem.setTitle(music.getTitle());
						}
					}
				}
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("showshoppingcart.jsp");
			dispatcher.forward(request, response);

		}
		catch(Exception e){
			throw new ServletException(e.toString());
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
