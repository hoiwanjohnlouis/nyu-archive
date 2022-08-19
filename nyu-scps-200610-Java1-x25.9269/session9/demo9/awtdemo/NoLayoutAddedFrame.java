// Code 9F
/** A Frame that uses No Layout.
* @author Mohammed Ashequr Rahman
* @version 1.0
*/
import java.awt.*;
import java.awt.event.*;
public class NoLayoutAddedFrame extends ClosableFrame  
{

	// an array for buttons.
	private Button[] buttons=new Button[5];
	private int[] counts= new int[5];

	/** Constructor that adds buttons to the frame.*/
	public NoLayoutAddedFrame()
	{
		// call the super constructor
		super();

		// call the addButtons method that adds 5 buttons.
		addButtons();

		// instantiate Gray Color and set it as background of the frame.
		Color frameBackground = Color.lightGray;
		setBackground(frameBackground);

		// set no layout.
		setLayout(null);
	}


	/** This method will add 5 buttons to the frame.*/
	private void addButtons()
	{
		// intial x and y coordinate of button.
		int nX=0;
		int nY=40;

		// loop for 5 times.
		for (int n=0; n < buttons.length; n++)
		{
			// instantiate buttons and assign caption.
			buttons[n]=new Button("Button " + n);

			// instantiate orange color and use it for backcolor of buttons.
			Color colButtonBackground = Color.orange;		
			buttons[n].setBackground(colButtonBackground);
			
			// set the size of each button.
			buttons[n].setBounds(nX,nY,80,40);

			// instantiate font object and use it for buttons.
			Font fntButtonFont = new Font("TimesRoman",Font.BOLD,18);
			buttons[n].setFont(fntButtonFont);

			// add the buttons to the frame.
			add(buttons[n]);

			// increment x and y coordinate for the next button.
			nX +=84;
			nY +=44;


		}
	}

	/** main method to test this class.*/
	public static void main(String[] args)
	{
		// instantiate this object, set it's size and make it visible.
		NoLayoutAddedFrame nlafNew = new NoLayoutAddedFrame();
		nlafNew.setSize(450,300);
		nlafNew.setVisible(true);
	}
}
