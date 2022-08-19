// Code 8J
/** A Class that implements MouseListener.
* @author Mohammed Ashequr Rahman
* @version 1.0
*/

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
class MyMouseListener implements MouseListener
{
	
	public void mouseClicked(MouseEvent p1)
	{
		System.out.println(p1.toString());
	}

	public void mousePressed(MouseEvent p1)
	{
		System.out.println(p1.toString());
	}

	public void mouseReleased(MouseEvent p1)
	{
		System.out.println(p1.toString());
	}

	public void mouseEntered(MouseEvent p1)
	{
		System.out.println(p1.toString());
	}

	public void mouseExited(MouseEvent p1)
	{
		System.out.println(p1.toString());
	}

}
