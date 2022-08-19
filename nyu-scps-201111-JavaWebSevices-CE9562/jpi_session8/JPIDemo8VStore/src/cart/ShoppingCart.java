package cart;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;


public class ShoppingCart {
  private static final Logger logger = Logger.getLogger(ShoppingCart.class);

  private Map<Integer,CartLineItem> items = new HashMap<Integer,CartLineItem>();

  public void add(int id, String type, double price){
      CartLineItem lineItem = null;
      if (items.containsKey(id)){
        lineItem = items.get(id);
        lineItem.incrementQuantity();
        logger.debug("found id: " + id + " type: " + type + " price: " + price + " increased quantity");
      }
      else{
        lineItem = new CartLineItem();
        lineItem.setId(id);
        lineItem.setType(type);
        lineItem.setPrice(price);
        items.put(id,lineItem);
        logger.debug("added id: " + id + " type: " + type + " price: " + price);

      }

    }

  public void delete(int id, String type, double price){
	  String caller = "delete:";
	  
	  CartLineItem lineItem = null;
      if (items.containsKey(id)){
        lineItem = items.get(id);
        lineItem.decrementQuantity();
        logger.debug(caller + "found id: " + id + " type: " + type  + " price: " + price + " decreased quantity");
        if (0 == lineItem.getQuantity()) {
          // no more qty for this item. delete object from hash
          items.remove(id);
          logger.debug(caller + "removed hash id: " + id + " type: " + type + " price: " + price);
        }
      }
      else{
        logger.debug("Not found id: " + id + " type: " + type + " price: " + price);
      }

    }

  public Iterator<CartLineItem> iterator(){
    return items.values().iterator();
  }

}
