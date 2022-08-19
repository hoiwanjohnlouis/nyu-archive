public class Customer2Tester
{
	/** The main method(automatically invoked by JVM) that 
	* creates a new Customer object and stores and 
	* retrieves field values.
	*/
	public static void main(String[] args)
	{
		// creates a new customer Object using name
		Name name1 = new Name("Jay","T","Miller");
		Customer2 customer21= new Customer2(name1);

		//print name
		System.out.println("First Name: " 
				+ customer21.getName().getFirstName());
		System.out.println("Last Name: " 
				+ customer21.getName().getLastName());
		System.out.println("Middle Name: " 
				+ customer21.getName().getMiddleName());

		//blank line
		System.out.println();
		
		// creates a new customer Object using name and address
		Name name2 = new Name("Barbara","G","Scott");
		Customer2 customer22= new Customer2(name2,"123 River Street", "Hoboken","NJ","07030");

		//print name
		System.out.println("First Name: " 
				+ customer22.getName().getFirstName());
		System.out.println("Last Name: " 
				+ customer22.getName().getLastName());
		System.out.println("Middle Name: " 
				+ customer22.getName().getMiddleName());
		
		//blank line
		System.out.println();
		
		//print address
		System.out.println("Street: " 
				+ customer22.getStreet());
		System.out.println("City: " 
				+ customer22.getCity());
		System.out.println("State: " 
				+ customer22.getState());
		System.out.println("Zip: " 
				+ customer22.getZip());
	}
}
