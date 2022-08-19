// Code 9K
/** A Frame that has listbox.
* @author Mohammed Ashequr Rahman
* @version 1.0
*/
import java.awt.*;
import java.awt.event.*;
public class ListAddedFrame extends ClosableFrame 
{
	private Panel panel;
	private List fruits;
	private TextField textField;	

	/** Constructor that adds listbox on a frame.*/
	public ListAddedFrame()
	{
		// call super constructor and add listbox.
		super();
		addControls();

		// change backcolor of the frame to light gray.
		Color frameBackground = Color.lightGray;
		setBackground(frameBackground);
	}

	/** method to add listbox on a frame.*/
	private void addControls()
	{
		// instantiate a List object.
		// the list will display 3 rows at any time.
		fruits = new List(3);

		// add items to the List.
		fruits.add("Apple");
		fruits.add("Orange");
		fruits.add("Banana");
		fruits.add("Grape");
		fruits.add("Mango");

		// add listener.
		fruits.addItemListener(new InnerItemListerner());

		// instantiate a readonly text field 
		textField = new TextField();
		textField.setEditable(false);

		// instantiate a panel with left justified flow layout.
		panel = new Panel(new FlowLayout(FlowLayout.LEFT));

		// add List to the panel.
		panel.add(fruits);

		// add the panel to the north side of the frame.
		add(panel,"North");

		// add the text field to the south side of the frame.
		add(textField,"South");
	}
	private class InnerItemListerner implements ItemListener
	{

		/** overridden method of the item listener interface.*/
		public void itemStateChanged(ItemEvent p1)
		{

			// show the selected item on the text field.
			textField.setText("Selected Item: "+
			fruits.getSelectedItem());
		}
	}

	/** tester for this class.*/
	public static void main(String[] args)
	{

		// instantiate an object of this class.
		ListAddedFrame frame = new ListAddedFrame();

		// set size and make it visible.
		frame.setSize(200,200);
		frame.setVisible(true);
	}


}
