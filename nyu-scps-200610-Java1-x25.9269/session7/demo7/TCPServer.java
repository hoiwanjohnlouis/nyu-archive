import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class TCPServer
{
	public static void main(String[] args)
	{
		// if not two command line arguments found - display usage message.
		if (args.length != 1)
		{
			System.out.println("Usage: TCPServer <This Machine's Port Number>" );
			System.exit(0);
		}


		// String to store - server data.
		String serverData = null;

		// String to store - client data.
		String clientData = null;

		// to store server port number received as command line argument.
		int serverPort = 0;
                
		//loop variable
		boolean forever=true;

		// socket variables
		ServerSocket serverSocket = null;
		Socket socket = null;
 
		// variables for wrapping input stream
		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;
		
		// variables for wrapping output stream
		OutputStream outputStream = null;
		OutputStreamWriter outputStreamWriter = null;
		BufferedWriter bufferedWriter= null;
		PrintWriter printWriter = null;

		try{
		
			// convert server port number received as command 
			// line argument to int.
			serverPort=Integer.parseInt(args[0]);
		
			// create a server socket object with  
			// server port number
			serverSocket = new ServerSocket(serverPort);

			//print server port
			System.out.println("Server Port #: " + serverSocket.getLocalPort());

			// print before wait.
			System.out.println("Waiting for Client connection ...");

			// wait for the client
			// your code will block here
			// until a client connects.
			socket = serverSocket.accept();

			// print after connection.
			System.out.println("Client connected.");

			// show client IP info.
			System.out.println("Client IP Address #: " + socket.getInetAddress().getHostAddress());

			// show client port info.
			System.out.println("Client Port #: " + socket.getPort());

			// get the input stream of the socket.
			inputStream = socket.getInputStream();
	
			// convert byte stream to character stream.
			inputStreamReader = new InputStreamReader(inputStream);

			// buffer character stream.
			bufferedReader = new BufferedReader(inputStreamReader);

			// get the output stream of the socket.
			outputStream = socket.getOutputStream();
	
			// convert byte stream to character stream.
			outputStreamWriter = new OutputStreamWriter(outputStream);

			// buffer character stream.
			bufferedWriter= new BufferedWriter(outputStreamWriter);

			// Convert to PrintWriter so that we can use println() method.
			printWriter = new PrintWriter(bufferedWriter);

			while (forever)
			{
      			// print before receive
				System.out.println("Waiting for the client input ...");

				//waiting for the client input.
				// your code will block here ustil
				// snd home data from the client
				clientData = bufferedReader.readLine();

				//if empty user input - exit loop.
				if ((clientData==null) || (clientData.trim().length()==0))
				{
					forever=false;
					return;
				}

				// print client input.
				System.out.println("Client Input: " + clientData);

				//convert to upper case
				serverData = "Hello " + clientData.toUpperCase();

				// print before send
				System.out.println("Sending data to the client: " + serverData);

				// send the data to the client
				printWriter.println(serverData);

				//flush the output since it is buffered.
				printWriter.flush();
			}
		}
		// catch exceptions.
		catch (IOException e){
			e.printStackTrace();
		}
        // close the outermost wrappers and socket
        finally{
            try{
                if (!(bufferedReader==null)){bufferedReader.close();}
                if (!(printWriter==null)){printWriter.close();}
               if (!(socket==null)){socket.close();}
                if (!(serverSocket==null)){serverSocket.close();}
            }
            catch(Exception e){
            	e.printStackTrace();
            }
        }
	}
}

