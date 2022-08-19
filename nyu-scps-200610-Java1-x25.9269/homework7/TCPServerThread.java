//  JAVA 1, HOMEWORK 7, Part I
//
//  HOI WAN JOHN LOUIS
//
//  Homework:
//  Reading:
//  Just Java:
//  Chapter 22 – Networking in Java
//
//  Programming Assignment:
//
//  Coding Policy:
//
//  1.  You must follow a naming convention.
//  2.  You must have enough JavaDoc comments as well as regular comments (if applicable) in your code.
//
//  This homework carries 15 Points!!!!!!!!!!!!!
//
//  Part2 - TCP/IP
//  There is a design pattern in Object Oriented Programming called "Command Pattern".
//
//  You will implement a specific command pattern called "Distributed Command Pattern".
//
//  Let me see if I could give you an analogy.
//  Let's assume you have acquired a recipe for a delicious food but
//  you don't have necessary cookware to cook it but you decided
//  to buy all the ingredients anyway. You then walked up to a
//  restaurant.  You gave your recipe and all the ingredients to
//  the waiter and asked him to serve the food. The waiter delivered
//  your stuff to the chef. The chef requested one of the assistants
//  to do the actual cooking but supervised it. Few minutes later,
//  the cook gave the food back to the waiter and the waiter served
//  the food. This would be classical example of distributed command.
//  Your command was executed in a remote place (restaurant's kitchen).
//
//  Similar to the analogy above, let's assume you have a BankAccount
//  and you know how to calculate interest on the account but interest
//  calculation takes a very long time on your machine. You don't want
//  to do the computation on your machine. You want to write down the
//  instruction for interest calculation and ship it along with your
//  BankAccount to a powerful server. The server executes you interest
//  calculation instruction, saves the result in your BankAccount and
//  returns back the BankAccount with calculated interest saved on the
//  BankAccount. That would be an example of "Distributed Command" pattern.
//
//  1. Here is bank account: see session.doc from session7
//
//  2. Define an interface called Command that has only one method
//      "execute" as follows: see session.doc from session7
//
//  3. Create a sub-class of BankAccount called "CalculateInterestCommand"
//      that implements Command interface as follows:
//
//  4. The execute method above is your recipe and CalculateInterestCommand
//      is your ingredients for food. Create a class called CommandRouter
//      (equivalent of waiter) that is nothing but TCP/IP client.
//      The CommandRouter that has the following method:
//
//      public Command route(Command anyCommand)
//
//  This method will send any Command to the ThreadedCommandServer
//  (equivalent of chef) and receive the Command back from the server.
//
//  5. Write a ThreadedCommandServer that will receive any command,
//      hand it off to CommandServerThread and call execute on this.
//      When done the server will return the command object back to
//      the router (caller).
//
//  6. Write a tester that will create a CalculateInterestCommand,
//      populate it and forward it to a ComamandRouter for routing.
//      When the CalculateInterestCommand (cooked food) returns,
//      the returned CalculateInterestCommand would have the interest
//      amount populated in it and tester would print it by calling
//      getInterestAmount.
//
//  Needless to say, this requires object serialization and deserialization.
//
//  Here is an expected output:
//
//  Account Number: 1
//  Balance: 8000.0
//  Interest Rate: 4.0
//
//  Interest Amount BEFORE Server Connection: 0.0
//  Client IP Address: 127.0.0.1
//  Client Port #: 3491
//  Server IP Address: 127.0.0.1
//  Server Port #: 7000
//  Sending Command to Server
//  Waiting for the server ...
//  Interest Amount AFTER Server Connection: 320.0
//
//  7. I also gave you Mortgage and MortgageCommand.
//      Write a tester MortgageCommandTester that will follow
//      the same protocol and generate the following output:
//
//  Loan Amount: 500000
//  Interest Rate: 6.0
//  # of Years: 30
//
//  Mortgage Amount BEFORE Server Connection: 0
//  Client IP Address: 127.0.0.1
//  Client Port #: 3494
//  Server IP Address: 127.0.0.1
//  Server Port #: 7000
//  Sending Command to Server
//  Waiting for the server ...
//  Mortgage Amount AFTER Server Connection: 2998
//
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import java.io.Serializable;

public class TCPServerThread extends Thread implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Socket  socket = null;

    private Object  obj    = null;
    private Command cmd    = null;

    /** Constructor that receives a Socket connected to Client.
    * @param anySocket Socket connected to client.
    */
    public TCPServerThread(Socket anySocket)
    {
        super();
        socket = anySocket;
        System.out.println("\t" + Thread.currentThread() + " " + "created for socket " + socket.getPort());
    }

    /** Overridden run method that sends data to and receives data from client.*/
    public void run()
    {

        //loop variable
        boolean forever=true;

        //io variables
        InputStream inputStream = null;
        ObjectInputStream ois = null;
        OutputStream outputStream = null;
        ObjectOutputStream oos  = null;

        try{
            // show client IP info.
            System.out.println("\t" + Thread.currentThread() + " " + "Client IP Address #: " + socket.getInetAddress().getHostAddress());

            // show port info.
            System.out.println("\t" + Thread.currentThread() + " " + "Client Port #: " + socket.getPort());

            // get the input stream of the socket.
            System.out.println("\t" + Thread.currentThread() + " " + "Creating inputStream");
            inputStream = socket.getInputStream();
            // get the output stream of the socket.
            System.out.println("\t" + Thread.currentThread() + " " + "Creating outputStream");
            outputStream = socket.getOutputStream();

            //
            System.out.println("\t" + Thread.currentThread() + " " + "Creating objectInputStream");
            ois = new ObjectInputStream(inputStream);
            System.out.println("\t" + Thread.currentThread() + " " + "Creating objectOutputStream");
            oos = new ObjectOutputStream(outputStream);

            while (forever)
            {
                // print before receive
                System.out.println("\t" + Thread.currentThread() + " " + "Waiting for the client input ...");

                //waiting for the client input.
                // for test purposes, just echo back the data
                try {
                    obj = ois.readObject();
                    System.out.println("\t" + Thread.currentThread() + " " + "got client input " + obj.toString());

                    // we should have more stuff here...
                    // like executed the method we want
                    // ...obj
                    cmd = (Command)obj;
                    System.out.println("\t" + Thread.currentThread() + " " + "casting client input to command " + cmd.toString());
                    cmd.execute();

                    // send back the updated data
                    System.out.println("\t" + Thread.currentThread() + " " + "returning client input " + cmd.toString());
                    oos.writeObject(obj);
                    return;
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        catch (IOException e){
            System.out.println("\t" + Thread.currentThread() + " " + "Closing Port #: " + socket.getPort());
        }
        // close the outermost wrappers and socket
        finally{
            try{
                System.out.println("\t" + Thread.currentThread() + " " + "Closing Socket to port: " + socket.getPort());
                if (!(ois==null)){ois.close();}
                if (!(oos==null)){oos.close();}
                if (!(socket==null)){socket.close();}
                System.out.println("\t" + Thread.currentThread() + " " + "In TCPServerThread.finalizer");
                System.out.println("\t" + Thread.currentThread() + " " + "Done");
            }
            catch(Exception e){
                System.out.println(e);
            }
        }

        System.out.println("\t" + Thread.currentThread() + " " + "SHOULD NOT BE HERE");
    }
}
