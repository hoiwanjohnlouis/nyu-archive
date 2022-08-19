import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class ThreadedTCPServer
{
	public static void main(String[] args)
	{
		// if not two command line arguments found - display usage message.
		if (args.length != 1)
		{
			System.out.println("Usage: ThreadedTCPServer <This Machine's Port Number>" );
			System.exit(0);
		}
	
		// to store server port number received as command line argument.
		int serverPort = 0;

		//socket variables
		ServerSocket serverSocket = null;
		Socket socket = null;

		try{

			// convert server port number received as command 
			// line argument to int.
			serverPort=Integer.parseInt(args[0]);
		
			// create a server socket object with  
			// server port number
			serverSocket = new ServerSocket(serverPort);

			//print server port
			System.out.println("Server Port #: " + serverSocket.getLocalPort());

			// infinite loop.
			while (true)
			{

				// print before wait.
				System.out.println("Waiting for Client connection ...");

				//wait for the client
				socket = serverSocket.accept();

				// print after connection.
				System.out.println("Client connected.");

				// create the thread object.
				TCPServerThread thread = new TCPServerThread(socket);

				//start the thread.
				thread.start();

			}
		}
		// catch exceptions.
		catch (IOException e){
			e.printStackTrace();
		}
        // close sockets
        finally{
            try{
                if (!(socket==null)){socket.close();}
                if (!(serverSocket==null)){serverSocket.close();}
					System.exit(-1);
				}
			catch(Exception e){
				e.printStackTrace();
			}
		}	
	}
}

