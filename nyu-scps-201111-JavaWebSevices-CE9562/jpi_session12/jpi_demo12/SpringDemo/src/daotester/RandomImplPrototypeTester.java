package daotester;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.RandomImpl;


public class RandomImplPrototypeTester {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/springconfig.xml");
		RandomImpl myRandom = (RandomImpl) context.getBean("prototype");
		System.out.println("Prototype Object Id: " + myRandom.getObjectId() + " random: " + myRandom.getRandom());

		RandomImpl yourRandom = (RandomImpl) context.getBean("prototype");
		System.out.println("Prototype Object Id: " + yourRandom.getObjectId() + " random: " + yourRandom.getRandom());
	}
}
