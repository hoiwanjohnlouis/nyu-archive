//	JAVA 1, HOMEWORK 2b
//
//  HOI WAN JOHN LOUIS
//
//	b)	Create a class called Appliance that has the following:
//		1)	One String type field called modelNumber that can not be modified after initialization and it is visible to outside world.
//		2)	One int tyle field called serailNumber that can not be modified after initialization and it is visible to outside world.
//		3)	One Customer3 type field called owner that is NOT visible to the outside world without using Getter and Setter.
//		4)	One Dimension  type field called dimension that is NOT visible to the outside world without using Getter and Setter.
//		5)	Three public constructors – the first one only takes model number, the second one takes model number and owner and the third one takes model number, owner and dimension.
//		6)	Public Getters and Setters for four fields.
//		7)	A method getNumberOfApplianceCreated() that will return object count.
//
//	Rules:
//
//		a)	Serial number should be automatically assigned by all three consturctors by incrementing a number by one.
//		b)	If the current time in millisecond is even, the starting serial number should be 100. If odd, the starting serial number is 7453. You should use System.currentTimeMillis() function for the current time in millisecond. Use constant to store starting serial number.
//		c)	Constructors should not repeat the same code. They should call one another for execution of the same code.
//
//
//	Here is a sample tester output:
//
//	Serial Number: 100
//	Model: MG101
//
//
//	Serial Number: 101
//	Model: BR102
//
//	First Name: Sarah
//	Last Name: King
//	Middle Name: N
//
//	Street: 22-28 125 Street
//	City: Flushing
//	State: NY
//	Zip: 11342
//
//
//	Serial Number: 102
//	Model: PT103
//
//	First Name: Jay
//	Last Name: Miller
//	Middle Name: T
//
//	Street: 1234 Broadway
//	City: New York
//	State: NY
//	Zip: 10045
//
//	Length: 10.3
//	Height: 12.4
//	Width: 11.5
//
//	Number of Appliances Created: 3
//
//
public class ApplianceTester {

	public static void main(String[] args) {

		Appliance a1 = new Appliance("MG101");
		System.out.println("Serial Number: " + a1.serialNumber);
		System.out.println("Model: " + a1.modelNumber);
		System.out.println();
		System.out.println();
		
		// creates a new customer Object using name and address
		Name name1 = new Name("Sarah","N","King");
		Address address1 =  new Address("22-28 125 Street", "Flushing","NY","11342");
		Customer3 customer31 = new Customer3(name1,address1);
		Appliance a2 = new Appliance("BR102",customer31);

		System.out.println("Serial Number: " + a2.serialNumber);
		System.out.println("Model: " + a2.modelNumber);
		System.out.println();

		//print name
		System.out.println("First Name: " 
				+ a2.getOwner().getName().getFirstName());
		System.out.println("Last Name: " 
				+ a2.getOwner().getName().getLastName());
		System.out.println("Middle Name: " 
				+ a2.getOwner().getName().getMiddleName());
		System.out.println();

		//print address
		System.out.println("Street: " 
				+ a2.getOwner().getAddress().getStreet());
		System.out.println("City: " 
				+ a2.getOwner().getAddress().getCity());
		System.out.println("State: " 
				+ a2.getOwner().getAddress().getState());
		System.out.println("Zip: " 
				+ a2.getOwner().getAddress().getZip());
		System.out.println();
		System.out.println();

		// creates a new customer Object using name
		Name name2 = new Name("Jay","T","Miller");
		// creates a new  address
		Address address2= new Address("1234 Broadway", "New York","NY","10045");
		Customer3 customer32= new Customer3(name2,address2);
		Dimension dimension = new Dimension(10.3,12.4,11.5);
		Appliance a3 = new Appliance("PT103",customer32,dimension);

		System.out.println("Serial Number: " + a3.serialNumber);
		System.out.println("Model: " + a3.modelNumber);
		System.out.println();

		//print name
		System.out.println("First Name: " 
				+ a3.getOwner().getName().getFirstName());
		System.out.println("Last Name: " 
				+ a3.getOwner().getName().getLastName());
		System.out.println("Middle Name: " 
				+ a3.getOwner().getName().getMiddleName());
		System.out.println();

		//print address
		System.out.println("Street: " 
				+ a3.getOwner().getAddress().getStreet());
		System.out.println("City: " 
				+ a3.getOwner().getAddress().getCity());
		System.out.println("State: " 
				+ a3.getOwner().getAddress().getState());
		System.out.println("Zip: " 
				+ a3.getOwner().getAddress().getZip());
		System.out.println();

		//print dimension
		System.out.println("Length: " 
				+ a3.getDimension().getLength());
		System.out.println("Height: " 
				+ a3.getDimension().getHeight());
		System.out.println("Width: " 
				+ a3.getDimension().getWidth());
		System.out.println();
		
		//print object count
		System.out.println("Number of Appliances Created: " + Appliance.getNumberOfApplianceCreated());
	}

}

