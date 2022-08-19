// Code 10C
/** JPanel, JLabel, JTextField, JPasswordField, JButton, JTextArea added JFrame.*/
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class JTextComponentAddedJFrame extends ClosableJFrame  
{
	private JPanel panel;
	private JLabel IdLabel;
	private JTextField IdTextField;
	private JLabel labelPassword;
	private JPasswordField passwordField;
	private JButton button;
	private JTextArea textArea;
	
	/** Constructor that add other objects on the frame.*/
	public JTextComponentAddedJFrame()
	{
		// call super constructor.
		super();

		// add other controls on the frame.
		addControls();

		// change color of the frame background.
		Color frameBackground = Color.lightGray;
		setBackground(frameBackground);
	}

	/** method that adds controls on the frame.*/
	private void addControls()
	{
		// instantiate a label for user id.
		IdLabel = new JLabel("Enter user id:");

		// instantiate a text field for user id.
		// set preferred width to 10.
		IdTextField = new JTextField(10);

		// instantiate a label for password.
		labelPassword= new JLabel("Enter Password");

		// instantiate a password field for password input.
		// set preferred width to 8
		passwordField = new JPasswordField(8);

		// set the echo character to '*' so that for each
		// keystroke '*' prints instead of the actual password.
		passwordField.setEchoChar('*');

		// instantiate a button,
		button = new JButton("Show Input");

		// add listener to the button.
		button.addActionListener(new InnerActionListener());

		// instantiate a text area to show user input and password.
		textArea = new JTextArea();

		// make the text area read only.
		textArea.setEditable(false);

		// instantiate a panel as intermediate container.
		panel = new JPanel();


		// add labels, text components and the button to the panel.
		panel.add(IdLabel);
		panel.add(IdTextField);
		panel.add(labelPassword);
		panel.add(passwordField);
		panel.add(button);

		// add the panel to the frame.
		getContentPane().add(panel,"North");

		// add the text area to the frame.
		getContentPane().add(textArea,"Center");
	}

	/** overridden action listener interface method
	* that shows user id and password on the text area.
	*/
	private class InnerActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent p1)
		{
			textArea.setText("ID: " + IdTextField.getText() + "\n"
				+ "Password: " + (new String(passwordField.getPassword())) + "\n");
		}
	}

	/** main method for testing this class.*/
	public static void main(String[] args)
	{
		// instantiate an object of this class.
		JTextComponentAddedJFrame frame = new JTextComponentAddedJFrame();
		
		// set size and make it visible.
		frame.setSize(500,200);
		frame.setVisible(true);
	}

}