// Code 8F
/** A Frame with WindowListener.
* @author Mohammed Ashequr Rahman
* @version 1.0
*/
import java.awt.Frame;
public class NewFrameTest
{
	public static void main(String[] args)
	{

		//instantiate a Frame.
		Frame frame = new Frame();
		// Add window listener.
		frame.addWindowListener(new MyWindowListener());

		// Set title and size and position.
		frame.setTitle("My First Window");
		frame.setSize(300,200);
		frame.setLocation(100,100);

		// Make it visible.
		frame.setVisible(true);
	}
}
