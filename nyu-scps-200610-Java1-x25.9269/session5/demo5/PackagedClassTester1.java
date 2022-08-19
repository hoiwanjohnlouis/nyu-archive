import mypackage.PackagedClass;

// this code does not compile
public class PackagedClassTester1 {

	/** The main method(automatically called by JVM)
	* that creates an instance of Packaged and calls
	* DisplayName() method.
	*/
	public static void main(String[] args)
	{
		//create an object of PackgedClass type.
		PackagedClass packagedClass=new PackagedClass();
		//call the method
		packagedClass.displayName();
	}
}
