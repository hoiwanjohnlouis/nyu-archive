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
public class Customer3{
	// private fields to hold customer information.
	private Name    name;
	private Address address;


	/**
	 * @param name
	 * @param address
	 */
	public Customer3(Name name, Address address) {
		super();
		this.name = name;
		this.address = address;
	}
	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	/**
	 * @return the name
	 */
	public Name getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(Name name) {
		this.name = name;
	}
}