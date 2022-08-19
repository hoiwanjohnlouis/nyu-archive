package model;
import java.util.ArrayList;
import java.util.List;


public class Video extends Product{

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

}
