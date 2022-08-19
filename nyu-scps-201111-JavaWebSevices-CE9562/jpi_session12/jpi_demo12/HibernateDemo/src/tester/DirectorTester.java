package tester;

import java.util.Iterator;
import java.util.List;

import model.Director;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

import junit.framework.TestCase;

public class DirectorTester extends TestCase {
	
	public void testSaveDirector(){
		
		Transaction transaction = null; 
		try { 
			Session session = HibernateUtil.getSessionFactory().openSession(); 
			String name = "Director2";
			transaction = session.beginTransaction(); 
			
			Director Director = new Director();
			Director.setName(name);
			session.save(Director);
			Query query = session.createQuery("from Director a where a.name='" + name + "'");
			List<Director> DirectorList = (List<Director>) query.list();
			assertNotNull(DirectorList);
			transaction.commit();
		}
		catch(Exception e){
			e.printStackTrace();
			fail("Director Save failed");
		}

	}

	public void testRetrieveDirectorByPrimaryKey(){
		
		try { 
			Session session = HibernateUtil.getSessionFactory().openSession();
			int DirectorId = 3;
			Director Director = (Director) session.get(Director.class, DirectorId);
			assertNotNull(Director);
			assertEquals(DirectorId,Director.getId());
			System.out.print(Director.getId()+ "\t");
			System.out.println(Director.getName());
 		}
		catch(Exception e){
			e.printStackTrace();
			fail("Director retrieve by id failed");
		}

	}

	public void testRetrieveDirectorByName(){
		
		try { 
			Session session = HibernateUtil.getSessionFactory().openSession(); 
			Query query = session.createQuery("from Director a where a.name='Chris Columbus'");
			List<Director>	DirectorList = (List<Director>) query.list();
			assertNotNull(DirectorList);
			Iterator<Director> DirectorIterator = DirectorList.iterator();
			while (DirectorIterator.hasNext()){
				Director Director = DirectorIterator.next();
				System.out.print(Director.getId()+ "\t");
				System.out.println(Director.getName());
				
			}
 		}
		catch(Exception e){
			e.printStackTrace();
			fail("Director retrieve by name failed");
		}

	}
}
