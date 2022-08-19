// Code 8I
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/** A Tester Class for WindowAdapter.
* @author Mohammed Ashequr Rahman
* @version 1.0
*/
public class AnotherFrameTest
{
	public static void main(String[] args)
	{
		//instantiate a frame.
		Frame frame = new Frame();

		// instantiate window listener and add it to the frame.
		frame.addWindowListener(new MyAdaptedWindowListener());

		//set title,size and location
		frame.setTitle("My First Window");
		frame.setSize(300,200);
		frame.setLocation(100,100);
	
		//make it visible.
		frame.setVisible(true);
	}
}
/** A Class (not public but friendly) that subclasses WindowAdapter and overrides windowClosing method.
* @author Mohammed Ashequr Rahman
* @version 1.0
*/
class MyAdaptedWindowListener2 extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
		// exit the system.
		System.exit(0);
	}
}
