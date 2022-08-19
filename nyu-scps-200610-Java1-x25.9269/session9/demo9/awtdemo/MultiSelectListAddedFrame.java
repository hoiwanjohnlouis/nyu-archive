// Code 9L
/** A Frame that has multiselect listbox.
* @author Mohammed Ashequr Rahman
* @version 1.0
*/
import java.awt.*;
import java.awt.event.*;
public class MultiSelectListAddedFrame extends ClosableFrame 
{
	private Panel panel;
	private List fruits;
	private TextArea textArea;

	/** no-argument constructor.*/
	public MultiSelectListAddedFrame()
	{
		// call super constructor.
		super();
		// add objects to the frame.
		addControls();

		// change backcolor of the frame to light gray.
		Color frameBackground = Color.lightGray;
		setBackground(frameBackground);
	}

	/** adds multiselect list box to the frame.*/
	private void addControls()
	{
		// instantiate a list with 4 visible rows
		// make it multiselect by passing 'true' flag
		fruits = new List(4,true);

		// add items to the list.
		fruits.add("Apple");
		fruits.add("Orange");
		fruits.add("Banana");
		fruits.add("Grape");
		fruits.add("Mango");

		// add listener to the list.
		fruits.addItemListener(new InnerItemListener());

		// instantiate readonly textarea
		textArea = new TextArea(5,0);
		textArea.setEditable(false);

		// instantiate panel.
		panel = new Panel(new FlowLayout(FlowLayout.LEFT));
		
		// add list to the panel.
		panel.add(fruits);

		// add panel to the "North" side.
		add(panel,"North");

		// add text area to the "South" side.
		add(textArea,"South");
	}

	private class InnerItemListener implements ItemListener
	{
		/** overridden method of item listener interface.*/
		public void itemStateChanged(ItemEvent p1)
		{
			// an array for selected item.
			String[] fruitsArray;

			// string to store selected items.
			String selectedFruits=new String();
	
			// get the selected items.
			fruitsArray=fruits.getSelectedItems();

			// if one or more item is selected - prepare the string for display.
			if (fruitsArray.length >0)
			{
				selectedFruits="Selected Items:\n";

				// loop through all the selected items.
				for (int n=0; n < fruitsArray.length; n++)
				{
					selectedFruits=selectedFruits + fruitsArray[n] + "\n";
				}
			}

			// display the string.
			textArea.setText(selectedFruits);
		}
	}

	/** the main method for testing this class.*/
	public static void main(String[] args)
	{
		// instantiate a multi select list frame.
		MultiSelectListAddedFrame frame = new MultiSelectListAddedFrame();

		//set size and make it visible.
		frame.setSize(200,300);
		frame.setVisible(true);
	}
}
