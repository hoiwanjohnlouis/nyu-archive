 import org.apache.log4j.Logger;

// Code 3I
public class ShoppingCartItem{

    private static final Logger logger = Logger.getLogger(ShoppingCartItem.class);

    private Item item;
    private int quantity;

    public ShoppingCartItem(Item aItem){
        logger.info("In ShoppingCartItem constructor");

        item = aItem;
        quantity = 1;
        logger.info("Constructed ShoppingCartItem: " + this.toString());

    }
    public Item getItem(){
        return item;
    }
    public int getQuantity(){
        return quantity;
    }
    public void incrementQuantity(){
        quantity++;
    }
    public void decrementQuantity(){
        quantity--;
    }
    public String toString(){
        return item.toString() + " Quantity: "+ quantity;
    }
}
