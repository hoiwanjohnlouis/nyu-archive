// Code 10A1
/** A JFrame that terminates the application on close.*/
import javax.swing.JFrame;
public class SelfClosingJFrame extends JFrame
{

	/** Constructor that sets title,size and location
	* and adds window listener.
	*/
	public SelfClosingJFrame()
	{
		// call super constructor.
		super();

		// set title,size and location.
		setTitle(getClass().getName());
		setSize(300,200);
		setLocation(100,100);

		// set exit on close
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}


	/** The main method for testing this class.*/
	public static void main(String[] args)
	{
		// instantiate an objec of this class and make it visible.
		SelfClosingJFrame frame = new SelfClosingJFrame();
		frame.setVisible(true);
	}	 
}
