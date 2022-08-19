public class AddressTester
{
	/** The main method(automatically invoked by JVM) that 
	* creates a new Address object and stores and 
	* retrieves field values.
	*/
	public static void main(String[] args)
	{

		// creates a new  address
		Address address= new Address("1234 Broadway", "New York","NY","10045");

		//print address
		System.out.println("Street: " 
				+ address.getStreet());
		System.out.println("City: " 
				+ address.getCity());
		System.out.println("State: " 
				+ address.getState());
		System.out.println("Zip: " 
				+ address.getZip());
	}
}
