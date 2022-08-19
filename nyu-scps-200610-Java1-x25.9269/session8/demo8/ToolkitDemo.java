// Code 8B
/** A class that will display information on Toolkit and GraphicsEnvironment.
* @author Mohammed Ashequr Rahman
* @version 1.0
*/

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
public class ToolkitDemo
{

	public static void main(String[] args)
	{
		//get the Toolkit object for this machine.
		Toolkit defaultToolkit=Toolkit.getDefaultToolkit();

		// print the name of the sub-class of Toolkit since 
		//Toolkit is an abstract class.
		System.out.println("Default Toolkit Class: " 
			+ defaultToolkit.getClass().getName());
		System.out.println();

		// get the screen size of this machine and display it.
		Dimension dimScreen = defaultToolkit.getScreenSize();
		System.out.println("Screen Width: " + dimScreen.width +
				 " Screen Height: " + dimScreen.height);
		System.out.println();

		// get the GraphicsEnvironment of this machine.
		GraphicsEnvironment localGraphicsEnvironment=GraphicsEnvironment.getLocalGraphicsEnvironment();

		// print the name of the sub-class of GraphicsEnvironment since
		// GraphicsEnvironment is an abstract class.
		System.out.println("Default GraphicsEnvironment Class: " +
			 localGraphicsEnvironment.getClass().getName());
		System.out.println();

		// get all the fonts available on this machine in array.
		String[] fontNames = localGraphicsEnvironment.getAvailableFontFamilyNames();

		// print the font names.
		System.out.println("Available fonts on this platform: ");
		for (int nI = 0; nI < fontNames.length; nI++)
		{
			System.out.println(fontNames[nI]);
		}
		// Exit System
		System.exit(0);
	}
}

