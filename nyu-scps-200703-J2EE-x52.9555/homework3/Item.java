// Code 3F
import org.apache.log4j.Logger;
public class Item{

    private static final Logger logger = Logger.getLogger(Item.class);

    private static int nextid;
    private String id;
    private String artist;
    private String title;
    private String category;
    private double price;

    // constructor
    public Item(String theArtist,String theTitle,
                String theCategory,double thePrice){
        logger.info("In Item constructor");

        // convert int to string
        id = String.valueOf(++nextid);
        artist = theArtist;
        title = theTitle;
        category = theCategory;
        price = thePrice;
        logger.info("Item constructed: " + this.toString());

    }

    public String getId(){
        return id;
    }

    public String getArtist(){
        return artist;
    }

    public void setArtist(String theArtist){
        artist = theArtist;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String theTitle){
        title = theTitle;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String theCategory){
        category = theCategory;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double thePrice){
        price = thePrice;
    }

    public String toString(){
        return "Id: " + this.id + " " + "Title:" + this.title;
    }

}