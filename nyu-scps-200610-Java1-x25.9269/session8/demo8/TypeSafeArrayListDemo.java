import java.util.ArrayList;
import java.util.Iterator;

public class TypeSafeArrayListDemo {
	public static void main(String[] args){
		ArrayList<StringBuffer> a = new ArrayList<StringBuffer>();
		a.add(new StringBuffer("What's up?"));
		a.add(new StringBuffer("How are you doing?"));
		a.add(new StringBuffer("What is going on?"));
		a.add(new StringBuffer("What's up?"));
	
		Iterator<StringBuffer> i = a.iterator();
		while (i.hasNext()){
			StringBuffer sb = i.next();
			System.out.println(sb);
		}
	}
}
