import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class TypeSafeHashMapDemo {
	public static void main(String[] args){
		HashMap<Integer,String> a = new HashMap<Integer,String>();
		a.put(1,"What's up?");
		a.put(2,"How are you doing?");
		a.put(2,"What's up?");
		a.put(4,"What is going on?");
		a.put(5,"What's up?");
		String message = a.get(4);
		System.out.println("Key: 4 " + "Value: " + message);
		Set<Entry<Integer,String>> s = a.entrySet();
		Iterator<Entry<Integer,String>> i = s.iterator();
		while (i.hasNext()){
			Entry e = i.next();
			System.out.print(e.getKey()+"\t");
			System.out.println(e.getValue());
		}
	}
}
