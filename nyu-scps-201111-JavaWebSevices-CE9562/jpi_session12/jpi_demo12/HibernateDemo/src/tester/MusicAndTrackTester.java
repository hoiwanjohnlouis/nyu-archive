package tester;

import java.util.Iterator;
import java.util.List;

import model.Artist;
import model.Category;
import model.Director;
import model.Music;
import model.Track;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

import junit.framework.TestCase;

public class MusicAndTrackTester extends TestCase {
	
	public void testSaveDirector(){
		
		Transaction transaction = null; 
		try { 
			Session session = HibernateUtil.getSessionFactory().openSession(); 
			String title = "music2";
			transaction = session.beginTransaction(); 
			
			Track track = new Track();
			track.setTitle("Track2");
			track.setDuration(78);
			session.save(track); 
			
			Music music = new Music();
			Artist artist = (Artist) session.get(Artist.class, 5);
			music.setArtist(artist);
			Category category = (Category) session.get(Category.class, 99);
			music.setCategory(category);
			
			music.setNumberOfTracks(67);
			music.setStockCount(8);
			music.setPrice(38.99);
			music.setTitle(title);
			music.getTracks().add(track);
			session.save(music); 
			
			//Query query = session.createQuery("from Music a where a.title='" + title + "'");
			//List<Music> musicList = (List<Music>) query.list();
			//assertNotNull(musicList);
			transaction.commit();
		}
		catch(Exception e){
			e.printStackTrace();
			fail("Music Save failed");
		}

	}

}
