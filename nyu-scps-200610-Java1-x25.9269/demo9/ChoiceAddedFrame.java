// Code 9J
/** A Frame that has dropdown list (Choice).
* @author Mohammed Ashequr Rahman
* @version 1.0
*/
import java.awt.*;
import java.awt.event.*;
public class ChoiceAddedFrame extends ClosableFrame  
{
	private Panel panel;
	private Choice fruits;
	private TextField textArea;	

	/** Constructor that adds drop down list on a frame.*/
	public ChoiceAddedFrame()
	{
		// call super constructor and add drop down list.
		super();
		addControls();

		// change backcolor of the frame to light gray.
		Color frameBackground = Color.lightGray;
		setBackground(frameBackground);
	}

	/** method to add drop down list on a frame.*/
	private void addControls()
	{
		// instantiate a choice object.
		fruits = new Choice();

		// add items to the choice.
		fruits.add("Apple");
		fruits.add("Orange");
		fruits.add("Banana");

		// add listener.
		fruits.addItemListener(new InnerItemListener());

		// instantiate a readonly text field 
		textArea = new TextField();
		textArea.setEditable(false);

		// instantiate a panel with left justified flow layout.
		panel = new Panel(new FlowLayout(FlowLayout.LEFT));

		// add choice to the panel.
		panel.add(fruits);

		// add the panel to the north side of the frame.
		add(panel,"North");

		// add the text field to the south side of the frame.
		add(textArea,"South");
	}
	private class InnerItemListener implements ItemListener
	{

		/** overridden method of the item listener interface.*/
		public void itemStateChanged(ItemEvent p1)
		{

			// show the selected item on the text field.
			textArea.setText("Selected Item: "+
			fruits.getSelectedItem());
		}
	}

	/** tester for this class.*/
	public static void main(String[] args)
	{

		// instantiate an object of this class.
		ChoiceAddedFrame frame = new ChoiceAddedFrame();

		// set size and make it visible.
		frame.setSize(200,200);
		frame.setVisible(true);
	}


}
