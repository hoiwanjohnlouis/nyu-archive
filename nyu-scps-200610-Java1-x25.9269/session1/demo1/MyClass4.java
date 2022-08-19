public class MyClass4 {
	public static void main(String[] args) {
		int p = 14;
        int q = 3;
        int r = p / q; 	// r will be 4 not 5
        int s = p % q;  // s will be 2 since 14/3 leaves 2 and remainder
        System.out.println(r);
        System.out.println(s);
	}
}
