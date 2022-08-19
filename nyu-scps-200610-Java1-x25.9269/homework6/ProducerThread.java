//  JAVA 1, HOMEWORK 6
//
//  HOI WAN JOHN LOUIS
//
//  Homework:
//  Reading:
//
//  Topic               Just Java 2     Head First Java
//  Threads         Chapter 13,14       Chapter 15
//
//  Programming Assignment:
//
//  Coding Policy:
//
//  1.  You must follow a naming convention.
//  2.  You must have enough JavaDoc comments as well
//      as regular comments(if applicable) in your code.
//
//  You need to create two threads:
//
//  1) ProducerThread
//  2) ConsumerThread
//
//  Both would have a constructor that will receive two arguments:
//      1) Vector
//      2) StringBuffer
//
//  The Vector is for holding shared data and the StringBuffer
//  is for completion flagging. Initially the vector is passed
//  empty and the StringBuffer is set to “N”.
//
//  The ProducerThread’s run has a loop that iterate 3 times.
//      Inside the loop, the run method checks if the vector
//      is empty. If it is, it will get a random number ‘x’
//      between 1 and 10. The run method then gets ‘x’ number
//      of random numbers between 20 and 30, displays the number
//      on your screen and inserts them into the vector and
//      notify other threads that it is done. If the vector,
//      is not empty then the produce method just waits. You
//      can use the following formula to get random numbers
//      between a range:
//
//  (int) ((Upperbound - Lowerbound+ 1) * Math.random() + Lowerbound)
//
//  At the end of 3 iteration, the ProducerThread sets the StringBuffer to “Y”.
//
//
//  The ConsumerThead’s run method is in an infinite loop.
//      Within the loop the run method checks if the vector
//      is empty. If it is, it checks if the StringBuffer
//      is “Y”. If it is – the program exits. If the
//      ProducerThread is not done the ConsumerThread
//      just waits.  If the vector is not empty, the
//      consume method retrieves at most three items
//      in FIFO (First In First Out) order from the
//      vector, displays the numbers on your screen
//      and removes them from the vector. If there
//      are less then three items – the consumer
//      consumes all. If there are more than or
//      equal to three items, the consumer consumes
//      three items.
//
//  Please make sure that you don’t change the wait loop to
//      an If statement. That’s incorrect solution.
//
//
//  To make sure that your code is “thread-safe” –
//      change the wait() calls in your code to wait(10)
//      (wait for 10 ms) and then recompile and rerun.
//      Examine the output and make sure that your code still works.
//
//  Your code may occasionally not exit properly and get stuck at the end.
//  If you want to fix this problem, you have to add an extra notifyAll()
//      at the end of producer code. If you can’t fix this problem – that’s OK.
//

import java.util.Vector;

/**
 * @author shrimp
 *
 */
public class ProducerThread extends Thread {

    private Vector<Object>       queue;
    private StringBuffer         completionFlag;

    private final int Upperbound = 30;
    private final int Lowerbound = 20;

    private final int WAIT_LIMIT = 2000;    // wait two second

    // used to turn off tracing for this class
    private boolean DEBUG = true;

    /**
     *
     */
    public ProducerThread() {
        // TODO Auto-generated constructor stub
        this(null, null);
    }

    /**
     * @param Vector queue
     * @param StringBuffer completionFlag
     */
    public ProducerThread(Vector anyQueue, StringBuffer anyCompletionFlag) {
        setQueue(anyQueue);
        setCompletionFlag(anyCompletionFlag);
    }

    /**
     *  The ProducerThread’s run has a loop that iterate 3 times.
     *  Inside the loop, the run method checks if the vector
     *  is empty. If it is, it will get a random number ‘x’
     *  between 1 and 10. The run method then gets ‘x’ number
     *  of random numbers between 20 and 30, displays the number
     *  on your screen and inserts them into the vector and
     *  notify other threads that it is done. If the vector,
     *  is not empty then the produce method just waits. You
     *  can use the following formula to get random numbers
     *  between a range:
     *
     */
    public void run() {
        //
        int i = 0;
        int j = 0;
        int x = 0;
        int randomNumber = 0;

        try {
            //  do the loop 3 times like the instructions say.
            //  starts from 1
            LOOP:
            for (i = 1; i <= 3; i++) {
                Debugger(DEBUG, "In " + this.getName() + " starting interation[" + i + "]");
                SYNCHRONIZED_LOOP:
                synchronized(queue) {
                    // only fill empty queues
                    while(!queue.isEmpty()) {
                        // wait a while tp give the consumer time to read the queue
                        Debugger(DEBUG, "In " + this.getName() + " continuing interation[" + i + "], synchronized block. waiting for queue to empty");
                        queue.wait(WAIT_LIMIT);
                    }

                    x = (int) ((Math.random() * 10) + 1);
                    Debugger(DEBUG, "In " + this.getName() + " continuing interation[" + i + "], synchronized block. Producing [" + x + "] random numbers for the queue");

                    // generate "x" random numbers and insert them to queue.
                    for (j = 0; j < x; j++) {
                        randomNumber = (int) ( ((Upperbound - Lowerbound + 1) * Math.random()) + Lowerbound );
                        Object obj = new Integer(randomNumber);
                        queue.addElement(obj);
                        Debugger(DEBUG, "In " + this.getName() + " continuing interation[" + i + "], synchronized block. while loop. Adding Random[" + (j + 1)+ "] number[" + randomNumber + "]");
                    }

                    // wait a while tp give the consumer time to read the queue
                    Debugger(DEBUG, "In " + this.getName() + " continuing interation[" + i + "], synchronized block. notifying...");
                    queue.notifyAll();

                }   //  END synchronized(queue) {
            }   //  LOOP:   for (i = 1; i <= 3; i++) {


            /**
             * Let everyone know we're done filling up the queue.
             */
            completionFlag.replace(0,1,"Y");
            Debugger(DEBUG, "In " + this.getName() + " DONE.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }   //  END try

    }

    /**
     * @return the completionFlag
     */
    public StringBuffer getCompletionFlag() {
        return completionFlag;
    }

    /**
     * @param completionFlag the completionFlag to set
     */
    public void setCompletionFlag(StringBuffer completionFlag) {
        this.completionFlag = completionFlag;
    }

    /**
     * @return the queue
     */
    public Vector getQueue() {
        return queue;
    }

    /**
     * @param queue the queue to set
     */
    public void setQueue(Vector queue) {
        this.queue = queue;
    }

    /**
     * Centralized debugger logger to default output
     */
    public static void Debugger (boolean DEBUG, String msg) {
        if  (DEBUG) {
            System.out.println(msg);
        }
    }

}
