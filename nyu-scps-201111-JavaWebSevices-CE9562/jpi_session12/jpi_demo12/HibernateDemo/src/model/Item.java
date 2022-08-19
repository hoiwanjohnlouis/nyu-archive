package model;

import java.io.Serializable;

public abstract class Item implements Serializable{
	private transient static final long serialVersionUID = 1L;


	private int id;
	private String title;
	
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
