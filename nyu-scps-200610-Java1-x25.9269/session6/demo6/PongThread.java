public class PongThread extends Thread{
	/** A field to store the object received by the constructor.*/
	private StringBuffer word;
	
	/** Constructor that receives StringBuffer Object.
	*/
	PongThread(StringBuffer word){
		this.word=word;
	}

	/** The overridden run method.*/
	public void run()
	{
		try{
			//loop four times.
			for (int n = 1; n <=4 ; n++){
				System.out.println("In "+ this.getName() + " starting iteration: " + n);
				synchronized(word){
					while(word.toString().equals("Ping")){
						System.out.println("In "+ this.getName() + "," + " continuing iteration: " + n + " while loop, word is: " + word);
						System.out.println("In "+ this.getName() + "," + " continuing iteration: " + n + " synchronized block, going to wait...");
						word.wait();
					}

					// print "Pong"
					System.out.println("In "+ this.getName() +"," + " continuing iteration: " + n + " Printing: " + word);

					System.out.println("In "+ this.getName() + "," + " continuing iteration: " + n + " synchronized block, replacing...");
					// change "Pong" to "Ping"
					word.replace(1,2,"i");
					// notify ping.
					System.out.println("In "+ this.getName() + "," + " continuing iteration: " + n + " synchronized block, notifying...");
					word.notifyAll();
				}
			}
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}

         