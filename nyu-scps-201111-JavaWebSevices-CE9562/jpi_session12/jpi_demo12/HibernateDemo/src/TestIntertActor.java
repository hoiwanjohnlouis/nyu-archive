

import model.Actor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class TestIntertActor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction  transaction = session.beginTransaction(); 

		
		Actor actor = new Actor();
		actor.setName("JPI Class Test");
		session.saveOrUpdate(actor);
		transaction.commit();

	}

}
