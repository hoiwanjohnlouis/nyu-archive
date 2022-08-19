package edu.nyu.jws.model;


/**
 * @author root
 *
 * c)	In model package, add the following abstract classes:
 *      2)	Person – that has id (int) and 
 *                   name (String) private fields and 
 *                   corresponding getters and setters
 */
public abstract class Person {

	private int     id = -1;
	private String  name = null;

	
	/**
	 * 
	 */
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param name
	 */
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

}