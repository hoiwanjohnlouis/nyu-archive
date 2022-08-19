package model;


/**
 * @author root
 *
 * h)	In model package, subclass Item to Track
 *      – duration (int) private field and
 *        getter, setter should be added.
 *
 */
public class Track extends Item {
	
	private int  duration = -1;

	
	/**
	 * 
	 */
	public Track() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param title
	 */
	public Track(int id, String title) {
		super(id, title);
		// TODO Auto-generated constructor stub
	}
	
	
	// standard getters and setters
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
}
