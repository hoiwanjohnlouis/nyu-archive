// Code 8P
/** A subclas of frame that closes automatically.
* @author Mohammed Ashequr Rahman
* @version 1.0
*/
import java.awt.Frame;
public class UsefulFrame extends Frame 
{
	
	/** No-argument constructor that adds window listener
	* and sets size, location and title by default.
	*/
	public UsefulFrame()
	{
		// call the Frame() constructor.
		super();
		// add window listener.
		addWindowListener(new MyAdaptedWindowListener());

		// give it a default title.
		setTitle(getClass().getName());

		// set size and location.
		setSize(300,200);
		setLocation(100,100);
	}

	/** Main method to test the class.*/
	public static void main(String[] args)
	{
		// instantiate a object of this class.
		UsefulFrame usefulFrame = new UsefulFrame();

		// make it visible.
		usefulFrame.setVisible(true);
	}	 
}
