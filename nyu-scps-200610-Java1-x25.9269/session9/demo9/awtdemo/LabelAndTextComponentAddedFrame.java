// Code 9G
/** A Frame that has label and text components.
* @author Mohammed Ashequr Rahman
* @version 1.0
*/
import java.awt.*;
import java.awt.event.*;
public class LabelAndTextComponentAddedFrame extends ClosableFrame  
{
	private Panel panel;
	private Label labelId;
	private TextField textFieldId;
	private Label labelPassword;
	private TextField textFieldPassword;
	private Button showButton;
	private TextArea textArea;
	
	/** Constructor.*/
	public LabelAndTextComponentAddedFrame()
	{
		// call super constructor.
		super();
		// add controls on the frame.
		addControls();

		// change backcolor to light gray.
		Color frameBackground = Color.lightGray;
		setBackground(frameBackground);
	}

	/** Add panel, label, textfield and textarea on the frame.*/
	private void addControls()
	{
			// label and field for user id.		
			labelId = new Label("Enter User ID:");
			textFieldId = new TextField(8);

			// label and field for password.
			labelPassword= new Label("Enter Password");
			textFieldPassword = new TextField(8);

			// change the text field's echo character to '*'.
			textFieldPassword.setEchoChar('*');

			// a button.
			showButton = new Button("Show Input");
	
			// add action listener to the button.
			showButton.addActionListener(new LabelAndTextComponentAddedFrame.InnerActionListener());

			// read only text area.
			textArea = new TextArea(2,20);
			textArea.setEditable(false);

			// panel as intermediate container.
			panel = new Panel();

			//add labels and text fields and a button to the panel.
			// panel uses flow layout by default.
			panel.add(labelId);
			panel.add(textFieldId);
			panel.add(labelPassword);
			panel.add(textFieldPassword);
			panel.add(showButton);
			
			// add the panel to the "North" side of the frame.
			// frame uses border layout by default.
			// since the panel contains label, text fields and button
			// they will also apprea on the north side of the frame. 
			add(panel,"North");
	
			// add the text area to the "Center" of the frame.
			add(textArea,"Center");
	}

	private class InnerActionListener implements ActionListener
	{
		/** overridden method of action listener interface.
		* that shows user id and password.
		*/
		public void actionPerformed(ActionEvent p1)
		{
			// show user id and password on the text area.
			textArea.setText("ID: " + textFieldId.getText() + "\n"
				+ "Password: " + textFieldPassword.getText() + "\n");
		}
	}
	/** tester for this class.*/
	public static void main(String[] args)
	{
		// instantiate an object of this class.
		LabelAndTextComponentAddedFrame frame = new LabelAndTextComponentAddedFrame();

		// set size and make it visible.
		frame.setSize(500,200);
		frame.setVisible(true);
	}


}
