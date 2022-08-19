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
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.net.Socket;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.ObjectOutputStream;

import java.io.Serializable;

public class CommandRouter implements Serializable
{
    // serialVersionUID is required by JVM for serialization
    //whenever your class changes shape in a way that will be incompatible
    //with previously serialized versions, simply increment this number.
    public static final long serialVersionUID = 1;

    private Object obj = null;

    // to store server port number received as command line argument.
    private int serverPort = 0;

    // to store server IP address
    private InetAddress serverIP = null;

    // for client socket
    private Socket clientSocket = null;

    //variables to wrapup inputstream of the socket
    private InputStream socketInputStream = null;
    private ObjectInputStream ois = null;

    //variables to wrapup the outputstream of the socket
    private OutputStream socketOutputStream = null;
    private ObjectOutputStream oos  = null;

    // Default constructor
    public CommandRouter(){
        super();
    }

    public Command route(Command anyCommand) {
    {

        try{
            // convert server name received as command line
            // argument to InetAddress object.
            serverIP = InetAddress.getByName("localhost");

            // convert server port number received as command
            // line argument to int.
            serverPort=Integer.parseInt("7000");

            // create a socket object with server IP Address
            // and server port number
            clientSocket = new Socket(serverIP,serverPort);

            // show output
            System.out.println("Server IP Address: " + clientSocket.getInetAddress().getHostAddress());
            System.out.println("Server Port #: " + clientSocket.getPort());
            // get the output stream of the socket.
            System.out.println("Creating outputStream");
            socketOutputStream = clientSocket.getOutputStream();
            System.out.println("Creating objectOutputStream");
            oos = new ObjectOutputStream(socketOutputStream);

            // show the client port number assigned automatically
            System.out.println("Client IP Address: " + clientSocket.getLocalAddress().getHostAddress());
            System.out.println("Client Port #: " + clientSocket.getLocalPort());
            // get the input stream of the socket.
            System.out.println("Creating inputStream");
            socketInputStream = clientSocket.getInputStream();
            System.out.println("Creating objectInputStream");
            ois = new ObjectInputStream(socketInputStream);

            // infinite loop
            while (true)
            {
                // print before send
                System.out.println("Sending data to the server: " + anyCommand);
                // serialize the command to other side of socket
                oos.writeObject(anyCommand);

                // waiting for the server response.
                // code will block here until we hear back from the server
                try {
                    //
                    System.out.println("Waiting for the server ...");
                    obj = ois.readObject();

                    // print server response
                    System.out.println("Server Response: " + obj);

                    return (Command)obj;
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        // catch exceptions.
        catch (UnknownHostException e){
            System.out.println("Unknown host: localhost");
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        // close the outermost wrappers and socket
        finally{
            try{
                if (!(ois==null)){ois.close();}
                if (!(oos==null)){oos.close();}
                if (!(clientSocket==null)){clientSocket.close();}
                System.out.println("In CommandRouter.finalizer");
            }
            catch(Exception e){
                System.out.println(e);
            }
        }

        return anyCommand;
    }
}
}
