public class PackagedClassTester2 {

	/** The main method(automatically called by JVM)
	* that creates an instance of Packaged and calls
	* DisplayName() method.
	*/
	public static void main(String[] args)
	{
		//create an object of PackgedClass type.
		mypackage.PackagedClass packagedClass=new mypackage.PackagedClass();
		//call the method
		packagedClass.displayName();
	}
}
