public class MyClass9 {

	public static void main(String[] args) {
        byte b1 = 1;   	// works fine
        byte b2 = 2;   	// works fine
        byte b3 = (byte) (b1 + b2); //works fine because of casting
        System.out.println(b3); 
	}
}
