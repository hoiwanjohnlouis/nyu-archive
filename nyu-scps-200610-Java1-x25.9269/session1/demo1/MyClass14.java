public class MyClass14 {

	public static void main(String[] args) {
		int guess = 47;
		int found = (int) (Math.random()*100);
		System.out.println((guess==found)? "Random number matched!!!, it is indeed: " + found : "Sorry, Random number did not match., you guessed: " + guess +" but the system  found: " + found); 
	}
}
