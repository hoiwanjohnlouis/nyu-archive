import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.RandomServiceIF;
import service.RandomServiceImpl;


public class RandomServiceImplTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/springconfig.xml");

		RandomServiceIF service = (RandomServiceIF) context.getBean("y");
		System.out.println(service.findRandom());

	}

}
