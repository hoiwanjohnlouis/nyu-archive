package cart;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;

public class ShoppingCart {

    private static final Logger logger = Logger.getLogger(ShoppingCart.class);
    private Map<Integer,CartLineItem> items = new HashMap<Integer,CartLineItem>();

    private int    cummQuantity = 0;
    private double cummCost = 0.0;

    public void add(int id, String type, double price){
        CartLineItem lineItem = null;
        if (items.containsKey(id)){
            lineItem = items.get(id);
            lineItem.incrementQuantity();
            // calculate cummulative quantity and cost
            incrementCummQuantity();
            incrementCummCost(price);
            logger.debug("found id: " + id + " type: " + type + " price: " + price + " increased quantity");
        }
        else{
            lineItem = new CartLineItem();
            lineItem.setId(id);
            lineItem.setType(type);
            lineItem.setPrice(price);
            items.put(id,lineItem);
            // calculate cummulative quantity and cost
            incrementCummQuantity();
            incrementCummCost(price);
            logger.debug("added id: " + id + " type: " + type + " price: " + price);
        }

    }

    public void delete(int id, String type, double price){
        String caller = "delete:";
        CartLineItem lineItem = null;
        if (items.containsKey(id)){
            lineItem = items.get(id);
            lineItem.decrementQuantity();
            // calculate cummulative quantity and cost
            decrementCummQuantity();
            decrementCummCost(lineItem.getPrice());
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

	public int getCummQuantity() {
		return cummQuantity;
	}
	public void incrementCummQuantity() {
		this.cummQuantity++;
	}
	public void decrementCummQuantity() {
		if (this.cummQuantity > 0) {
			this.cummQuantity--;
	    }
	}

	public double getCummCost() {
		// correct any rounding issues before returning data
		DecimalFormat newFormat = new DecimalFormat("#.##");
		this.cummCost =  Double.valueOf(newFormat.format(this.cummCost));
		return this.cummCost;
	}
	public void incrementCummCost(double newCost) {
		this.cummCost = this.cummCost + newCost;
	}
	public void decrementCummCost(double newCost) {
		if ((this.cummCost - newCost) >= 0) {
			this.cummCost = this.cummCost - newCost;
	    }
	}

}
