// Code 9I
/** A Frame that has radio buttons.
* @author Mohammed Ashequr Rahman
* @version 1.0
*/

import java.awt.*;
import java.awt.event.*;
public class CheckboxGroupAddedFrame extends ClosableFrame 
{
	private CheckboxGroup group;	
	private Panel panel;
	private Checkbox red;
	private Checkbox green;
	private Checkbox blue;
	private TextArea textArea;

	/** Constructor that adds controls on the frame.*/
	public CheckboxGroupAddedFrame()
	{
		// call super contructor and add controls.
		super();
		addControls();

		// change backcolor to light gray.
		Color frameBackground = Color.lightGray;
		setBackground(frameBackground);
	}

	/** Add checkbox on the frame.*/
	private void addControls()
	{
		// instantiate a check box group object.
		group = new CheckboxGroup();

		// instantiate three checkboxes under the same group.
		// make them unchecked by using the flag 'false'.
		// add listener the checkboxes.
		red = new Checkbox("Red",group,false);
		red.addItemListener(new InnerGenericItemListener());
		green = new Checkbox("Green",group,false);
		green.addItemListener(new InnerGenericItemListener());
		blue = new Checkbox("Blue",group,false);
		blue.addItemListener(new InnerGenericItemListener());
		
		// instantiate readonly testarea.
		textArea = new TextArea(2,20);
		textArea.setEditable(false);
		
		// instantiate a panel with grid layout.
		panel = new Panel(new GridLayout(0,1));
	
		// add three checkboxes to the panel.
		panel.add(red);
		panel.add(green);
		panel.add(blue);

		// add the panel to the "West" side of the frame.
		add(panel,"West");

		// add the text area to the "Center" of the frame.
		add(textArea,"Center");
	}

	private class InnerGenericItemListener implements ItemListener
	{
		/** overridden method of item listener interface.*/
		public void itemStateChanged(ItemEvent p1)
		{
			String stateString;

			// get the stateString of the checkbox being clicked on.
			Object o = p1.getSource();
			Checkbox source = (Checkbox) o;
			boolean state = source.getState();
			String label = source.getLabel();
			

			stateString= label + ": "+ state;
			
			// append the check box name and it's stateString on the text area.
			textArea.setText(textArea.getText() + stateString + "\n");
		}
	}


	/** tester for this object.*/
	public static void main(String[] args)
	{
		// instantiate an object of this class.
		CheckboxGroupAddedFrame frame = new CheckboxGroupAddedFrame();

		// set size and make it visible.
		frame.setSize(500,300);
		frame.setVisible(true);
	}

}
