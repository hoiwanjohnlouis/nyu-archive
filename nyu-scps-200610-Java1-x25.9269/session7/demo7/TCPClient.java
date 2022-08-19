import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
public class TCPClient
{
	public static void main(String[] args)
	{
		// if not two command line arguments found - display usage message.
		if (args.length != 2)
		{
			System.out.println("Usage: TCPClient <Server's Symbolic Name> <Server's Port Number>" );
			System.exit(0);
		}

		// String to store - client data.
		String clientData = null;

		// String to store - server data.
		String serverData = null;

		// to store server port number received as command line argument.
		int serverPort = 0;

		// to store server IP address
		InetAddress serverIP = null;
                
		// for client socket
		Socket clientSocket = null;
                
		// variables to wrapup System.in
		InputStreamReader systemInputStreamReader = null;
		BufferedReader systemBufferedReader = null;

		//variables to wrapup inputstream of the socket
		InputStream socketInputStream = null;
		InputStreamReader socketInputReader = null;
		BufferedReader socketBufferedReader = null;

		//variables to wrapup the outputstream of the socket
		OutputStream socketOutputStream = null;
		OutputStreamWriter socketOutputStreamWriter = null;
		BufferedWriter socketBufferedWriter= null;
		PrintWriter socketPrintWriter = null;

		try{
			// convert server name received as command line 
			// argument to InetAddress object.
			serverIP = InetAddress.getByName(args[0]);

			// convert server port number received as command 
			// line argument to int.
			serverPort=Integer.parseInt(args[1]);
		
			// create a socket object with server IP Address 
			// and server port number
			clientSocket = new Socket(serverIP,serverPort);

			// show the client port number assigned automatically 
			System.out.println("Client IP Address: " + clientSocket.getLocalAddress().getHostAddress());
			System.out.println("Client Port #: " + clientSocket.getLocalPort());

			// show server info.
			System.out.println("Server IP Address: " + clientSocket.getInetAddress().getHostAddress());
			System.out.println("Server Port #: " + clientSocket.getPort());

			// get the input stream of the socket.
			socketInputStream = clientSocket.getInputStream();
	
			// convert byte stream to character stream.
			socketInputReader = new InputStreamReader(socketInputStream);

			// buffer character stream.
			socketBufferedReader = new BufferedReader(socketInputReader);

			// get the output stream of the socket.
			socketOutputStream = clientSocket.getOutputStream();
	
			// convert byte stream to character stream.
			socketOutputStreamWriter = new OutputStreamWriter(socketOutputStream);

			// buffer character stream.
			socketBufferedWriter= new BufferedWriter(socketOutputStreamWriter);

			// Convert to PrintWriter so that we can use println() method.
			socketPrintWriter = new PrintWriter(socketBufferedWriter);


			// convert byte stream to character stream - keyboard input.
			systemInputStreamReader = new InputStreamReader(System.in);

			// buffer character stream - keyboard input.
			systemBufferedReader = new BufferedReader(systemInputStreamReader);
			// infinite loop
			while (true)
			{
				// prompt user to input
				System.out.print("Enter your name: ");

				// get user input
				clientData=systemBufferedReader.readLine();
				
				//exit if the user hits just <Enter>
				if (clientData.length()==0)
				{
					return;
				}

				// print before send
				System.out.println("Sending data to the server: " + clientData);

				// send the data to the server
				socketPrintWriter.println(clientData);

				//flush the output since it is buffered.
				socketPrintWriter.flush();

				// print before receive
				System.out.println("Waiting for the server ...");

				// waiting for the server response.
				// code will block here until we hear back from the server
				serverData = socketBufferedReader.readLine();

				// print server response
				System.out.println("Server Response: " + serverData);

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
        // close the outermost wrappers and socket
        finally{
            try{
                if (!(systemBufferedReader==null)){systemBufferedReader.close();}
                if (!(socketBufferedReader==null)){socketBufferedReader.close();}
                if (!(socketPrintWriter==null)){socketPrintWriter.close();}
                if (!(clientSocket==null)){clientSocket.close();}
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
	
	}
}

