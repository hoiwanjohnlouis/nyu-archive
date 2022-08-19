public class MyClass10 {

	public static void main(String[] args) {
        byte b1 = 127;   	// works fine
        byte b2 = 2;   	// works fine
        byte b3 = (byte) (b1 + b2);
        System.out.println(b3); // prints -127
	}
}
