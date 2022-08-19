package model;
import java.util.ArrayList;
import java.util.List;


public class Music extends Product{

    private Artist artist;
    private int numberOfTracks;
    private List<Track> tracks = new ArrayList<Track>();

    public Artist getArtist() {
      return artist;
    }
    public void setArtist(Artist artist) {
      this.artist = artist;
    }
    public int getNumberOfTracks() {
      return numberOfTracks;
    }
    public void setNumberOfTracks(int numberOfTracks) {
      this.numberOfTracks = numberOfTracks;
    }
    public List<Track> getTracks() {
      return tracks;
    }
}
