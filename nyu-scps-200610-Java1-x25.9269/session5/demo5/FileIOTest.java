import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileIOTest
{
	/** The main method(automatically called by JVM) that
	* does file I/O.
	*/
	public static void main(String[] args)
	{
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		// watch out for Exceptions
		try{
			// temp variable to read in line as string
			String inputString;
			
			/* open an existing file for input
			* if the file is not found FileNotFoundException 
			* will be thrown.
			*/
			fileReader = new FileReader("myfile.txt");

			// buffer the input stream from file.
			bufferedReader= new BufferedReader(fileReader);

			/* creates a new file. Throws IOException if file
			* can't be created for some reason.
			* Overwrites the file if already exists.
			* Appends to the file if the second argument is passed
			* as true to the constructor.
			*/
			fileWriter = new FileWriter("myfilecopy.txt");
			
			// buffer the output stream to the file.
			printWriter= new PrintWriter(fileWriter);

			// infinite loop
			while (true)
			{
				// read in a line
				inputString = bufferedReader.readLine();
				
				// if the input is null - end of file.
				if (inputString==null)
				{
					// Close the files
					bufferedReader.close();
					printWriter.close();
					break;
					// exit
				}
				// write to the file
				printWriter.println(inputString);
				
			}
			System.out.println("File Copy is complete");
		}
		// catch file not found exception
		catch (FileNotFoundException e)
		{
			System.out.println(e.toString());
		}
		// catch IOException.
		catch (IOException e){
			System.out.println(e.toString());
		}
		finally{
			try{
				fileReader.close();
				bufferedReader.close();
				fileWriter.close();
				printWriter.close();
			}
			catch(Exception e){
				//nothing to do - probably null pointer exception.
			}
		}
	}
}
