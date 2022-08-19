// this code does not compile
public class MyClass8 {

	public static void main(String[] args) {
        byte b1 = 1;   	// works fine
        byte b2 = 2;   	// works fine
        byte b3 = b1 + b2; 	// gives an error because b1 and b2 are
                            // converted to int before the addition
                            // and the sum is certainly int.
	}
}
