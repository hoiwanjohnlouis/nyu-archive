import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class ReaderWriterIOTest
{
	/** The main method(automatically called by JVM) that
	* does input and output using in and out field
	* of System object.
	*/
	public static void main(String[] args)
	{
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;
		OutputStreamWriter outputStreamWriter = null;
		PrintWriter printWriter = null;		
		// watch out for IOException
		try{

			// temp variable to read in line as string
			String inputString;

			// convert byte stream to character stream
			inputStreamReader = new InputStreamReader(System.in);
			
			// buffer the character stream
			bufferedReader= new BufferedReader(inputStreamReader);

			// convert type stream to character stream.
			outputStreamWriter = new OutputStreamWriter(System.out);
			
			printWriter = new PrintWriter(outputStreamWriter);

			// infinite loop
			while (true)
			{
				// prompt the user
				printWriter.print("Enter Something: ");
				printWriter.flush();

				// read in a line as string
				inputString = bufferedReader.readLine();
				
				// if the user does not input anything
				// just hits new line - exit
				if (inputString.equals(""))
				{
					break;
				}
				
				// print out user input
				printWriter.println("You have entered: " + inputString);
				
			}
		}
		// catch IOException.
		catch (IOException e){
			System.out.println(e.toString());
		}
		finally{
			try{
				inputStreamReader.close();
				bufferedReader.close();
				outputStreamWriter.close();
				printWriter.close();
			}
			catch(Exception e){
				//do nothing. probably null pointer exception
			}
		}
	}
} 
