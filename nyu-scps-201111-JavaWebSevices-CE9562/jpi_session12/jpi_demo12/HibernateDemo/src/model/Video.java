package model;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class Video extends Product{
	private transient static final long serialVersionUID = 1L;


	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	private String rating;
	private int duration;
	private Director director;
	private List<Actor> actors = new ArrayList<Actor>();
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
	public List<Actor> getActors() {
		return actors;
	}
	public String listActorNames(){
		Iterator<Actor> i = actors.iterator();
		String names = "";
		while (i.hasNext()){
			names = names + i.next().getName() + "<br/>";
		}
		return names;
	}


}
