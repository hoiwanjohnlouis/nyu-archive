import java.util.Iterator;
import java.util.TreeSet;

public class TypeSafeTreeSetDemo {
	public static void main(String[] args){
		TreeSet<Integer> a = new TreeSet<Integer>();
		a.add(new Integer(8));
		a.add(new Integer(9));
		a.add(new Integer(8));
		a.add(new Integer(9));
		a.add(new Integer(11));
		Iterator<Integer> i = a.iterator();
		while (i.hasNext()){
			Integer sb = i.next();
			System.out.println(sb);
		}
	}
}
