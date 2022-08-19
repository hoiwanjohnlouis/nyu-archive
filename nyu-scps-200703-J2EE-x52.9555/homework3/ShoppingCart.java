 // Code 3H
import java.util.HashMap;
import java.util.Iterator;
import org.apache.log4j.Logger;

public class ShoppingCart{

    private static final Logger logger = Logger.getLogger(ShoppingCart.class);


    private HashMap cartitems;
    private int numberOfProducts;

    public ShoppingCart(){
        logger.info("In ShoppingCart constructor");
        cartitems = new HashMap();
        numberOfProducts = 0;
    }

    public void add(Item theItem){

        logger.info("In add");

        String key = theItem.getId();

        // if the item is already in the cart.
        // get the shoppingcartitem out of the cart.
        // increment quantity only.
        if(cartitems.containsKey(key)){
            logger.debug("Item: " + key + " found in cart, incrementing quantity");
            ShoppingCartItem shoppingcartitem = (ShoppingCartItem) cartitems.get(key);
            shoppingcartitem.incrementQuantity();
        }
        // create a brand new cart item and add it to the cart.
        else{
            logger.debug("Item: " + key + " NOT found in cart, creating ShoppingCartItem");
            ShoppingCartItem shoppingcartitem = new ShoppingCartItem(theItem);
            cartitems.put(key, shoppingcartitem);
        }

        // increase the number of items in the cart.
        numberOfProducts++;
        logger.info("Finished add");
    }
    public Iterator iterator(){

        return cartitems.values().iterator();
    }

    public int getNumberOfProducts(){

        return numberOfProducts;
    }

    // homework3, remove
    public double getTotal(){
    	double total = 0.0;
    	Iterator it = iterator();
        while(it.hasNext()) {
            ShoppingCartItem shoppingcartitem = (ShoppingCartItem) it.next();
        	total += (shoppingcartitem.getItem().getPrice() * shoppingcartitem.getQuantity());
        }

        return total;
       
    }

    // homework3, remove
    public void remove(Item theItem){

        logger.info("In remove");

        String key = theItem.getId();

        // if the item is already in the cart.
        // get the shoppingcartitem out of the cart.
        // decrement quantity only.
        if(cartitems.containsKey(key)){
            logger.debug("Item: " + key + " found in cart, decrementing quantity");
            ShoppingCartItem shoppingcartitem = (ShoppingCartItem) cartitems.get(key);
            shoppingcartitem.decrementQuantity();
            
            // zero check
            if(shoppingcartitem.getQuantity() <= 0) {
                logger.debug("Item: " + key + " no longer in cart, delete item");
            	cartitems.remove(key);
            }
        }
        // nothing to do if we get here... just return
        else{
            logger.debug("Item: " + key + " NOT found in cart.  We're done");
            return;
        }

        // decrease the number of items in the cart.
        numberOfProducts--;
        
        logger.info("Finished remove");
    }

}