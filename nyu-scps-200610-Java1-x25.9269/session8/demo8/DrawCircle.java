// Code 8R
/** A subclass of frame that draws Circle.
* @author Mohammed Ashequr Rahman
* @version 1.0
*/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class DrawCircle extends ClosableFrame
{

	public DrawCircle()
	{
		setSize(500,500);
		addMouseMotionListener(new DrawCircle.InnerMouseMotionListener());
	}


	// inner listener class
	private class InnerMouseMotionListener  implements MouseMotionListener
	{
		public void mouseDragged(MouseEvent p1)
		{
			// get the graphics object of this frame.
			Graphics graphics=getGraphics();
			// set the color to black.
			graphics.setColor(Color.black);
			// draw circle using 50X50 rectangle.
			graphics.drawOval(p1.getX()-25,p1.getY()-25,50,50);
		}

		/** This method draws Circle and fills them will random color.*/
		public void mouseMoved(MouseEvent p1)
		{
			// get random number between 0-255 for red,green and blue.
			int red = (int) (Math.random()*255);
			int green = (int) (Math.random()*255);
			int blue = (int) (Math.random()*255);

			// get the graphics object of the frame.
			Graphics graphics=getGraphics();

			// set the color to black and draw circle using 100x1000 rectangle.
			graphics.setColor(Color.black);
			graphics.drawOval(p1.getX()-50,p1.getY()-50,100,100);

			// set the color to random color using red, green and blue.
			Color color=new Color(red,green,blue);
			graphics.setColor(color);

			// fill the circle drawn before with color.
			graphics.fillOval(p1.getX()-50,p1.getY()-50,100,100);
		}
	}

	public static void main(String[] args)
	{
			DrawCircle drawCircle = new DrawCircle();
			drawCircle.setVisible(true);
	}

}
