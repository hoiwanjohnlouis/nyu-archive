// Code 8G
/** A Window Listener that has empty event handler for all
*  the window events except for windowClosing.
* @author Mohammed Ashequr Rahman
* @version 1.0
*/
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
class EmptyBodyWindowListener implements WindowListener
{
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
	public void windowClosed(WindowEvent e){ }
	public void windowOpened(WindowEvent e){ }
	public void windowIconified(WindowEvent e){ }
	public void windowDeiconified(WindowEvent e){ }
	public void windowActivated(WindowEvent e){ }
	public void windowDeactivated(WindowEvent e){ }
}
