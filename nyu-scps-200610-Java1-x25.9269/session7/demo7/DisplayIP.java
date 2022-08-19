import java.net.InetAddress;
import java.net.UnknownHostException;
public class DisplayIP
{
	public static void main(String[] args)
	{
		// check if the user entered a command line argument.
		// if not print usage message.
		if (args.length != 1)
		{
			System.out.println("Usage: DisplayIP <Symbolic Name>");
			System.exit(0);
		}

		// try-catch block for getByName() method
		try
		{
			// use the first command line argument to create an InetAddress object.
			InetAddress remoteIP = InetAddress.getByName(args[0]);
			
			// print information about remote host name or ip address.
			System.out.println("Remote Server Name: " + remoteIP.getHostName());
			System.out.println("Remote IP Address: " + remoteIP.getHostAddress());

			// get the InetAddress object for the local machine.
                        // by calling the static method getLocalHost()
			InetAddress localIP = InetAddress.getLocalHost();

			// print information about the user's local machine.
			System.out.println("Local Machine Name: " + localIP.getHostName());
			System.out.println("Local IP Address: " + localIP.getHostAddress());

		}
		catch (UnknownHostException e){
			System.out.println("Unknown host: " + args[0]);
			e.printStackTrace();
		}
	}
}
