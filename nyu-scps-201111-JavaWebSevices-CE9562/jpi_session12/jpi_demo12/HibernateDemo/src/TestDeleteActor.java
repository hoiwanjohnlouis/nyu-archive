

import model.Actor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class TestDeleteActor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction  transaction = session.beginTransaction(); 

		
		Actor actor = (Actor) session.get(Actor.class, 339);
		System.out.println(actor.getName());
		session.delete(actor);
		transaction.commit();
	}

}
