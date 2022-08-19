// Code 10K
/** A show input dialog added frame.*/
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JOptionPane;
public class ShowInputAddedJFrame extends ClosableJFrame 
{

	private JButton button;
	private int count;
	public ShowInputAddedJFrame()
	{
		// call super constructor.
		super();
		// change color.
		Color frameBackground = Color.lightGray;
		setBackground(frameBackground);


		// instantiate a button.
		button=new JButton("Show Input");

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
		* that loads a show input dialog.
		*/
		public void actionPerformed(ActionEvent p1)
		{
			
			String answer = new String();

			// if user clicks on cancel exception is thrown.
			// let's catch the exception and do nothing.
			try
			{
				// load show input dialog.
				answer=JOptionPane.showInputDialog(ShowInputAddedJFrame.this,"Enter your name",
					"Name",JOptionPane.PLAIN_MESSAGE);
			}
			catch(Exception e)
			{
				;
			}
			
			// if the user inputs his name
			if (!(answer==null) && (answer.length() != 0))
			{
				JOptionPane.showMessageDialog(ShowInputAddedJFrame.this,"Thank You " + answer,
				"Simple Message",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}	
		
	/** main method for testing this class.*/
	public static void main(String[] args)
	{
		// instantiate an object of this class and show it.
		ShowInputAddedJFrame frame = new ShowInputAddedJFrame();
		frame.setVisible(true);
	}
}
