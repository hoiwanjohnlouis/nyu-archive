package cart;

import java.util.ArrayList;
import java.util.List;

import model.Actor;

public class CartLineItem {

    private int id;
    private String type;
    private int quantity =1;
    private double price=0;
    private String title;
    private List<String> artists = new ArrayList<String>();

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getQuantity() {
        return quantity;
    }
    public void incrementQuantity() {
        quantity++;
    }

    // HW8
    public void decrementQuantity() {
      if (quantity > 0) {
        quantity--;
      }
    }

    // HW9
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public List<String> getArtists() {
        return artists;
    }

    // Add artists the the existing List
    public void setArtists(String artist) {
    	this.artists.add(artist);
    }
}
