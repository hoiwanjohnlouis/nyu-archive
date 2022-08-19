// Code 10L
/** A frame that has a menu on it.*/
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
public class JMenuAddedJFrame extends ClosableJFrame 
{
	private JMenuBar menuBar;

	private JMenu fileMenu;
	private JMenuItem fileOpenMenuItem;
	private JMenuItem fileCloseMenuItem;

	private JMenu editMenu;
	private JMenu editColorMenu;
	private JCheckBoxMenuItem redCheckBoxMenuItem;
	private JCheckBoxMenuItem greenCheckBoxMenuItem;
	private JCheckBoxMenuItem blueCheckBoxMenuItem;
	
	private JTextField textField;

	/** Constructor that adds menu on the frame.*/
	public JMenuAddedJFrame()
	{
		// call super constructor.
		super();
	
		// add menu on the frame.
		addControls();


		// change backcolor of the frame.
		Color frameBackground = Color.lightGray;
		setBackground(frameBackground);
	}

	/** method that addes menu on the frame.*/
	private void addControls()
	{
		// instantiate menu bar.
		menuBar= new JMenuBar();

		// instantiate file menu.
		fileMenu = new JMenu("File");


		// instantiate open and close menu item.
		fileOpenMenuItem = new JMenuItem("Open");
		fileCloseMenuItem = new JMenuItem("Close");

		// add action listener to the menu items.
		fileOpenMenuItem.addActionListener(new InnerActionListener());
		fileCloseMenuItem.addActionListener(new InnerActionListener());

		// add open and close menu item to file menu.
		fileMenu.add(fileOpenMenuItem);
		fileMenu.add(fileCloseMenuItem);

		// add file menu to menu bar.
		menuBar.add(fileMenu);

		// instantiate edit menu.
		editMenu = new JMenu("Edit");

		// instantiate color menu.
		editColorMenu = new JMenu("Color");

		// instantitate red,greeen and blue check box menu items.
		// make green checked off by default.
		redCheckBoxMenuItem= new JCheckBoxMenuItem("Red");
		greenCheckBoxMenuItem =new JCheckBoxMenuItem("Green",true);
		blueCheckBoxMenuItem=new JCheckBoxMenuItem("Blue");

		// add the check box menu items to color menu.
		editColorMenu.add(redCheckBoxMenuItem);		
		editColorMenu.add(greenCheckBoxMenuItem);		
		editColorMenu.add(blueCheckBoxMenuItem);
		
		// add item listener to check box menu items.
		redCheckBoxMenuItem.addItemListener(new InnerItemListener());		
		blueCheckBoxMenuItem.addItemListener(new InnerItemListener());		
		greenCheckBoxMenuItem.addItemListener(new InnerItemListener());		

		// add color menu to edit menu.
		editMenu.add(editColorMenu);

		// add edit menu to menu bar.
		menuBar.add(editMenu);

		// add menu bar to frame.
		setJMenuBar(menuBar);


		// instantiate read only text field.
		textField = new JTextField();
		textField.setEditable(false);

		// add text field to the frame.
		getContentPane().add(textField,"South");
	}
	
	private class InnerItemListener implements ItemListener
	{

		/** overridden method of item listener interface.*/
		public void itemStateChanged(ItemEvent p1)
		{
			// get the source check box menu item.
			JCheckBoxMenuItem anyCheckBoxMenuItem = (JCheckBoxMenuItem) p1.getSource();

			// show the state of check box menu item.
			textField.setText(anyCheckBoxMenuItem.getText() 
				+ " State: " + anyCheckBoxMenuItem.getState());
		}
	}

	private class InnerActionListener implements ActionListener
	{
		/** overridden method of action listener interface.*/	
		public void actionPerformed(ActionEvent p1)
		{
			// get the source of menu item.
			JMenuItem anyMenuItem= (JMenuItem) p1.getSource();

			// show the state of the menu item.
			textField.setText("JMenu Clicked: " +
				anyMenuItem.getText());
		}
	}

	/** main method for testing this class.*/
	public static void main(String[] args)
	{
		// instatiate an object of this class, set size 
		// and make it visible.
		JMenuAddedJFrame frame = new JMenuAddedJFrame();
		frame.setSize(200,200);
		frame.setVisible(true);
	}
}
