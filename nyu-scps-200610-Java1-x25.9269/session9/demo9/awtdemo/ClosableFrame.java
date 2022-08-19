// Code 8Q1
/** A subclass of frame that closes automatically.
* @author Mohammed Ashequr Rahman
* @version 1.0
*/
import java.awt.*;
import java.awt.event.*;
public class ClosableFrame extends Frame
{
	
	/** No-argument constructor that adds window listener
	* and sets size, location and title by default.
	*/
	public ClosableFrame()
	{
		// call the Frame() constructor.
		super();
		// add an instance of inner window listener.
		addWindowListener(new ClosableFrame.InnerWindowListener());

		// give it a default title.
		setTitle(getClass().getName());

		// set size and location.
		setSize(300,200);
		setLocation(100,100);
	}

	//inner-listener class
	private class InnerWindowListener extends WindowAdapter
	{
		public void windowClosing(WindowEvent p1)
		{
			System.exit(0);
		}
	}

	/** Main method to test the class.*/
	public static void main(String[] args)
	{
		// instantiate a object of this class.
		ClosableFrame frame = new ClosableFrame();

		// make it visible.
		frame.setVisible(true);
	}

}
