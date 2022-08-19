// Code 8O
/** A tester for key listener.
* @author Mohammed Ashequr Rahman
* @version 1.0
*/

import java.awt.Frame;
public class KeyListenerFrameTest
{
	public static void main(String[] args)
	{
		//instantiate a Frame.
		Frame frame = new Frame();

		// add window listener so that we can close the window.
		frame.addWindowListener(new MyAdaptedWindowListener());

		// add key listener.
		frame.addKeyListener(new MyKeyListener());

		//set title,size and location.
		frame.setTitle("My First Window");
		frame.setSize(300,200);
		frame.setLocation(100,100);

		// make it visible.
		frame.setVisible(true);
	}
}
