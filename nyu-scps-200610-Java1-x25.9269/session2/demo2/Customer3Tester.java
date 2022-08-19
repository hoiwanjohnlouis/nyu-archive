public class Customer3Tester
{
	/** The main method(automatically invoked by JVM) that 
	* creates a new Customer object and stores and 
	* retrieves field values.
	*/
	public static void main(String[] args)
	{
		// creates a new customer Object using name and address
		Name name = new Name("Sarah","N","King");
		Address address =  new Address("22-28 125 Street", "Flushing","NY","11342");
		
		Customer3 customer3 = new Customer3(name,address);
		
		//print name
		System.out.println("First Name: " 
				+ customer3.getName().getFirstName());
		System.out.println("Last Name: " 
				+ customer3.getName().getLastName());
		System.out.println("Middle Name: " 
				+ customer3.getName().getMiddleName());
		
		//blank line
		System.out.println();
		
		//print address
		System.out.println("Street: " 
				+ customer3.getAddress().getStreet());
		System.out.println("City: " 
				+ customer3.getAddress().getCity());
		System.out.println("State: " 
				+ customer3.getAddress().getState());
		System.out.println("Zip: " 
				+ customer3.getAddress().getZip());
	}
}
