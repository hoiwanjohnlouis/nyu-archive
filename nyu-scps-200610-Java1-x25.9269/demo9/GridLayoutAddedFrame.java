// Code 9E
/** A Frame that uses Grid Layout.
* @author Mohammed Ashequr Rahman
* @version 1.0
*/
import java.awt.*;
import java.awt.event.*;
public class GridLayoutAddedFrame extends ClosableFrame  
{

	// an array for buttons.
	private Button[] buttons=new Button[5];
	private int[] counts= new int[5];

	/** Constructor that adds buttons to the frame.*/
	public GridLayoutAddedFrame()
	{
		// call the super constructor
		super();

		// call the addButtons method that adds 5 buttons.
		addButtons();

		// instantiate Gray Color and set it as background of the frame.
		Color frameBackground = Color.lightGray;
		setBackground(frameBackground);

		// set grid layout.
		// Rows:3
		// Cols:2
		// Horizontal gap:10
		// Vartical gap:12
		setLayout(new GridLayout(3,2,10,12));
	}


	/** This method will add 5 buttons to the frame.*/
	private void addButtons()
	{
		// loop for 5 times.
		for (int n=0; n < buttons.length; n++)
		{
			// instantiate buttons and assign caption.
			buttons[n]=new Button("Button " + n);

			// instantiate orange color and use it for backcolor of buttons.
			Color buttonBackground = Color.orange;		
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
		GridLayoutAddedFrame frame = new GridLayoutAddedFrame();
		frame.setVisible(true);
	}
}
