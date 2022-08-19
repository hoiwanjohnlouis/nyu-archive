package model;

import java.util.List;

import model.Artist;
import model.Track;

/**
 * @author root
 *
 * i)	In model package, subclass Product to Music 
 *      – the following fields and
 *        corresponding getters and setters need to be added:
 *      1)	artist (Artist)
 *      2)	numberOfTracks (int)
 *      3)	tracks (List<Track>) 
 *          – No setter for tracks.
 *          In order to add tracks to a Music, 
 *          you will call the getTracks() method 
 *          which will return a List and 
 *          you will add() to the list.
 *
 */
public class Music extends Product {

	private Artist         artist = null;
	private int            numberOfTracks = -1;
	private List<Track>    tracks = null;
	
		
	/**
	 * 
	 */
	public Music() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param artist
	 * @param numberOfTracks
	 * @param tracks
	 */
	public Music(Artist artist, int numberOfTracks, List<Track> tracks) {
		super();
		this.artist = artist;
		this.numberOfTracks = numberOfTracks;
		this.tracks = tracks;
	}



	// standard getters and setters
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

	
	// only getters for List, setters will use the add function of List
    public List<Track> getTracks() {
		return tracks;
	}
	
}