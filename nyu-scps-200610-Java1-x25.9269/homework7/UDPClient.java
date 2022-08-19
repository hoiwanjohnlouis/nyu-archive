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
//  Here is client output:
//
//  Local Port: 1528
//  Enter your name: John
//  Sending to Server: "John" at IP Address: 127.0.0.1 at Port: 7000
//  Waiting for the server ...
//  Received a Packet from Server IP Address: 127.0.0.1
//  Received a Packet from Server Port: 7000
//  Received Server Greeting: Hello JOHN
//  Enter your name: Kim
//  Sending to Server: "Kim" at IP Address: 127.0.0.1 at Port: 7000
//  Waiting for the server ...
//  Received a Packet from Server IP Address: 127.0.0.1
//  Received a Packet from Server Port: 7000
//  Received Server Greeting: Hello KIM
//  Enter your name:
//
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
public class UDPClient
{
    public static void main(String[] args)
    {
        // if not two command line arguments found - display usage message.
        if (args.length != 2)
        {
            System.out.println("Usage: UDPClient <Server's Symbolic Name> <Server'sM Port Number>" );
            System.exit(0);
        }

        // byte array for Client Data that will be send
        byte[] clientNameRawData = null;

        // String to convert byte array to string - client data.
        String clientNameString = null;

        //
        String serverReply = null;

        //socket.
        DatagramSocket clientSocket = null;

        // packet for client send data.
        DatagramPacket clientPacket = null;

        // to store server IP address.
        InetAddress serverIP = null;
        // to store server port number received as command line argument.
        int serverPort = 0;

        try{

            // create a socket object for the client.
            // notice the datagramSocket is not using the IPAddress
            // or the port number - those will be used in the outgoing packet.
            clientSocket = new DatagramSocket();

            // show the client port number assigned by the system
            System.out.println("Local Port: " + clientSocket.getLocalPort());

            // send client name as many times as you want
            // until you hit just Enter Key.
            while(true){
                // prompt user to input
                System.out.print("Enter your name: ");

                // initialize byte array.
                clientNameRawData = new byte[256];

                // get user input into byte array.
                System.in.read(clientNameRawData);

                // convert the byte array to String
                clientNameString= new String(clientNameRawData);

                // get rid of leading and trailing spaces
                clientNameString= clientNameString.trim();

                // if the client hits enter exit
                if (clientNameString.length()==0){
                    return;
                }

                // convert server name received as command line
                // argument to InetAddress object.
                serverIP = InetAddress.getByName(args[0]);

                // convert server port number received as command
                // line argument to int.
                serverPort=Integer.parseInt(args[1]);

                // create a packet using user input,
                // server IP address and server port number.
                // the packet is signed, sealed and ready
                // to be delivered - if you know what I mean.
                clientPacket= new DatagramPacket(clientNameRawData,
                clientNameRawData.length,serverIP,serverPort);

                // print info. on send data
                // getAddress() will give you the InetAddress object that represents the
                // other machine. Calling getHostAddress() on this object will actually
                // print it in "a.b.c.d" format.
                System.out.println("Sending to Server: " + "\"" + clientNameString
                        + "\"" + " at IP Address: "
                        + clientPacket.getAddress().getHostAddress()
                        + " at Port: " + clientPacket.getPort());

                    // send the packet using the socket
                    clientSocket.send(clientPacket);

                    // waiting for reply.
                    System.out.println("Waiting for the server ..." );

                    // wait in receive mode.
                    // your code will block here until the
                    // server receive a packet from a client.
                    clientSocket.receive(clientPacket);

                    //
                    serverReply = new String(clientPacket.getData());

                    // get rid of leading and trailing spaces.
                    serverReply = serverReply.trim();

                    // log the reply
                    System.out.println("Received a Packet from Server at IP Address: "
                            + clientPacket.getAddress().getHostAddress());
                    System.out.println("Received a Packet from Server Port: "
                            + " at Port: " + clientPacket.getPort());
                    System.out.println("Received Server Greeting: "
                            + serverReply);

            }
        }
        // catch exceptions.
        catch (UnknownHostException e){
            System.out.println("Unknown host: " + args[0]);
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        // close the socket
        finally{
            if (!(clientSocket==null)){
                clientSocket.close();
            }
        }
    }
}

