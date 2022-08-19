// Code 10B
/** A JFrame that has JButtons on it.*/
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
public class JButtonAddedJFrame extends ClosableJFrame 
{

	private JButton button;
	private int count;
	
	/** Constructor that adds a button on the jframe.*/
	public JButtonAddedJFrame()
	{
		// call super constructor.
		super();

		// change backcolor.
		Color frameBackground = Color.lightGray;
		setBackground(frameBackground);

		// instantiate an ImageIcon object.
		ImageIcon saveIcon = new ImageIcon("save.gif");

		// instantiate a JButton with ImageIcon.
		button=new JButton("Save",saveIcon);

		// set the vertical and horizontal positioning of 
		// text on button.
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setHorizontalTextPosition(JButton.CENTER);

		// set the hot key of the button.
		button.setMnemonic('S');

		// change fort of the button.
		Font font = new Font("TimesRoman",Font.BOLD,18);
		button.setFont(font);

		// set the tooltiptext of the button.
		button.setToolTipText("Please click on this button");

		// add listener to the button.
		button.addActionListener(new InnerActionListener());

		// add button to the frame.
		getContentPane().add(button,"South");
	}
	
	private class InnerActionListener implements ActionListener
	{
		/** listener interface method that shows number of clicks.*/
		public void actionPerformed(ActionEvent p1)
		{
			button.setText("Click Count: " + ++count);
		}
	}

	/** main method for testing this class.*/
	public static void main(String[] args)
	{
		// instantiate an object of this class.
		JButtonAddedJFrame frame = new JButtonAddedJFrame();

		// make it visible.
		frame.setVisible(true);
	}
}
