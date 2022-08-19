package daotester;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.RandomIF;


public class RandomIFTester {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/springconfig.xml");
		RandomIF myRandom = (RandomIF) context.getBean("x");
		System.out.println("Object Id: " + myRandom.getObjectId() + " random: " + myRandom.getRandom());

		RandomIF yourRandom = (RandomIF) context.getBean("x");
		System.out.println("Object Id: " + yourRandom.getObjectId() + " random: " + yourRandom.getRandom());
	}
}
