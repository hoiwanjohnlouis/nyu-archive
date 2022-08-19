

import model.Actor;
import model.Artist;
import model.Category;
import model.Director;
import model.Music;
import model.Track;
import model.Video;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		Transaction transaction = null; 
		try { 
			transaction = session.beginTransaction(); 


 			Actor actor = new Actor();
			actor.setName("Actor1");
			session.saveOrUpdate(actor);
			
			Actor a = (Actor) session.get(Actor.class, 336);
			System.out.println(a.getName());
			a.setName(a.getName()+ "1");
			session.saveOrUpdate(a);
			
			Actor a2 = (Actor) session.get(Actor.class, 337);
			System.out.println(a2.getName());
			session.delete(a2);
			
/*			Artist artist = new Artist();
			artist.setName("Artist1");
			session.save(artist); 
*/
 			Actor actor1 = new Actor();
			actor1.setName("Actor1");
			session.saveOrUpdate(actor1);

			Actor actor2 = new Actor();
			actor2.setName("Actor2");
			session.saveOrUpdate(actor2); 

			Director director = new Director();
			director.setName("Director1");
			session.save(director); 
			
			Category category = new Category();
			category.setName("Category1");
			category.setType("Type1");
			session.save(category); 

			
			Video video = new Video();
			video.getActors().add(actor1);
			video.getActors().add(actor2);
			video.setCategory(category);
			video.setDirector(director);
			video.setDuration(200);
			video.setPrice(34.99);
			video.setRating("PG-13");
			video.setStockCount(8);
			video.setTitle("Video");
			session.save(video);

/*
 			Track track = new Track();
			track.setTitle("Track1");
			track.setDuration(78);
			session.save(track); 
			
			Music music = new Music();
			music.setArtist(artist);
			music.setCategory(category);
			music.setNumberOfTracks(67);
			music.setStockCount(8);
			music.setTitle("music1");
			music.getTracks().add(track);
			session.save(music); 

 */
			transaction.commit(); 
		} catch (HibernateException e) { 
			e.printStackTrace(); 
			transaction.rollback(); 
		} finally { 
		session.close(); 
		} 
	}

}
