// Code 9A
/** A Frame that has a button on it.
* @author Mohammed Ashequr Rahman
* @version 1.0
*/
import java.awt.*;
import java.awt.event.*;
public class ButtonAddedFrame extends ClosableFrame  
{

	// the button.
	private Button button;

	/** Inner action listener class
	 */
	private class InnerActionListener implements ActionListener
	{
		// click counter
		private int count;

		/** Overridden method of action listener interface that
		* counts the number of clicks on the button.
		*/
		public void actionPerformed(ActionEvent p1)
		{
			// change the caption of the button with click count.
			button.setLabel("Click Count: " + ++count);
		}
	}


	/** Constructor that adds a button on the frame.*/
	public ButtonAddedFrame()
	{
		// all the super constructor.
		super();
	
		// instantiate a new button with caption.
		button=new Button("Click Me");

		// instantiate color object for button foreground, background.
		Color foreground = new Color(200,10,15);
		Color background = Color.lightGray;

		// instantiate a font object.
		Font font = new Font("TimesRoman",Font.BOLD,18);

		// set font and color of the button.
		button.setFont(font);
		button.setForeground(foreground);
		button.setBackground(background);


		// instantiate light gray color object for frame background.		
		Color frameBackground = Color.lightGray;

		// set the frame background color.
		setBackground(frameBackground);

		// add the button to the frame.
		add(button);

		// add action listener to the button.
		button.addActionListener(new ButtonAddedFrame.InnerActionListener());
	}
	/** The main method for testing this class.*/
	public static void main(String[] args)
	{
		// instantiate this frame object.
		ButtonAddedFrame frame = new ButtonAddedFrame();
		// make it visible.
		frame.setVisible(true);
	}

}
