// Code 9N
/** A Dialog that has radio buttons.
* @author Mohammed Ashequr Rahman
* @version 1.0
*/
import java.awt.*;
import java.awt.event.*;
public class CheckboxGroupAddedDialog extends Dialog
{
	private CheckboxGroup group;	
	private Panel panel;
	private Checkbox red;
	private Checkbox green;
	private Checkbox blue;
	private TextArea textArea;

	/** Constructor that adds controls on the frame.
	* @param prentFrame Parent Frame for this dialog.
	*/
	public CheckboxGroupAddedDialog(Frame prentFrame)
	{
		// call super contructor and add controls.
		super(prentFrame);
		addControls();

		// change backcolor to light gray.
		Color dialogBackground = Color.lightGray;
		setBackground(dialogBackground);
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
		red.addItemListener(new InnerRedItemListener());
		green = new Checkbox("Green",group,false);
		green.addItemListener(new InnerGreentemListener());
		blue = new Checkbox("Blue",group,false);
		blue.addItemListener(new InnerBlueItemListener());
		
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

	private class InnerRedItemListener implements ItemListener
	{
		/** overridden method of item listener interface.*/
		public void itemStateChanged(ItemEvent p1)
		{
			String stateString;

			// get the state of the checkbox being clicked on.
			boolean state=((Checkbox) p1.getSource()).getState();
			stateString= "Red: " + state;
			
			// append the check box name and it's state on the text area.
			textArea.setText(textArea.getText() + stateString + "\n");
		}
	}

	private class InnerBlueItemListener implements ItemListener
	{
		/** overridden method of item listener interface.*/
		public void itemStateChanged(ItemEvent p1)
		{
			String stateString;

			// get the state of the checkbox being clicked on.
			boolean state=blue.getState();
			stateString= "Blue: " + state;
			
			// append the check box name and it's state on the text area.
			textArea.setText(textArea.getText() + stateString + "\n");
		}
	}

	private class InnerGreentemListener implements ItemListener
	{
		/** overridden method of item listener interface.*/
		public void itemStateChanged(ItemEvent p1)
		{
			// append the check box name and it's state on the text area.
			textArea.setText(textArea.getText() + "Green: " + green.getState() + "\n");
		}
	}

}
