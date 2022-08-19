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
//  Part1 - UDP/IP
//
//  Write UDPHelloClient and UDPHelloServer that works like my TCP IP example above.
//  The client sends a name to the server, the server returns "Hello " + UpperCase<Name>.
//
//  Server Port: 7000
//  Waiting for any client ...
//  Received a Packet from Client IP Address: 127.0.0.1
//  Received a Packet from Client Port: 1528
//  Received Client Name: John
//  Sending to Server: "Hello JOHN" at IP Address: 127.0.0.1 at Port: 1528
//  Waiting for any client ...
//  Received a Packet from Client IP Address: 127.0.0.1
//  Received a Packet from Client Port: 1528
//  Received Client Name: Kim
//  Sending to Server: "Hello KIM" at IP Address: 127.0.0.1 at Port: 1528
//  Waiting for any client ...
//
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class UDPServer
{
    public static void main(String[] args)
    {
        if (args.length != 1)
        {
            System.out.println("Usage: UDPServer <This Server's Port Number>" );
            System.exit(0);
        }

        // byte array for Client Data that will be received.
        byte[] clientRawData = null;

        //
        byte[] clientGreeting = null;

        // String to convert byte array to string - client data.
        String clientString = null;

        // empty packet for data received from client.
        DatagramPacket clientPacket = null;

        //socket for the server.
        DatagramSocket serverSocket=null;

        // to store server port number received as command line argument.
        int serverPort = 0;

        try{

            // convert server port number received as command.
            // this is the port number promised to the client.
            serverPort=Integer.parseInt(args[0]);

            // create a socket object with the port number
            // promised to the client.
            serverSocket = new DatagramSocket(serverPort);

            // show the server port number.
            // should be exactly the same we got from the command prompt
            System.out.println("Server Port: " + serverSocket.getLocalPort());

            // infinite loop
            while (true)
            {
                // initialize byte array for Client.
                clientRawData = new byte[256];

                // create an empty packet using empty byte array
                // for receiving client data.
                clientPacket= new DatagramPacket(clientRawData,clientRawData.length);

                // print wait state.
                System.out.println("Waiting for any client ..." );

                // wait in receive mode.
                // your code will block here until the
                // server receive a packet from a client.
                serverSocket.receive(clientPacket);

                // print as soon as receive occurs.
                System.out.println("Received a Packet from Client IP Address: " + clientPacket.getAddress().getHostAddress());
                System.out.println("Received a Packet from Client Port: " + clientPacket.getPort());

                // Let's get the client data and convert to string.
                clientString=new String(clientPacket.getData());

                // get rid of leading and trailing spaces.
                clientString = clientString.trim();
                System.out.println("Received Client Name: " + clientString);

                // create a greeting
                clientString="Hello " + clientString.toUpperCase() + "!";
                clientGreeting = new byte[256];
                clientGreeting = clientString.getBytes();

                // assign it back.
                clientPacket.setData(clientGreeting);

                // log the reply
                System.out.println("Sending to Client: " + clientString
                        + " at IP Address: " + clientPacket.getAddress().getHostAddress()
                        + " at Port: " + clientPacket.getPort());

                // Send a hardy greeting
                serverSocket.send(clientPacket);

            }
        }
        // catch exceptions.
        catch (IOException e){
            e.printStackTrace();
        }
        //close the socket
        finally{
            if (!(serverSocket==null)){
                serverSocket.close();
            }
        }
    }
}

