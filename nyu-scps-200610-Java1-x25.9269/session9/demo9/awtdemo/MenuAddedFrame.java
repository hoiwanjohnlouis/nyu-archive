// Code 9M
/** A Frame that has menu.
* @author Mohammed Ashequr Rahman
* @version 1.0
*/
import java.awt.*;
import java.awt.event.*;
public class MenuAddedFrame extends ClosableFrame
{
	private MenuBar menuBar;

	private Menu fileMenu;
	private MenuItem fileOpenMenuItem;
	private MenuItem fileCloseMenuItem;
	private MenuItem fileExitMenuItem;

	private Menu editMenu;
	private MenuItem editCutMenuItem;
	private MenuItem editCopyMenuItem;
	private MenuItem editPasteMenuItem;
	private Menu colorMenu;
	private CheckboxMenuItem redCheckboxMenuItem;
	private CheckboxMenuItem greenCheckboxMenuItem;
	private CheckboxMenuItem blueCheckboxMenuItem;
	
	private TextField textField;

	/** constructor that adds menu.*/
	public MenuAddedFrame()
	{
		// call the super constructor and add menu.
		super();
		addControls();

		// set backcolor.
		Color frameBackground = Color.lightGray;
		setBackground(frameBackground);
	}

	/** method that adds menu.*/
	private void addControls()
	{
		// instantiate a menubar.
		menuBar= new MenuBar();

		// instantiate a file menu.
		fileMenu = new Menu("File");

		// instantiate a Control+O shortcut for open.
		MenuShortcut fileOpenMenuShortcut= new MenuShortcut('O'); //Control+O;

		// intantiate a menu item for open with shortcut.
		fileOpenMenuItem = new MenuItem("Open",fileOpenMenuShortcut);

		// instantiate a menu item for close with shortcut Control+L.
		MenuShortcut fileCloseMenuShortcut= new MenuShortcut('L'); //Control+L;
		fileCloseMenuItem = new MenuItem("Close",fileCloseMenuShortcut);

		// instantiate a menu itme for exit with shortcut Control+Shift+X.
		// the last flag 'true' is used to include shift on the shortcut.
		MenuShortcut fileExitMenuShortcut= new MenuShortcut('X',true); //Control+Shift+X;
		fileExitMenuItem = new MenuItem("Exit",fileExitMenuShortcut);

		// add open and close menu items to file menu.
		fileMenu.add(fileOpenMenuItem);
		fileMenu.add(fileCloseMenuItem);

		// add a separator to file menu.
		fileMenu.addSeparator();

		// now add exit menu item to file menu.
		fileMenu.add(fileExitMenuItem);


		// instantiate edit menu.
		editMenu = new Menu("Edit");

		// instantiate cut, copy and paste menu items with shortcuts.
		MenuShortcut editCutMenuShortcut= new MenuShortcut('X'); //Control+X;
		editCutMenuItem = new MenuItem("Cut",editCutMenuShortcut);
		MenuShortcut editCopyMenuShortcut= new MenuShortcut('C'); //Control+C;
		editCopyMenuItem = new MenuItem("Copy",editCopyMenuShortcut);
		MenuShortcut editPasteMenuShortcut= new MenuShortcut('V'); //Control+V;
		editPasteMenuItem = new MenuItem("Paste",editPasteMenuShortcut);


		// add cut, copy and paste menu items to edit menu.
		editMenu.add(editCutMenuItem);
		editMenu.add(editCopyMenuItem);
		editMenu.add(editPasteMenuItem);

		// add a separator to edit menu.
		editMenu.addSeparator();

		// instantiate a color menu.	
		colorMenu = new Menu("Color");

		// instantiate check box menu items red, green and blue.
		// make green checked by adding the flag 'true'.
		redCheckboxMenuItem= new CheckboxMenuItem("Red");
		greenCheckboxMenuItem =new CheckboxMenuItem("Green",true);
		blueCheckboxMenuItem=new CheckboxMenuItem("Blue");

		// add the check box menu items to color menu.
		colorMenu.add(redCheckboxMenuItem);		
		colorMenu.add(greenCheckboxMenuItem);		
		colorMenu.add(blueCheckboxMenuItem);		

		// add the color menu to edit menu.
		// notice we are adding menu(not menu item) to menu.
		editMenu.add(colorMenu);

		// add the file and edit menu to the menu bar.
		menuBar.add(fileMenu);
		menuBar.add(editMenu);

		// add the menu bar to the frame.
		setMenuBar(menuBar);

		// instantiate a readonly text field and add it to the frame.
		textField = new TextField();
		textField.setEditable(false);
		add(textField,"South");

		// add action listener to all the menu items.
		fileOpenMenuItem.addActionListener(new InnerActionListener());
		fileCloseMenuItem.addActionListener(new InnerActionListener());
		fileExitMenuItem.addActionListener(new InnerActionListener());
		editCutMenuItem.addActionListener(new InnerActionListener());
		editCopyMenuItem.addActionListener(new InnerActionListener());
		editPasteMenuItem.addActionListener(new InnerActionListener());

		// add item listener to all the check box menu items.
		redCheckboxMenuItem.addItemListener(new InnerItemListener());		
		blueCheckboxMenuItem.addItemListener(new InnerItemListener());		
		greenCheckboxMenuItem.addItemListener(new InnerItemListener());		
	}
    private class InnerItemListener implements ItemListener
	{
		public void itemStateChanged(ItemEvent p1)
		{
			// display the status of the check box items on the text field.
			CheckboxMenuItem checkboxMenuItem = (CheckboxMenuItem) p1.getSource();
			textField.setText(checkboxMenuItem.getLabel() + " State: " +
			checkboxMenuItem.getState());
		}
	}

	private class InnerActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent p1)
		{
			// display the status of the menu items on the text field.
			MenuItem menuItem= (MenuItem) p1.getSource();
			textField.setText("Menu Item Clicked: " +
			menuItem.getLabel());
		}
	}

	/** main method to test this class.*/
	public static void main(String[] args)
	{
		// instantiate this object and show it.
		MenuAddedFrame frame = new MenuAddedFrame();
		frame.setSize(200,200);
		frame.setVisible(true);
	}
}
