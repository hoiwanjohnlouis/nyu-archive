import java.util.Date;

public class ProtectedTester3 {

	public static void main(String[] args) {
		ClassWithProtectedAccess o = new ClassWithProtectedAccess();
		System.out.println(o.randomPlusFive);
		
		System.out.println(o.isFuture(new Date(1)));
	}

}
