// Code 9C
/** A Frame that has uses Border Layout.
* @author Mohammed Ashequr Rahman
* @version 1.0
*/
import java.awt.*;
import java.awt.event.*;
public class BorderLayoutAddedFrame extends ClosableFrame  
{

	// an array for buttons.
	private Button[] buttons=new Button[5];
	private int[] counts= new int[5];

	/** Constructor that adds buttons to the frame.*/
	public BorderLayoutAddedFrame()
	{
		// call the super constructor
		super();

		// instantiate Light Gray Color and set it as background of the frame.
		Color frameBackground = Color.lightGray;
		setBackground(frameBackground);

		// set the layout of the frame. 
		// Horizontal gap between buttons: 10
		// Vartical gap between buttons: 12
		setLayout(new BorderLayout(10,12));

		// call the createButtons method that instantiate 5 buttons.
		createButtons();

		// add the first button on the side North.
		// set the caption to "North".
		add(buttons[0],BorderLayout.NORTH);
		buttons[0].setLabel("North");

		// same for the rest 4 buttons.
		add(buttons[1],BorderLayout.SOUTH);
		buttons[1].setLabel("South");
		add(buttons[2],BorderLayout.EAST);
		buttons[2].setLabel("East");
		add(buttons[3],BorderLayout.WEST);
		buttons[3].setLabel("West");
		add(buttons[4],BorderLayout.CENTER);
		buttons[4].setLabel("Center");
	}


	/** This method will instantiate 5 buttons.*/
	private void createButtons()
	{
		// loop for 5 times.
		for (int n=0; n < buttons.length; n++)
		{
			// instantiate buttons and assign caption.
			buttons[n]=new Button();

			// instantiate orange color and use it for backcolor of buttons.
			Color buttonBackground = Color.orange;		
			buttons[n].setBackground(buttonBackground);

			// instantiate font object and use it for buttons.
			Font buttonFont = new Font("TimesRoman",Font.BOLD,18);
			buttons[n].setFont(buttonFont);

		}
	}

	/** main method to test this class.*/
	public static void main(String[] args)
	{
		// instantiate this object and make it visible.
		BorderLayoutAddedFrame frame = new BorderLayoutAddedFrame();
		frame.setVisible(true);
	}


}
