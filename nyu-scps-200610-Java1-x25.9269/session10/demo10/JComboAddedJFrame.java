// Code 10G
/** A frame that has combo box on it.*/
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class JComboAddedJFrame extends ClosableJFrame 
{
	private JComboBox comboBox;
	private JLabel label;

	public JComboAddedJFrame()
	{
		// instantiate an array of string.
		String[] pets = {"Bird","Rabbit","Pig"};

		// instantiate a combo box with the string array.
		comboBox = new JComboBox(pets);

		// make the 3rd item 'Pig' selected by default.
		comboBox.setSelectedIndex(2);

		// make the combo box editable so that the user can type.
		comboBox.setEditable(true);

		// Register a listener for the combo.
		comboBox.addActionListener(new InnerActionListener());

		// load 'pig.gif' on the label since
		// Pig is selected by default.
		label = new JLabel(new ImageIcon("Pig" + ".gif"));

		// The preferred size is hard-coded to be the width of the
		// widest image and the height of the tallest image.
		// A real program would compute 
		label.setPreferredSize(new Dimension(177, 122));

		
		// add the combo and the label on the frame.
		getContentPane().add(comboBox, BorderLayout.NORTH);
		getContentPane().add(label, BorderLayout.SOUTH);
	}

	private class InnerActionListener implements ActionListener
	{
		/** overridden action listener interface method
		* that load appropriate picture based on user selection.
		*/
		public void actionPerformed(ActionEvent e)
		{
			label.setIcon(new ImageIcon((
			(JComboBox) e.getSource()).getSelectedItem() + ".gif"));
		}
	}

	/** main method for testing this class.*/
	public static void main(String args[])
	{
		// instantiate an object of this class.
		JComboAddedJFrame frame = new JComboAddedJFrame();

		// resize and display.
		frame.pack();
		frame.setVisible(true);
	}
}

