package edu.nyu.jws.testcase;

import java.util.Iterator;
import java.util.List;

import edu.nyu.jws.dao.ProductDAO;
import edu.nyu.jws.dao.ProductDAOIF;

import edu.nyu.jws.model.Actor;
import edu.nyu.jws.model.Artist;
import edu.nyu.jws.model.Category;
import edu.nyu.jws.model.Director;
import edu.nyu.jws.model.Music;
import edu.nyu.jws.model.Track;
import edu.nyu.jws.model.Video;

import junit.framework.TestCase;


public class ProductTestCase extends TestCase {
	
	public void testMusicRetrieval(){
		
		try{
			ProductDAOIF dao = new ProductDAO();
			List<Music> musics = dao.getMusic("Jazz");
			assertNotNull(musics);
			assertEquals(5, musics.size());
			System.out.println("Total jazz music: " + musics.size());
			Iterator<Music> iteratorMusics = musics.iterator();
			while(iteratorMusics.hasNext()){
				Music music = iteratorMusics.next();
				System.out.print("Music: " + music.getId() + " - ");
				System.out.print(music.getTitle() + " - ");
				System.out.print(music.getPrice() + " - ");
				System.out.print(music.getStockCount() + " - ");
				System.out.print(music.getNumberOfTracks());
				Category category = music.getCategory();
				System.out.print("   Category: " + category.getId()+ " - ");
				System.out.print(category.getName() + " - ");
				System.out.print(category.getType() + " - ");
				Artist artist = music.getArtist();
				System.out.print("   Artist: " + artist.getId()+ " - ");
				System.out.print(artist.getName());
				System.out.println();
				List<Track> tracks = music.getTracks();
				Iterator<Track> iteratorTracks = tracks.iterator();
				System.out.println("\tTracks: ");
				while(iteratorTracks.hasNext()){
					Track track = iteratorTracks.next();
					System.out.print("\t" + track.getId() + " - ");
					System.out.print("\t" + track.getTitle() + " - ");
					System.out.print("\t" + track.getDuration());
					System.out.println();
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
			fail("Exception");
		}
		
	}

	public void testVideoRetrieval(){
		
		try{
			ProductDAOIF dao = new ProductDAO();
			List<Video> videos = dao.getVideo("STAR");
			assertNotNull(videos);
			assertEquals(2, videos.size());
			System.out.println("Total videos: " + videos.size());
			Iterator<Video> iteratorVideos = videos.iterator();
			while(iteratorVideos.hasNext()){
				Video video = iteratorVideos.next();
				System.out.print("Video: " + video.getId() + " - ");
				System.out.print(video.getTitle() + " - ");
				System.out.print(video.getPrice() + " - ");
				System.out.print(video.getStockCount() + " - ");
				System.out.print(video.getDuration());
				Category category = video.getCategory();
				System.out.print("   Category: " + category.getId()+ " - ");
				System.out.print(category.getName() + " - ");
				System.out.print(category.getType() + " - ");
				Director director = video.getDirector();
				System.out.print("   Director: " + director.getId()+ " - ");
				System.out.print(director.getName());
				System.out.println();
				List<Actor> actors = video.getActors();
				Iterator<Actor> iteratorActors = actors.iterator();
				System.out.println("\tActors: ");
				while(iteratorActors.hasNext()){
					Actor actor = iteratorActors.next();
					System.out.print("\t" + actor.getId() + " - ");
					System.out.print("\t" + actor.getName());
					System.out.println();
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
			fail("Exception");
		}
		
	}
}
