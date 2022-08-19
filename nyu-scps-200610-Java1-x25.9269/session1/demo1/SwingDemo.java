import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
public class SwingDemo extends JFrame
{
	public static void main(String[] args)
	{
		// create a new window
		SwingDemo frame = new SwingDemo();
		
		// set closing mode.
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		// set the title
		frame.setTitle("Swing Demo Program");
		// set the size
		frame.setSize(300,200);
		// set the location
		frame.setLocation(150,150);
		// make it visible
		frame.setVisible(true);
	}	 

	/** The paint method that automatically gets called 
	* and it actually draws shapes on the window(JFrame). 
	* The window will display a pie.
	*/

	public void paint(Graphics g)
	{
		// set the backgroud of graphics to red color
		g.setColor(Color.red);
		// draw 3/4 of a pie and fill it with red color
		g.fillArc(25,30,100,100,45,315);
		// draw 1/4 of a pie and fill it with red color
		g.fillArc(35,25,100,100,0,45);
	}
}
