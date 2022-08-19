import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
public class URLTest
{
	public static void main(String[] args)
	{

		// let's make sure that the user enters a command line argument.
		// otherwise print usage message.
		if (args.length != 1)
		{
			System.out.println("Usage: URLTest <URL>");
			System.exit(-1);
		}

		// temp variable to read lines from url.
		String line;
		
		// variables to wrapup input stream
		InputStream inputStream = null;
		InputStreamReader inputStreamReader =null;
		BufferedReader bufferedReader = null;
		try{
			// convert user input to url object.
			URL myURL = new URL(args[0]);

			// print information about the url.
			System.out.println("File: " + myURL.getFile());
			System.out.println("Host: " + myURL.getHost());
			System.out.println("Port #: " + myURL.getPort());
			System.out.println("Protocol: " + myURL.getProtocol());


			// put the main thread to sleep so that user can see it.
			Thread.sleep(3000);

			// open the input stream to the url.
			inputStream = myURL.openStream();

			// convert it to a 16-bit reader
			inputStreamReader=new InputStreamReader(inputStream);

			// buffer the input
                        bufferedReader = new BufferedReader(inputStreamReader);

			// read each line from the url and print it.
			while ((line=bufferedReader.readLine()) !=null)
			{
				System.out.println(line);
			}
		}
		// catch exceptions
		catch (MalformedURLException e){
			System.out.println("Unknown URL: " + args[0]);
			e.printStackTrace();
		}
		catch (InterruptedException e){
			e.printStackTrace();
		}
		catch (IOException e){
			e.printStackTrace();
		}
        //close the outermost wrapper - buffered reader
        // that will close the inner stream
        finally{
            try{
                if (!(bufferedReader==null)){   
                    bufferedReader.close();
                }
            }
            catch(Exception e){
            	e.printStackTrace();
            }
        }
	}
}
