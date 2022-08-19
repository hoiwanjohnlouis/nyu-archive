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
			logger.debug("found id: " + id + " type: " + type + " increased quantity");
		}
		else{
			lineItem = new CartLineItem();
			lineItem.setId(id);
			lineItem.setType(type);
			lineItem.setPrice(price);
			items.put(id,lineItem);
			logger.debug("added id: " + id + " type: " + type);

		}
	}
	
	public Iterator<CartLineItem> getIterator(){
		return items.values().iterator();
	}

}
