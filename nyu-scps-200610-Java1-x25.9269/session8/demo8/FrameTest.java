// Code 8A
/** A class that will display an empty Frame.
* @author Mohammed Ashequr Rahman
* @version 1.0
*/
import java.awt.Font;
import java.awt.Color;
import java.awt.Frame;
public class FrameTest
{
	public static void main(String[] args)
	{
		Color c = Color.GREEN;
		
		//create a Frame object.
		Frame frame = new Frame();
		frame.setBackground(c);

		//set title,size,location.
		frame.setTitle("My First Window");
		frame.setSize(300,200);
		frame.setLocation(100,100);

		//make it visible.
		frame.setVisible(true);
	}
}
