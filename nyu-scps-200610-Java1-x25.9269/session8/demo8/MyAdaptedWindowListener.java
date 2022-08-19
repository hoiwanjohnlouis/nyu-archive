// Code 8H
/** A Class that subclasses WindowAdapter and overrides windowClosing method.
* @author Mohammed Ashequr Rahman
* @version 1.0
*/
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class MyAdaptedWindowListener extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
}
