// Code 10A
/** A JFrame that terminates the application on close.*/
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
public class ClosableJFrame extends JFrame
{

	/** No-argument constructor that adds window listener
	* and sets size, location and title by default.
	*/
	public ClosableJFrame()
	{
		// call the Frame() constructor.
		super();
		// add an instance of inner window listener.
		addWindowListener(new ClosableJFrame.InnerWindowListener());

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
		ClosableJFrame frame = new ClosableJFrame();

		// make it visible.
		frame.setVisible(true);
	}
}
