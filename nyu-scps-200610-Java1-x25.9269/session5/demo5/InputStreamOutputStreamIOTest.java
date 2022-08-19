import java.io.IOException;

public class InputStreamOutputStreamIOTest {

	/** The main method(automatically called by JVM) that
	* does input and output using in and out field
	* of System object.
	*/
	public static void main(String[] args){
		// watch out for IOException
		try{
			// create an array of bytes.
			byte inputByteArray[] = new byte[128];
			
			// print at command prompt.
			System.out.print("Enter something: ");

			/* read keyboard input and store it in byte array.
			* execution will block on this line until the
			* user hits new line.
			*/
			System.in.read(inputByteArray);

			// convert byte array to string.
			String s = new String(inputByteArray);

			// trim the string since it has a lot of empty characters
			s = s.trim();

			// print out user input again.
			System.out.print("You entered: " + s);
		}
		// catch IOException.
		catch (IOException e){
			System.out.println(e.toString());
		}
	}
}
