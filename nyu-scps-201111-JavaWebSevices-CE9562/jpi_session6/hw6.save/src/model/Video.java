package model;

import java.util.List;

import model.Director;
import model.Actor;

/**
 * @author root
 *
 * j)	In model package, subclass Product to Video 
 *      - the following fields and
 *      corresponding getters and setters need to be added:
 *      1)	rating (String)
 *      2)	duration (int)
 *      3)	director (Director)
 *      4)	actors (List<Actor>)
 *          - No setter for actors. 
 *          In order to add actors to a Video, 
 *          you will call the getActors() method 
 *          which will return a List and 
 *          you will add() to the list.
 *      5)	yearReleased (int)
 *
 */
public class Video extends Product {
	
	private String      rating  = null;
	private int         duration = -1;
	private Director    director = null;
	private List<Actor> actors = null;
	private int         yearReleased = -1;

	
	/**
	 * 
	 */
	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param price
	 * @param stockCount
	 * @param category
	 */
	public Video(double price, int stockCount, Category category) {
		super(price, stockCount, category);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param title
	 */
	public Video(int id, String title) {
		super(id, title);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param rating
	 * @param duration
	 * @param director
	 * @param actors
	 * @param yearReleased
	 */
	public Video(String rating, int duration, Director director,
			List<Actor> actors, int yearReleased) {
		super();
		this.rating = rating;
		this.duration = duration;
		this.director = director;
		this.actors = actors;
		this.yearReleased = yearReleased;
	}

	
	// standard getters and setters
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public Director getDirector() {
		return director;
	}
	public void setDirector(Director director) {
		this.director = director;
	}
	public int getYearReleased() {
		return yearReleased;
	}
	public void setYearReleased(int yearReleased) {
		this.yearReleased = yearReleased;
	}


	// only getters for List, setters will use the add function of List
	public List<Actor> getActors() {
		return actors;
	}

}
