package servicetester;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.RandomServiceIF;

import dao.RandomIF;


public class SpringServiceTester {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/springconfig.xml");
		RandomServiceIF myRandom = (RandomServiceIF) context.getBean("y");
		System.out.println("random: " + myRandom.findRandom());

		RandomServiceIF yourRandom = (RandomServiceIF) context.getBean("y");
		System.out.println("random: " + yourRandom.findRandom());

		
	}

}
