//Code 8Q
/** A subclass of frame that closes automatically.
* @author Mohammed Ashequr Rahman
* @version 1.0
*/
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
public class SelfClosableFrame extends Frame implements WindowListener
{
	
	/** No-argument constructor that adds window listener
	* and sets size, location and title by default.
	*/
	public SelfClosableFrame()
	{
		// call the Frame() constructor.
		super();
		// add window listener.
		addWindowListener(this);

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
		SelfClosableFrame frame = new SelfClosableFrame();

		// make it visible.
		frame.setVisible(true);
	}

	public void windowClosing(WindowEvent p1)
	{
		System.exit(0);
	}
	public void windowDeactivated(WindowEvent p1){}
	public void windowOpened(WindowEvent p1){}
	public void windowClosed(WindowEvent p1){}
	public void windowDeiconified(WindowEvent p1){}
	public void windowActivated(WindowEvent p1){}
	public void windowIconified(WindowEvent p1){}
}