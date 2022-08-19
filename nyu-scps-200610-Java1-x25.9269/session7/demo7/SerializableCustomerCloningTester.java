public class SerializableCustomerCloningTester {

	public static void main(String[] args){

		// create a new name & customer object with name.
		SerializableName name1 = new SerializableName("John","A","Smith");

		//create a new Address object.
		SerializableAddress address1 = new SerializableAddress("24-14, 122 Street","College Point","NY","11356");

		SerializableCustomer cust1= new SerializableCustomer(name1, address1);

		// make a copy of customer 1
		SerializableCustomer cust2 = (SerializableCustomer) cust1.clone();

		System.out.println("SerializableCustomer - Original");
		printSerializableCustomerInfo(cust1);

		System.out.println("SerializableCustomer - Clone");
		printSerializableCustomerInfo(cust2);
		
		cust1.getName().setFirstName("Barbara");
		cust1.getAddress().setStreet("1038 Broadway, NY, NY 10034");

		System.out.println("SerializableCustomer - Original Changed First Name and Street");
		printSerializableCustomerInfo(cust1);

		System.out.println("SerializableCustomer - Clone First Name and Street DID NOT CHANGE!!!!!!");
		printSerializableCustomerInfo(cust2);

	}
	public static void printSerializableCustomerInfo(SerializableCustomer customer){
		System.out.println("First Name: " + customer.getName().getFirstName());
		System.out.println("Middle Name: " + customer.getName().getMiddleName());
		System.out.println("Last Name: " + customer.getName().getLastName());
		System.out.println("Street: " + customer.getAddress().getStreet());
		System.out.println("City: " + customer.getAddress().getCity());
		System.out.println("State: " + customer.getAddress().getState());
		System.out.println("Zip: " + customer.getAddress().getZip());
		System.out.println();

	}
}
