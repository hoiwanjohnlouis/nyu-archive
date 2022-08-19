package tester;

import java.util.Iterator;
import java.util.List;

import model.Actor;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

import junit.framework.TestCase;

public class ActorTester extends TestCase {
	
	public void testSaveActor(){
		
		Transaction transaction = null; 
		try { 
			Session session = HibernateUtil.getSessionFactory().openSession(); 
			String name = "Actor2";
			transaction = session.beginTransaction(); 
			
			Actor actor = new Actor();
			actor.setName(name);
			session.save(actor);
			Query query = session.createQuery("from Actor a where a.name='" + name + "'");
			List<Actor> actorList = (List<Actor>) query.list();
			assertNotNull(actorList);
			transaction.commit();
		}
		catch(Exception e){
			e.printStackTrace();
			fail("Actor Save failed");
		}

	}

	public void testRetrieveActorByPrimaryKey(){
		
		try { 
			Session session = HibernateUtil.getSessionFactory().openSession();
			int actorId = 3;
			Actor actor = (Actor) session.get(Actor.class, actorId);
			assertNotNull(actor);
			assertEquals(actorId,actor.getId());
			System.out.print(actor.getId()+ "\t");
			System.out.println(actor.getName());
 		}
		catch(Exception e){
			e.printStackTrace();
			fail("Actor retrieve by id failed");
		}

	}

	public void testRetrieveActorByName(){
		
		try { 
			Session session = HibernateUtil.getSessionFactory().openSession(); 
			Query query = session.createQuery("from Actor a where a.name='Adrienne King'");
			List<Actor>	actorList = (List<Actor>) query.list();
			assertNotNull(actorList);
			Iterator<Actor> actorIterator = actorList.iterator();
			while (actorIterator.hasNext()){
				Actor actor = actorIterator.next();
				System.out.print(actor.getId()+ "\t");
				System.out.println(actor.getName());
				
			}
 		}
		catch(Exception e){
			e.printStackTrace();
			fail("Actor retrieve by name failed");
		}

	}
}
