// Code 8N
/** A Class that implements key listener interface.
* @author Mohammed Ashequr Rahman
* @version 1.0
*/
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
class MyKeyListener implements KeyListener
{
	public void keyTyped(KeyEvent p1)
	{
		System.out.println(p1.toString());
	}

	public void keyPressed(KeyEvent p1)
	{
		System.out.println(p1.toString());
	}

	public void keyReleased(KeyEvent p1)
	{
		System.out.println(p1.toString());
	}

}
