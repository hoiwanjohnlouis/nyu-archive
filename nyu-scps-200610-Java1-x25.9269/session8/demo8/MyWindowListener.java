// Code 8E
/** A Class that implements WindowListener interface and print event information.
* @author Mohammed Ashequr Rahman
* @version 1.0
*/
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
class MyWindowListener implements WindowListener
{
	public void windowClosing(WindowEvent e){
		System.out.println(e.toString());
		System.exit(0);
	}
	public void windowClosed(WindowEvent e)	{
		System.out.println(e.toString());
	}
	public void windowOpened(WindowEvent e){
		System.out.println(e.toString());
	}
	public void windowIconified(WindowEvent e){
		System.out.println(e.toString());
	}
	public void windowDeiconified(WindowEvent e){
		System.out.println(e.toString());
	}
	public void windowActivated(WindowEvent e){
		System.out.println(e.toString());
	}
	public void windowDeactivated(WindowEvent e){
		System.out.println(e.toString());
	}
}
