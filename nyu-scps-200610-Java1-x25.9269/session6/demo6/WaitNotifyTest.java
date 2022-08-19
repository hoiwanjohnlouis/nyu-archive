public class WaitNotifyTest
{

	public static void main(String[] args)
	{
		// create an object that will be shared by two threads.
		StringBuffer word = new StringBuffer("Ping");

		// create a ping thread with the shared object and assign a name.
		PingThread pingThread = new PingThread(word);
		pingThread.setName("PingThread");

		// create a pong thread with the shared object and assign a name.
		PongThread pongThread = new PongThread(word);
		pongThread.setName("PongThread");

		//start the threads.
		pingThread.start();
		pongThread.start();
	}
}
