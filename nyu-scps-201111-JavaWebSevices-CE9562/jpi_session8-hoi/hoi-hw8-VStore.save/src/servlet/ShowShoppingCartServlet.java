package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;


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
	    	// set the content type of response.
		    response.setContentType("text/html");

			// get a handle on the print writer of response.
		    out=response.getWriter();

			logger.debug("Sending Response");

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
					if (lineItem.getType().equals("music")){
						Music music = dao.getMusic(lineItem.getId());
						logger.debug("Found music item id: " + lineItem.getId());
						out.println("<tr>");
						out.println("<td>" + music.getId() + "</td>");
						out.println("<td>" + lineItem.getType() + "</td>");
						out.println("<td>" + music.getTitle() + "</td>");
						out.println("<td>" + lineItem.getPrice() + "</td>");
						out.println("<td>" + lineItem.getQuantity() + "</td>");
						out.println("<td>" + music.getArtist().getName() + "</td>");
						out.println("</tr>");
					}
				}
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

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
