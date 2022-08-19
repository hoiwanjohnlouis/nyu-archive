package mypackage;

public class ProtectedTester1 {

	public static void main(String[] args) {
		ClassWithProtectedMembers o = new ClassWithProtectedMembers();
		System.out.println(o.random);
		System.out.println(o.getDate());
	}

}
