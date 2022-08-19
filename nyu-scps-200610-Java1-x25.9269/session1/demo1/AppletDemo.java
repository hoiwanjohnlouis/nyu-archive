import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JApplet;

public class AppletDemo extends JApplet
{
	/** 
	* The paint method draws shapes and string on the applet body. 
	* It uses drawString(), setColor(), fillRect(),fillOval(),fillArc()
	* methods off Graphics object.
	*/
	public void paint(Graphics g)
	{
		// print a string
		g.drawString("Simple Applet Demo",50,25);
		// change the color to blue
		g.setColor(Color.blue);
		// draw a Rect and fill it with blue color
		g.fillRect(25,30,150,100);
		// change the color to red
		g.setColor(Color.red);
		// draw oval shape and fill it with red
		g.fillOval(25,30,150,100);
		// change color to green
		g.setColor(Color.green);
		// draw arc and fill it with green
		g.fillArc(25,30,150,100,0,60);
		// draw another arc and fill it with green
		g.fillArc(25,30,150,100,180,60);
	}
}
