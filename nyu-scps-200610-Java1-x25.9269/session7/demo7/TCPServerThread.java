import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
public class TCPServerThread extends Thread
{
	private Socket socket = null;

	/** Constructor that receives a Socket connected to Client.
	* @param anySocket Socket connected to client.
	*/
	public TCPServerThread(Socket anySocket)
	{
		socket = anySocket;
	}

	/** Overridden run method that sends data to and receives data from client.*/
	public void run()
	{

		// String to store - server data.
		String serverData = null;

		// String to store - client data.
		String clientData = null;

		//loop variable
		boolean forever=true;
		
		//io variables
		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;
		OutputStream outputStream = null;
		OutputStreamWriter outputStreamWriter = null;
		BufferedWriter bufferedWriter= null;
		PrintWriter printWriter = null;

		try{
			// show client IP info.
			System.out.println("Client IP Address #: " + socket.getInetAddress().getHostAddress());

			// show port info.
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
		catch (IOException e){
			System.out.println("Closing Port #: " + socket.getPort());

		}
        // close the outermost wrappers and socket
        finally{
            try{
            	System.out.println("Closing Socket to port: " + socket.getPort());
                if (!(bufferedReader==null)){bufferedReader.close();}
                if (!(printWriter==null)){printWriter.close();}
                if (!(socket==null)){socket.close();}
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
	
	}
}

