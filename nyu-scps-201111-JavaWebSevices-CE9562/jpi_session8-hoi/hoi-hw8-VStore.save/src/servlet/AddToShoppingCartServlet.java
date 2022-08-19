package servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import cart.ShoppingCart;

public class AddToShoppingCartServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(AddToShoppingCartServlet.class);

	public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
		logger.info("In doPost");
		doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
		logger.info("In doGet");

		// get the name from request
    	String idString = request.getParameter("id");
    	int id=0;
    	try{
    		id = Integer.parseInt(idString);
    	}
    	catch(Exception e){
    		//do nothing;
    	}
		String type = request.getParameter("type");

    	String priceString = request.getParameter("price");
    	double price=0;
    	try{
    		price = Double.parseDouble(priceString);
    	}
    	catch(Exception e){
    		//do nothing;
    	}
		// get the session
		HttpSession session = request.getSession();
		
		//get cart from session
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		
		//if null create a new cart
		if (cart==null){
			logger.debug("cart not found in session");
			cart = new ShoppingCart();
			session.setAttribute("cart", cart);
		}
		if ((id!=0) && (price!=0) && (type!=null)){ 
			cart.add(id, type,price);
			logger.debug("added id: " + id + " type: " + type + " price: " + price);
		}
		else{
			logger.debug("can not add id: " + id + " type: " + type + " price: " + price);
			
		}
    	logger.info("Finished doGet");
    	response.sendRedirect("ShowShoppingCartServlet");
    }
}
