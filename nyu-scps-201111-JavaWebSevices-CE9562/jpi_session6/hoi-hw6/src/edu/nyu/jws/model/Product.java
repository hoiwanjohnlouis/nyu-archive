package edu.nyu.jws.model;


/**
 * @author root
 *
 * d)	In model package, 
 *      subclass Item to an abstract class Product and 
 *      add the following fields and 
 *      corresponding getters and setters:
 *       
 *      1)	price (double)
 *      2)	stockCount (int)
 *      3)	category (Cagetory)
 *      
 */
public abstract class Product extends Item {
	
	private double   price = -1;
	private int      stockCount = -1;
	private Category category = null;


	/**
	 * 
	 */
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param price
	 * @param stockCount
	 * @param category
	 */
	public Product(double price, int stockCount, Category category) {
		super();
		this.price = price;
		this.stockCount = stockCount;
		this.category = category;
	}
	/**
	 * @param id
	 * @param title
	 */
	public Product(int id, String title) {
		super(id, title);
		// TODO Auto-generated constructor stub
	}

	
	// standard getters and setters
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStockCount() {
		return stockCount;
	}
	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

}