import java.util.HashSet;
import java.util.Iterator;

public class TypeSafeHashSetDemo {
	public static void main(String[] args){
		HashSet<Integer> a = new HashSet<Integer>();
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
