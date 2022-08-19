// Code 10M
/** An applet that has a list box on it.*/
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class JListAddedJApplet extends JApplet 
{
	private JList list;
	private JLabel label;
	private String[] pets = {"Bird","Rabbit","Pig","Cat","Dog"};


	/** Constructor that adds list.*/
	public JListAddedJApplet()
	{
		
		// Create the Listbox.
		list = new JList(pets);
	
		// make the third item 'Pig' selected by default.
		list.setSelectedIndex(2);

		// Register a listener for the list.
		list.addListSelectionListener(new InnerListSelectionListener());

		// load 'pig.gif' on a label by default since it is
		// the selected item by default.
		label = new JLabel(new ImageIcon("Pig" + ".gif"));

		// The preferred size is hard-coded to be the width of the
		// widest image and the height of the tallest image.
		// A real program would compute 
		label.setPreferredSize(new Dimension(177, 122));

		// add the list and label to the the applet.
		getContentPane().add(list, BorderLayout.WEST);
		getContentPane().add(label, BorderLayout.EAST);

		// make the applet visible.
		setVisible(true);
	}

	private class InnerListSelectionListener implements ListSelectionListener
	{
		/** overridden method of list selection listener interface.*/
		public void valueChanged(ListSelectionEvent e)
		{
			//  change the picture as the user changes selection.
			label.setIcon(new ImageIcon(
				pets[((JList) 
				e.getSource()).getSelectedIndex()]
				+ ".gif"));
		}
	}

}
