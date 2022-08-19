public class PingPongThread extends Thread{

	public void run(){
		try{
			//infinite loow
			for (int i=0; i<5;i++){
				// print the name of the thread followed by a thread.
				System.out.print(this.getName() + "\t");
				// goto sleep for any random interval between 0 to 1000 msec.
				sleep((int) (Math.random()*1000));
			}
		}
		// sleep method throws InterrupetedException
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
