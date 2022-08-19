package model;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Music extends Product{
		private static transient final long serialVersionUID = 1L;

		private Artist artist;
		private int numberOfTracks;
		private Set<Track> tracks = new HashSet<Track>();
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
		public Set<Track> getTracks() {
			return tracks;
		}
		public void setTracks(Set<Track> tracks) {
			this.tracks = tracks;
		}
}
