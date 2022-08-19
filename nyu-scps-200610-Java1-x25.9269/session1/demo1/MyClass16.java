public class MyClass16 {

	public static void main(String[] args) {
		int guess = 47;
		int found = 0;
        for(int i=0; i<100;i++)
        {
            found = (int) (Math.random()*100);
            System.out.println("Try #:" + i + " Random number: " + found + " Your guess: " + guess);
            if (guess == found)
            {
                System.out.println("Random number matched!!!, it is indeed: " + found);
            }
        }
	}
}
