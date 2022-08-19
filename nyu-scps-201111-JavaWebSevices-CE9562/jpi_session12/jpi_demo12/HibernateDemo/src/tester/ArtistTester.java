package tester;

import java.util.Iterator;
import java.util.List;

import model.Artist;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

import junit.framework.TestCase;

public class ArtistTester extends TestCase {
	
	public void testSaveArtist(){
		
		Transaction transaction = null; 
		try { 
			Session session = HibernateUtil.getSessionFactory().openSession(); 
			String name = "Artist2";
			transaction = session.beginTransaction(); 
			
			Artist Artist = new Artist();
			Artist.setName(name);
			session.save(Artist);
			Query query = session.createQuery("from Artist a where a.name='" + name + "'");
			List<Artist> ArtistList = (List<Artist>) query.list();
			assertNotNull(ArtistList);
			transaction.commit();
		}
		catch(Exception e){
			e.printStackTrace();
			fail("Artist Save failed");
		}

	}

	public void testRetrieveArtistByPrimaryKey(){
		
		try { 
			Session session = HibernateUtil.getSessionFactory().openSession();
			int artistId = 3;
			Artist Artist = (Artist) session.get(Artist.class, artistId);
			assertNotNull(Artist);
			assertEquals(artistId,Artist.getId());
			System.out.print(Artist.getId()+ "\t");
			System.out.println(Artist.getName());
 		}
		catch(Exception e){
			e.printStackTrace();
			fail("Artist retrieve by id failed");
		}

	}

	public void testRetrieveArtistByName(){
		
		try { 
			Session session = HibernateUtil.getSessionFactory().openSession(); 
			Query query = session.createQuery("from Artist a where a.name='Cher'");
			List<Artist>	ArtistList = (List<Artist>) query.list();
			assertNotNull(ArtistList);
			Iterator<Artist> ArtistIterator = ArtistList.iterator();
			while (ArtistIterator.hasNext()){
				Artist Artist = ArtistIterator.next();
				System.out.print(Artist.getId()+ "\t");
				System.out.println(Artist.getName());
				
			}
 		}
		catch(Exception e){
			e.printStackTrace();
			fail("Artist retrieve by name failed");
		}

	}
}
