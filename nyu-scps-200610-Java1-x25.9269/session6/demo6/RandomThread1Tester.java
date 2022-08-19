public class RandomThread1Tester {

	/** Creates a random number generator thread and starts it.*/
	public static void main(String[] args)
	{
		System.out.println("main Method Started");
		RandomThread1 randomThread= new RandomThread1();
		randomThread.start();
		System.out.println("main Method Finished");
	}
}
