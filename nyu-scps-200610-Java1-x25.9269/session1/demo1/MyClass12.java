public class MyClass12 {

	public static void main(String[] args) {
		int guess = 47;
		int found = (int) (Math.random()*100);
		if (guess==found ) 
		{
			System.out.println("Random number matched!!!, it is indeed: " + found);
		}
		else
		{
			System.out.println("Sorry, Random number did not match., you guessed: " + guess +" but the system  found: " + found );
		}
	}
}
