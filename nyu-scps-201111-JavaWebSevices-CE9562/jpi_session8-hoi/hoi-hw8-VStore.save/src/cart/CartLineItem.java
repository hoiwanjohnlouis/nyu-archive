package cart;

public class CartLineItem {
	
	private int id;
	private String type;
	private int quantity =1;
	private double price=0;
	
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

}
