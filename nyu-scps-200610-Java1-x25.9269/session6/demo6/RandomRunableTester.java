public class RandomRunableTester {

	public static void main(String[] args)
	{
		System.out.println("main Method Started");
		System.out.println("Current Thread Name: " + Thread.currentThread().getName());
		RandomRunable randomRunable= new RandomRunable();
		Thread thread = new Thread(randomRunable);
		thread.start();
		System.out.println("main Method Finished");
	}
 
}
