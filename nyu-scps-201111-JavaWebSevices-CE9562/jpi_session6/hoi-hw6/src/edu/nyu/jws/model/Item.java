package edu.nyu.jws.model;


/**
 * @author root
 *
 * c)	In model package, add the following abstract classes:
 *      1)	Item – that has id (int)and 
 *             title (String) private fields AND
 *             corresponding getters and setters
 */
public abstract class Item {
	
	private int     id = -1;
	private String  title = null;
	

	/**
	 * 
	 */
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param title
	 */
	public Item(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}


	// standard getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}