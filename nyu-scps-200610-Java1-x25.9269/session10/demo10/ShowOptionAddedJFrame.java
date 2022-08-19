// Code 10J
/** A frame that loads show option dialog.*/
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JOptionPane;
public class ShowOptionAddedJFrame extends ClosableJFrame 
{

	private JButton button;
	private int count;

	/** Constructor that adds a button on the frame.*/
	public ShowOptionAddedJFrame()
	{
		// call super constructor.
		super();

		// change color.
		Color frameBackground = Color.lightGray;
		setBackground(frameBackground);


		// instantiate a button.
		button=new JButton("Show Option");

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
	
	private class InnerActionListener  implements ActionListener
	{

		/** overridden method of action listener interface
		* that loads a show option dialog.
		*/
		public void actionPerformed(ActionEvent p1)
		{

			// instantiate an array of options.
			Object[] options={"Yes Please","No Way","Not Sure"};
			
			// instantiate show optino dialog
			int answer=JOptionPane.showOptionDialog(ShowOptionAddedJFrame.this,"Do you want to save changes?",
					"Save",JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,null,
					options,options[2]);
			
			switch (answer)
			{
				// yes
				case JOptionPane.YES_OPTION:
					JOptionPane.showMessageDialog(ShowOptionAddedJFrame.this,"'Yes' is a good choice.","Simple Message",JOptionPane.INFORMATION_MESSAGE);
					break;
				// no
				case JOptionPane.NO_OPTION:
					JOptionPane.showMessageDialog(ShowOptionAddedJFrame.this,"'No' is a bad choice.","Simple Message",JOptionPane.INFORMATION_MESSAGE);
					break;

				// cancel
				case JOptionPane.CANCEL_OPTION:
					JOptionPane.showMessageDialog(ShowOptionAddedJFrame.this,"'Not Sure' is not so bad.","Simple Message",JOptionPane.INFORMATION_MESSAGE);
					break;
				
				// close
				case JOptionPane.CLOSED_OPTION:
					JOptionPane.showMessageDialog(ShowOptionAddedJFrame.this,"You closed the window without selecting anything at all.","Simple Message",JOptionPane.INFORMATION_MESSAGE);
					break;

			}	
		}
	}

	/** main method for testing this class.*/
	public static void main(String[] args)
	{
		// instantiate an objec of this class and show it.
		ShowOptionAddedJFrame frame = new ShowOptionAddedJFrame();
		frame.setVisible(true);
	}
}
