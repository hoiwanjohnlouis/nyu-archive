public class RandomRunable implements Runnable
{ 
	public void run() 
	{ 
		// temp variable to store random number
		int randomNumber;
		System.out.println("RandomRun Running");
		System.out.println("Current Thread Name: " + Thread.currentThread().getName());
		try{
			for (int i=0;i<10;i++){
			// generate a random number between 20 and 30
			randomNumber=(int) ((30 - 20 + 1) * Math.random() + 20);
			// print it
			System.out.print(randomNumber);

			// put the thread to sleep for 500 msec = 1/2 sec
			Thread.sleep(1000);

			// print a tab
			System.out.print("\t");
			}
		}
		//sleep method throws this exception
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
