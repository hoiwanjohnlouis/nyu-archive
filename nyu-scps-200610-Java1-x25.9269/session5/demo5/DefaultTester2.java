//this class does not compile
import mypackage.ClassWithDefaultMembers;

public class DefaultTester2 {

	public static void main(String[] args) {
		ClassWithDefaultMembers o = new ClassWithDefaultMembers();
		System.out.println(o.random);
		System.out.println(o.getDate);
	}

}
