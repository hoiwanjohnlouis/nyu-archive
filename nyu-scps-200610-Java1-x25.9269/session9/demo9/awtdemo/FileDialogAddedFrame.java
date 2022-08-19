// Code 9P
/** A Frame that has menu and the menu opens file Dialog.
* @author Mohammed Ashequr Rahman
* @version 1.0
*/
import java.awt.*;
import java.awt.event.*;
public class FileDialogAddedFrame extends ClosableFrame
{
	private MenuBar menuBar;
	private Menu fileMenu;
	private MenuItem fileOpenMenuItem;
	private MenuItem fileSaveMenuItem;
	private MenuItem fileExitItem;
	private FileDialog fileDialog;
	private TextField textArea;

	/** Costructor that adds menu.*/
	public FileDialogAddedFrame()
	{

		// call super constructor and add menu.
		super();
		addControls();

		// change backcolor to light gray.
		Color frameBackground = Color.lightGray;
		setBackground(frameBackground);
	}

	/** method that adds menu.*/
	private void addControls()
	{
		// instantiate menu bar.
		menuBar= new MenuBar();

		// instantiate file menu.
		fileMenu = new Menu("File");

		// instantiate open, save and exit menu item.
		MenuShortcut mscFileOpen= new MenuShortcut('O'); //Control+O;
		fileOpenMenuItem = new MenuItem("Open",mscFileOpen);
		MenuShortcut mscFileSave= new MenuShortcut('L'); //Control+L;
		fileSaveMenuItem = new MenuItem("Save",mscFileSave);
		MenuShortcut mscFileExit= new MenuShortcut('X',true); //Control+Shift+C;
		fileExitItem = new MenuItem("Exit",mscFileExit);

		// add file menu to menu bar.
		menuBar.add(fileMenu);

		// add menu items to file menu.
		fileMenu.add(fileOpenMenuItem);
		fileMenu.add(fileSaveMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(fileExitItem);

		// add menu bar to the frame.
		setMenuBar(menuBar);


		// add listener to the menu items.
		fileOpenMenuItem.addActionListener(new InnerActionListener());
		fileSaveMenuItem.addActionListener(new InnerActionListener());
		fileExitItem.addActionListener(new InnerActionListener());

		// intantiate text field and make it readonly.
		textArea = new TextField();
		textArea.setEditable(false);

		// add text field to the frame.
		add(textArea,"South");
	}

	private class InnerActionListener implements ActionListener
	{
		/** action listener interface method.*/
		public void actionPerformed(ActionEvent p1)
		{
			// get the source of click.
			MenuItem menuItem= (MenuItem) p1.getSource();

			// if open menu is clicked.
			if (menuItem==fileOpenMenuItem)
			{
				// instantiate a file dialog in open mode.
				fileDialog= new FileDialog(FileDialogAddedFrame.this,"Open",FileDialog.LOAD);
				// make it visible.
				fileDialog.show();
				
				// if the user does not select any file - nothing to show.
				if ( fileDialog.getFile()==null)
				{
					textArea.setText("");
				}
				// otherwise show the file name.
				else
				{
					textArea.setText("Open: " + fileDialog.getDirectory()
						 + fileDialog.getFile());
				}
				
				// set the variable to null.
				fileDialog=null;
			}

			// if save menu is clicked.
			if (menuItem==fileSaveMenuItem)
			{

				// instantiate a file dialog in save mode.
				fileDialog= new FileDialog(FileDialogAddedFrame.this,"Save",FileDialog.SAVE);
				// show the dialog.
				fileDialog.show();

				// if no file is selected - nothing to show.
				if ( fileDialog.getFile()==null)
				{
					textArea.setText("");
				}
				// if any file is selected - show the file name.
				else
				{
					textArea.setText("Save: " + fileDialog.getDirectory()
						 + fileDialog.getFile());
				}
				// reset the variable.
				fileDialog=null;
			}
			// if exit menu is clicked.
			if (menuItem==fileExitItem)
			{
				// exit the system.
				System.exit(0);
			}
		}
	}

	/** main method for testing this class.*/
	public static void main(String[] args)
	{
		// instatiate a frame of this class.
		FileDialogAddedFrame frame = new FileDialogAddedFrame();

		// set size and make it visible.
		frame.setSize(500,500);
		frame.setVisible(true);
	}
}
