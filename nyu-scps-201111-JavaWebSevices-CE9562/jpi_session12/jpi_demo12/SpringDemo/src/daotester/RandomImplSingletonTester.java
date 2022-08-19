package daotester;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.RandomImpl;


public class RandomImplSingletonTester {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/springconfig.xml");
		RandomImpl myRandom = (RandomImpl) context.getBean("singleton");
		System.out.println("Singleton Object Id: " + myRandom.getObjectId() + " random: " + myRandom.getRandom());

		RandomImpl yourRandom = (RandomImpl) context.getBean("singleton");
		System.out.println("Singleton Object Id: " + yourRandom.getObjectId() + " random: " + yourRandom.getRandom());
	}
}
