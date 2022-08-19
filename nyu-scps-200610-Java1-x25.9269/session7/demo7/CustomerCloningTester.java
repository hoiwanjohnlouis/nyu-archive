public class CustomerCloningTester {

	public static void main(String[] args){

		// create a new name & customer object with name.
		Name name1 = new Name("John","A","Smith");

		//create a new Address object.
		Address address1 = new Address("24-14, 122 Street","College Point","NY","11356");

		Customer cust1= new Customer(name1, address1);

		// make a copy of customer 1
		Customer cust2 = (Customer) cust1.clone();

		System.out.println("Customer - Original");
		printCustomerInfo(cust1);

		System.out.println("Customer - Clone");
		printCustomerInfo(cust2);
		
		cust1.getName().setFirstName("Barbara");
		cust1.getAddress().setStreet("1038 Broadway, NY, NY 10034");

		System.out.println("Customer - Original Changed First Name and Street");
		printCustomerInfo(cust1);

		System.out.println("Customer - Clone Automatically Changed First Name and Street!!!!!!");
		printCustomerInfo(cust2);

	}
	public static void printCustomerInfo(Customer customer){
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
