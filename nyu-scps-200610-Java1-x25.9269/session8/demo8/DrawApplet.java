// Code 8C
/** An Applet that draws graphical object on it.
* @version 1.0
*/
import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
public class DrawApplet extends Applet
{
	/** override the paint method. This method is automatically called
	* everytime the applet needs to be printed.
	* @param Graphics Graphics object that has methods 
	* for printing graphics object.
	*/
	public void paint(Graphics g)
	{
		// set the fort of graphics object for printing.
		Font roman = new Font("TimesRoman",Font.BOLD,20);
		g.setFont(roman);

		// print the class name of the sub-class of Graphics
		// since Graphics is an abstract class. 
		g.drawString(g.getClass().getName(),25,20);

		// draw a line on the applet.
		g.drawLine(25,40,80,70);
		
		// set the color of the graphics object and
		// draw a rectangle on the applet.
		g.setColor(Color.red);
		g.drawRect(25,100,60,80);

		// set the color of the graphics object and
		// fill the inside of the rectangle leaving some
		// space in between.
		g.setColor(Color.blue);
		g.fillRect(30,105,50,70);

		// draw round rectange.
		g.drawRoundRect(25,200,60,70,30,40);

		// create an array of 3 X co-ordinates.
		int[] x={25,45,65};

		// create an array of 3 Y co-ordinates.
		int[] y={300,350,300};

		// draw a triangle using Xs ans Ys.
		g.drawPolygon(x,y,3);

		// instantiate a polygon and add some points to it.
		Polygon pentagon = new Polygon();
		pentagon.addPoint(25,380);
		pentagon.addPoint(45,400);
		pentagon.addPoint(65,400);
		pentagon.addPoint(85,380);
		pentagon.addPoint(65,380);
		pentagon.addPoint(45,360);


		// draw the polygon.
		g.drawPolygon(pentagon);

		// draw oval shape.
		g.drawOval(100,40,100,50);

		// draw cicle since height and width of o
		// val are of same size.
		g.drawOval(100,95,30,30);

		// draw an arc from 0 to 135 degree.
		g.drawArc(100,130,60,80,0,135);

		// change the color draw another arc with inside filled.
		g.setColor(new Color(0,255,0));
		g.fillArc(100,200,60,80,0,135);	
	}
}
