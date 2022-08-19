package tester;

import java.util.Iterator;
import java.util.List;

import model.Actor;
import model.Artist;
import model.Category;
import model.Director;
import model.Music;
import model.Track;
import model.Video;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

import junit.framework.TestCase;

public class VideoAndActorTester extends TestCase {
	
	public void testSaveDirector(){
		
		Transaction transaction = null; 
		try { 
			Session session = HibernateUtil.getSessionFactory().openSession(); 
			String title = "music2";
			transaction = session.beginTransaction(); 
			
			
			Video video = new Video();
			Actor actor1 = (Actor) session.get(Actor.class, 1);
			Actor actor2 = (Actor) session.get(Actor.class, 2);
			video.getActors().add(actor1);
			video.getActors().add(actor2);

			Category category = (Category) session.get(Category.class, 89);
			video.setCategory(category);
			
			Director director = (Director) session.get(Director.class, 3);
			video.setDirector(director);

			video.setDuration(200);
			video.setPrice(34.99);
			video.setRating("PG");
			video.setStockCount(8);
			video.setTitle("Video");
			session.save(video);
			
			//Query query = session.createQuery("from Music a where a.title='" + title + "'");
			//List<Music> musicList = (List<Music>) query.list();
			//assertNotNull(musicList);
			transaction.commit();
		}
		catch(Exception e){
			e.printStackTrace();
			fail("Video Save failed");
		}

	}

}
