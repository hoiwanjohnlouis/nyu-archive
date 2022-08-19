import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ListTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/springconfig.xml");
		List l = (List) context.getBean("myList");
		System.out.println(l.getClass().getName());
		l.add(5);
		System.out.println(l.get(0));
		
		

	}

}
