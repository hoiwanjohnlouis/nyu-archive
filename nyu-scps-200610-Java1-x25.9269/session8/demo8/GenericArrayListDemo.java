import java.util.ArrayList;
import java.util.Iterator;

public class GenericArrayListDemo {
	public static void main(String[] args){
		ArrayList a = new ArrayList();
		a.add("Hi There");
		a.add("Hi There");
		a.add(9);
		a.add(new StringBuffer("What's up?"));
		a.add(8); // gets converted to Integer Wrapper
		a.add(23.4); // gets converted to Double Wrapper
		Iterator i = a.iterator();
		while (i.hasNext()){
			Object o = i.next();
			System.out.println(o);
		}
		int j = (Integer) a.get(2); // Object is casted to Integer, Integer is boxed to int
		System.out.println("J = " + j);

	}

}
