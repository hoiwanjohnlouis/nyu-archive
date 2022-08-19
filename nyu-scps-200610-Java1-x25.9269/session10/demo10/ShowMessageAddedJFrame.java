// Code 10H
/** A show message dialog added frame.*/
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ShowMessageAddedJFrame extends ClosableJFrame  
{

	private JButton button;
	private int count;

	public ShowMessageAddedJFrame()
	{
		// call super constructor.
		super();
		// change color.
		Color frameBackground = Color.lightGray;
		setBackground(frameBackground);


		// instantiate a button.
		button=new JButton("Show Message");

		// set font.
		Font font = new Font("TimesRoman",Font.BOLD,18);
		button.setFont(font);

		// set hot key.
		button.setMnemonic('S');

		// add tooltiptext.
		button.setToolTipText("Please click on this button");

		// set horizontan and vertical positioning of text on the button.
		button.setVerticalTextPosition(AbstractButton.BOTTOM);
		button.setHorizontalTextPosition(AbstractButton.CENTER);

		// add listener to the button.
		button.addActionListener(new InnerActionListener());

		// add the button to the frame.
		getContentPane().add(button,"South");
	}

	private class InnerActionListener implements ActionListener
	{
		/** overridden method of action listener interface
		* that loads a show message dialog.
		*/
		public void actionPerformed(ActionEvent p1)
		{
			// load show message dialog with the frame as parent
			JOptionPane.showMessageDialog(ShowMessageAddedJFrame.this,"You clicked on 'Show Message' button",
				"Simple Message",JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/** main method for testing this class.*/
	public static void main(String[] args)
	{
		// instantiate an object of this class and show it.
		ShowMessageAddedJFrame frame = new ShowMessageAddedJFrame();
		frame.setVisible(true);
	}
}
