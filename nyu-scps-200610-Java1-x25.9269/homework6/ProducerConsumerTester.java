import java.util.Vector;

public class ProducerConsumerTester
{

    public static void main(String[] args)
    {
        // create an object that will be shared by two threads.
        Vector queue = new Vector();
        StringBuffer completionFlag = new StringBuffer("N");

        // create a producer thread with the shared object and assign a name.
        ProducerThread producerThread = new ProducerThread(queue,completionFlag);
        producerThread.setName("ProducerThread");

        // create a consumer thread with the shared object and assign a name.
        ConsumerThread consumerThread = new ConsumerThread(queue,completionFlag);
        consumerThread.setName("ConsumerThread");

        //start the threads.
        producerThread.start();
        consumerThread.start();
    }
}
