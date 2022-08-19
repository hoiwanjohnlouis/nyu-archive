public class NameTester
{
	/** The main method(automatically invoked by JVM) that 
	* creates a new Name object and stores and 
	* retrieves field values.
	*/
	public static void main(String[] args)
	{
		// creates a new name Object
		Name name= new Name("Joe","L","Cain");

		//print name
		System.out.println("First Name: " 
				+ name.getFirstName());
		System.out.println("Last Name: " 
				+ name.getLastName());
		System.out.println("Middle Name: " 
				+ name.getMiddleName());

	}
}
