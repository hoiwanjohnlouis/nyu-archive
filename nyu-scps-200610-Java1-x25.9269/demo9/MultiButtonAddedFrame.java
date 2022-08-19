// Code 9B
/** A Frame that has 5 buttons on it.
* @author Mohammed Ashequr Rahman
* @version 1.0
*/
import java.awt.*;
import java.awt.event.*;
public class MultiButtonAddedFrame extends ClosableFrame  
{

	// an array for buttons.
	private Button[] buttons=new Button[5];
	private int[] counts= new int[5];

	/** Constructor that adds buttons to the frame.*/
	public MultiButtonAddedFrame()
	{
		// call the super constructor
		super();

		// call the addButtons method that adds 5 buttons.
		addButtons();

		// instantiate blue Color and set it as background of the frame.
		Color frameBackground = Color.blue;
		setBackground(frameBackground);
	}


	/** This method will add 5 buttons to the frame.*/
	private void addButtons()
	{
		// loop for 5 times.
		for (int n=0; n < buttons.length; n++)
		{
			// instantiate buttons and assign caption.
			buttons[n]=new Button("Button " + n);

			// instantiate light gray color and use it for backcolor of buttons.
			Color buttonBackground = Color.lightGray;		
			buttons[n].setBackground(buttonBackground);

			// instantiate font object and use it for buttons.
			Font buttonFont = new Font("TimesRoman",Font.BOLD,18);
			buttons[n].setFont(buttonFont);

			// add the buttons to the frame.
			add(buttons[n]);

		}
	}

	/** main method to test this class.*/
	public static void main(String[] args)
	{
		// instantiate this object and make it visible.
		MultiButtonAddedFrame frame = new MultiButtonAddedFrame();
		frame.setVisible(true);
	}


}
