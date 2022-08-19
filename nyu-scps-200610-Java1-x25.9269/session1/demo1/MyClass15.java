public class MyClass15 {

	public static void main(String[] args) {
		int guess = 47;
		int found = (int) (Math.random()*100);
		while (guess!=found){
			System.out.println("Sorry, Random number did not match., you guessed: " + guess +" but the system  found: " + found); 
			found = (int) (Math.random()*100);
		}
		System.out.println("Random number matched!!!, it is indeed: " + found); 
	}
}
