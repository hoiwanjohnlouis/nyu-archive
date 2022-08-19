public class RandomThread2 extends Thread{ 
	public void run(){ 
		System.out.println("RandomThread Running");
		System.out.println("Current Thread Name: " + Thread.currentThread().getName());
		// temp variable to store random number
		int randomNumber;
		try{
			for (int i=0;i<10;i++){
				// generate a random number between 20 and 30
				randomNumber=(int) ((30 - 20 + 1) * Math.random() + 20);
				// print it
				System.out.print(randomNumber);
				// put the thread to sleep for 500 msec = 1/2 sec
				sleep(500);
				// print a tab
				System.out.print("\t");
			}
		}
		//sleep method throws this exception
		catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("RandomThread Finished");
	} 
}
