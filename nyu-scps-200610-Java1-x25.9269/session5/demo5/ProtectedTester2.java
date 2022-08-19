//this class does not compile
import mypackage.ClassWithProtectedMembers;

public class ProtectedTester2 {

	public static void main(String[] args) {
		ClassWithProtectedMembers o = new ClassWithProtectedMembers();
		System.out.println(o.random);
		System.out.println(o.getDate);
	}

}
