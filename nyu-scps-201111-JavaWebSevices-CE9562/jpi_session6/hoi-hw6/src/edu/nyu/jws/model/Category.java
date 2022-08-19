package edu.nyu.jws.model;


/**
 * b)	In model package, 
 *      create a class called Cagetory 
 *      with the following fields and 
 *      corresponding getters and setters: 
 * 
 *      1)	id (int)
 *      2)	name (String)
 *      3)	type (String)
 */
public class Category {

	private int     id = -1;
	private String  name = null;
	private String  type = null;
	
	
	/**
	 * 
	 */
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
    public Category(int id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}
	
    
	// standard getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
