public class PingPongThreadTester {

	public static void main (String[] args){
		// create one thread object.
		PingPongThread ping = new PingPongThread();
		// assign a name to the thread - Ping.
		ping.setName("Ping");
		// assign maximum priority for the thread - 10
		ping.setPriority(Thread.MAX_PRIORITY);


		// create the second thread object.
		PingPongThread pong = new PingPongThread();
		// assign a name - Pong.		
		pong.setName("Pong");
		// assign minimum priority - 1
		pong.setPriority(Thread.MIN_PRIORITY);

		//start both threads
		ping.start();
		pong.start();
	}
}
