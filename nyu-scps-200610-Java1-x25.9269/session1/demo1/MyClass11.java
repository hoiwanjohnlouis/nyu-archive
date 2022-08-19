public class MyClass11 {

	public static void main(String[] args) {
        int i = 2147483647;   	// works fine
        i = i+2;
        System.out.println(i); // prints -–2147483647
	}
}
