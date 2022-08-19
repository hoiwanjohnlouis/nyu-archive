// Code 8L
/** A class that implements mouse motion listener.
* @author Mohammed Ashequr Rahman
* @version 1.0
*/
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
class MyMouseMotionListener implements MouseMotionListener
{
	
	public void mouseDragged(MouseEvent p1)
	{
		System.out.println(p1.toString());
	}

	public void mouseMoved(MouseEvent p1)
	{
		System.out.println(p1.toString());
	}

}
