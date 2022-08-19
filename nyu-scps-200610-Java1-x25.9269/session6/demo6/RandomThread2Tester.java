public class RandomThread2Tester {

	/** Creates a random number generator thread and starts it.*/
	public static void main(String[] args)
	{
		System.out.println("main Method Started");
		System.out.println("Current Thread Name: " + Thread.currentThread().getName());
		RandomThread2 randomThread= new RandomThread2();
		randomThread.start();
		System.out.println("main Method Finished");
	}
}
