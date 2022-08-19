// Code 10D
/** A frame with check boxes.*/
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class JCheckBoxAddedJFrame extends ClosableJFrame
{
	private  JCheckBox chin;
	private  JCheckBox glasses;
	private  JCheckBox hair;
	private  JCheckBox teeth;

	private   StringBuffer selections;
	private  JLabel label;

	/** Constructor that adds checkboxes.*/
	public JCheckBoxAddedJFrame() 
	{

		// call super constructor.
		super();

		// instantiate the check boxes with hot key and checked off.
		chin = new JCheckBox("Chin");
		chin.setMnemonic(KeyEvent.VK_C); 
		chin.setSelected(true);

		glasses = new JCheckBox("Glasses");
		glasses.setMnemonic(KeyEvent.VK_G); 
		glasses.setSelected(true);

		hair = new JCheckBox("Hair");
		hair.setMnemonic(KeyEvent.VK_H); 
		hair.setSelected(true);

		teeth = new JCheckBox("Teeth");
		teeth.setMnemonic(KeyEvent.VK_T); 
		teeth.setSelected(true);

		// Register a listener for the check boxes.
		chin.addItemListener(new InnnerItemListener());
		glasses.addItemListener(new InnnerItemListener());
		hair.addItemListener(new InnnerItemListener());
		teeth.addItemListener(new InnnerItemListener());

		// initially all the options are checked.
		// let's initialize our tracking string buffer with 'cght'
		selections = new StringBuffer("cght");

		// instantiate the label with appropriate picture.
		label = new JLabel(new ImageIcon("geek-"
			+ selections.toString() + ".gif"));

		// set tooltiptext of the label.
		label.setToolTipText(selections.toString());

	        // instantiate a panel with 1 column gridlayout.
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1));

		// add check boxes to the panel.
		panel.add(chin);
		panel.add(glasses);
		panel.add(hair);
		panel.add(teeth);
		

		// add the panel and the label to the frame.
		getContentPane().add(panel, BorderLayout.WEST);
		getContentPane().add(label, BorderLayout.CENTER);

		// resize the frame.
		pack();
	}
	
	private class InnnerItemListener implements ItemListener
	{

		/** overridden method of item listener interface.*/
		public void itemStateChanged(ItemEvent e) 
		{
			int index = 0;
			char c = '-';

			// get the source of click.
			Object source = e.getItemSelectable();

			// if the source is chin check box put 'c'
			if (source == chin)
			{
				index = 0;
				c = 'c';
		    	}
			// if the source is glasses check box put 'g' 
			else if (source == glasses)
			{
				index = 1;
		        		c = 'g';
			} 
			// if the source is hair check box put 'h'.
			else if (source == hair)
			{
				index = 2;
				c = 'h';
			}
			// if the source is teeth check box put 't'.
			else if (source == teeth)
			{
				index = 3;
				c = 't';
			}

			// if the check box is deselected replace 'c' or 'g' or
			// 'h' or 't' set above with a dash.
			if (e.getStateChange() == ItemEvent.DESELECTED)
			{
				c = '-';
			}

			// update the string buffer with user's choice.
			selections.setCharAt(index, c);

			// select new image based on user's select of
			// check boxes.
			label.setIcon(new ImageIcon(
				"geek-"
				+ selections.toString() + ".gif"));

			// change the tooltiptext.
			label.setToolTipText(selections.toString());
		}
	}

	/** main method for testing this class.*/
	public static void main(String args[]) 
	{
		// instantiate an object of this class and display it.
        	JCheckBoxAddedJFrame frame = new JCheckBoxAddedJFrame();
         	frame.setVisible(true);
	}
}
