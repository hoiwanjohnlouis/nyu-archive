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
//

import java.util.Vector;


/**
 * @author shrimp
 *
 */
public class ConsumerThread extends Thread {

    private Vector       queue;
    private StringBuffer completionFlag;

    private final int    WAIT_LIMIT = 2000; // wait 2 seconds

    // used to turn off tracing for this class
    private boolean DEBUG = true;

    /**
     *
     */
    public ConsumerThread() {
        // TODO Auto-generated constructor stub
        this(null, null);
    }

    /**
     * @param Vector queue
     * @param StringBuffer completionFlag
     */
    public ConsumerThread(Vector anyQueue, StringBuffer anyCompletionFlag) {
        setQueue(anyQueue);
        setCompletionFlag(anyCompletionFlag);
    }

    /**
     *  The ConsumerThead’s run method is in an infinite loop.
     *  Within the loop the run method checks if the vector
     *  is empty. If it is, it checks if the StringBuffer
     *  is “Y”. If it is – the program exits. If the
     *  ProducerThread is not done the ConsumerThread
     *  just waits.  If the vector is not empty, the
     *  consume method retrieves at most three items
     *  in FIFO (First In First Out) order from the
     *  vector, displays the numbers on your screen
     *  and removes them from the vector. If there
     *  are less then three items – the consumer
     *  consumes all. If there are more than or
     *  equal to three items, the consumer consumes
     *  three items.
     *
     */
    public void run() {
        //
        int i = 0;
        int j = 0;

        int idx = 0;

        try {
            LOOP:
            while(true) {
                i++;
                Debugger(DEBUG, "In " + this.getName() + " starting interation[" + i + "]");
                SYNCHRONIZED_LOOP:
                synchronized(queue) {
                    // only fill empty queues
                    while(queue.isEmpty()) {
                        Debugger(DEBUG, "In " + this.getName() + " continuing interation[" + i + "], synchronized block. while loop. is queue empty? true");
                        if  (completionFlag.charAt(0) == 'N') {
                            Debugger(DEBUG, "In " + this.getName() + " continuing interation[" + i + "], synchronized block. while loop. is complete? false");
                            Debugger(DEBUG, "In " + this.getName() + " continuing interation[" + i + "], synchronized block. while loop. waiting for more data");
                            // wait for some more data
                            queue.wait(WAIT_LIMIT);
                        }
                        else {
                            Debugger(DEBUG, "In " + this.getName() + " continuing interation[" + i + "], while loop. is complete? true");
                            break LOOP;
                        }
                    }
                    idx = queue.size();
                    Debugger(DEBUG, "In " + this.getName() + " continuing interation[" + i + "], synchronized block. Consuming [" + idx + "] elements");
                    // free up queue elements 3 at a time
                    if  (idx > 3) {
                        idx = 3;
                    }
                    for (j = 0; j < idx; j++) {
                        Object obj = queue.firstElement();
                        queue.removeElement(obj);
                        Debugger(DEBUG, "In " + this.getName() + " continuing interation[" + i + "], synchronized block. removed [" + obj + "] from queue");
                    }

                    // let the otherside know we're done
                    Debugger(DEBUG, "In " + this.getName() + " continuing interation[" + i + "], synchronized block. notifying...");
                    queue.notifyAll();

                }   //  end synchronized()
            }   //  end WHILE

            // break after LOOP:
            Debugger(DEBUG, "In " + this.getName() + " DONE.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }   //  end try {
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
