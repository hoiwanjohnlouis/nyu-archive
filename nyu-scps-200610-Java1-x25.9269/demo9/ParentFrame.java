// Code 9O
/** A Frame that has menu and the menu opens Dialog.
* @author Mohammed Ashequr Rahman
* @version 1.0
*/
import java.awt.*;
import java.awt.event.*;
public class ParentFrame extends ClosableFrame
{
	private MenuBar menuBar;
	private Menu fileMenu;
	private MenuItem fileOpenMenuItem;
	private MenuItem fileCloseMenuItem;
	private MenuItem fileExitMenuItem;
	private CheckboxGroupAddedDialog dialog;

	/** Constructor that adds menu on the frame.*/
	public ParentFrame()
	{
		// call super constructor and add menu.
		super();
		addControls();

		// change color.
		Color frameBackground = Color.lightGray;
		setBackground(frameBackground);
	}

	/** Add menu to the frame.*/
	private void addControls()
	{
		// instantiate menu bar.
		menuBar= new MenuBar();

		// instantiate file menu and open, close and exit menu items
		// and add them to file menu.
		fileMenu = new Menu("File");
		MenuShortcut fileOpenMenuShortcut= new MenuShortcut('O'); //Control+O;
		fileOpenMenuItem = new MenuItem("Open",fileOpenMenuShortcut);
		MenuShortcut fileCloseMenuShortcut= new MenuShortcut('L'); //Control+L;
		fileCloseMenuItem = new MenuItem("Close",fileCloseMenuShortcut);
		MenuShortcut fileExitMenuShortcut= new MenuShortcut('X',true); //Control+Shift+C;
		fileExitMenuItem = new MenuItem("Exit",fileExitMenuShortcut);
		fileMenu.add(fileOpenMenuItem);
		fileMenu.add(fileCloseMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(fileExitMenuItem);

		// add file menu to the menu bar.
		menuBar.add(fileMenu);

		// add menu bar to the frame.
		setMenuBar(menuBar);

		// add listener to open, close and exit.
		fileOpenMenuItem.addActionListener(new InnerActionListener());
		fileCloseMenuItem.addActionListener(new InnerActionListener());
		fileExitMenuItem.addActionListener(new InnerActionListener());
	}
	private class InnerActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent p1)
		{
			// get the source of click.
			MenuItem menuItem= (MenuItem) p1.getSource();

			// if the menu item open is clicked 
			// and the dialog is not already open - open the dialog.
			if ((menuItem==fileOpenMenuItem) && (dialog==null))
			{
				// instantiate the dialog with the frame as parent.
				dialog= new CheckboxGroupAddedDialog(ParentFrame.this);

				// set the title, location and size of the dialog. 
				dialog.setTitle("Child Dialog");
				dialog.setLocation(150,150);
				dialog.setSize(300,300);

				// show the dialog
				dialog.show();
			}

			// if the menu item close is clicked 
			// and the dialog is already open - close the dialog.
			if ((menuItem==fileCloseMenuItem) && !(dialog==null))
			{
				// dispose the dialog.
				dialog.dispose();

				// re-set the variable.
				dialog=null;
			}

			// if exit is clicked - terminate the application.
			if (menuItem==fileExitMenuItem)
			{
				System.exit(0);
			}
		}
	}	

	/** main method for testing this class.*/
	public static void main(String[] args)
	{
		// instantiate a frame of this class.
		ParentFrame frame = new ParentFrame();

		// set the size and make it visible.
		frame.setSize(500,500);
		frame.setVisible(true);
	}
}
