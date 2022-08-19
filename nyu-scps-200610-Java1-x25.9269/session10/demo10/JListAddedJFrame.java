// Code 10E
/* A Frame that has a list box on it.*/
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class JListAddedJFrame extends ClosableJFrame 
{
	private JList list;
	private JLabel label;
	private String[] pets = {"Bird","Rabbit","Pig","Cat","Dog"};


	public JListAddedJFrame()
	{
		
		// Instantiate a Listbox.
		list = new JList(pets);

		// select the 3rd item 'Pig' by default.
		list.setSelectedIndex(2);

		// Register a listener for the list.
		list.addListSelectionListener(new InnerListSelectionListener());

		// Instantiate a label with a 'Pig' picture.
		label = new JLabel(new ImageIcon("Pig.gif"));

		// The preferred size is hard-coded to be the width of the
		// widest image and the height of the tallest image.
		// A real program would compute 
		label.setPreferredSize(new Dimension(177, 122));
		
		// add the list to the frame.
		getContentPane().add(list, BorderLayout.WEST);

		// add the label to the frame.
		getContentPane().add(label, BorderLayout.EAST);
	}

	/** overridden method of listselection listener
	* that changes pictures as the user changes selection.
	*/
	private class InnerListSelectionListener implements ListSelectionListener
	{
		public void valueChanged(ListSelectionEvent e)
		{
			// change the picture by using user selection
			// as picture name.
			label.setIcon(new ImageIcon(pets[((JList) 
				e.getSource()).getSelectedIndex()] + ".gif"));
		}
	}

	/** main method for testing this class.*/
	public static void main(String args[])
	{
		// instantiate an ojbect of this class.
		JListAddedJFrame frame = new JListAddedJFrame();

		// resize and make it visible.
		frame.pack();
		frame.setVisible(true);
	}
}
