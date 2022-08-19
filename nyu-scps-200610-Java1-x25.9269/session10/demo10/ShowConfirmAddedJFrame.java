// Code 10I
/** A frame that loads show confirm dialog.*/
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JOptionPane;
public class ShowConfirmAddedJFrame extends ClosableJFrame  
{

	private JButton button;
	private int count;

	/** Constructor that adds a button on the frame.*/
	public ShowConfirmAddedJFrame()
	{
		// call super constructor.
		super();

		// change color.
		Color frameBackground = Color.lightGray;
		setBackground(frameBackground);


		// instantiate a button.
		button=new JButton("Show Confirm");

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
		* that loads a show confirm dialog.
		*/
		public void actionPerformed(ActionEvent p1)
		{
			// load a show confirm dialog with yes, no and cancel option.		
			int answer=JOptionPane.showConfirmDialog(ShowConfirmAddedJFrame.this,"Do you want to save changes?",
					"Save",JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			
			// based on user's click on option
			// show a message dialog with appropriate message.
			switch (answer)
			{
				// user clicked on yes.
				case JOptionPane.YES_OPTION:
					JOptionPane.showMessageDialog(ShowConfirmAddedJFrame.this,"'Yes' is a good choice.",
						"Simple Message",JOptionPane.INFORMATION_MESSAGE);
					break;

				// user clicked on no.
				case JOptionPane.NO_OPTION:
					JOptionPane.showMessageDialog(ShowConfirmAddedJFrame.this,"'No' is a bad choice.",
						"Simple Message",JOptionPane.INFORMATION_MESSAGE);
					break;

				// user clicked on cancel.
				case JOptionPane.CANCEL_OPTION:
					JOptionPane.showMessageDialog(ShowConfirmAddedJFrame.this,"'Cancel' is not so bad.",
						"Simple Message",JOptionPane.INFORMATION_MESSAGE);
					break;

				// user closes the window without selecting anything.
				case JOptionPane.CLOSED_OPTION:
					JOptionPane.showMessageDialog(ShowConfirmAddedJFrame.this,"You closed the window without selecting anything at all.",
						"Simple Message",JOptionPane.INFORMATION_MESSAGE);
					break;

			}	
		}
	}

	/** main method for testing this class.*/
	public static void main(String[] args)
	{
		// instantiate an object of this class and show it.
		ShowConfirmAddedJFrame frame = new ShowConfirmAddedJFrame();
		frame.setVisible(true);
	}
}
