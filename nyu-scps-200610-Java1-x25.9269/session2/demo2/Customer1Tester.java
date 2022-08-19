public class Customer1Tester
{
	/** The main method(automatically invoked by JVM) that 
	* creates a new Customer object and stores and 
	* retrieves field values.
	*/
	public static void main(String[] args)
	{
		// creates a new customer Object
		Customer1 customer11= new Customer1("Bill","K","Jones");

		//print name
		System.out.println("First Name: " 
				+ customer11.getFirstName());
		System.out.println("Last Name: " 
				+ customer11.getLastName());
		System.out.println("Middle Name: " 
				+ customer11.getMiddleName());

		//blank line
		System.out.println();
		
		// creates a new customer Object
		Customer1 customer12= new Customer1("James","E","Smith","123 River Street", "Hoboken","NJ","07030");

		//print name
		System.out.println("First Name: " 
				+ customer12.getFirstName());
		System.out.println("Last Name: " 
				+ customer12.getLastName());
		System.out.println("Middle Name: " 
				+ customer12.getMiddleName());
		
		//blank line
		System.out.println();
		
		//print address
		System.out.println("Street: " 
				+ customer12.getStreet());
		System.out.println("City: " 
				+ customer12.getCity());
		System.out.println("State: " 
				+ customer12.getState());
		System.out.println("Zip: " 
				+ customer12.getZip());
	}
}
