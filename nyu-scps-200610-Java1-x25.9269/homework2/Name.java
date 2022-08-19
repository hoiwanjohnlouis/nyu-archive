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
public class Name {
	//field to store name attributes
	private String firstName;
	private String middleName;
	private String lastName;



	/**
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 */
	public Name(String firstName, String middleName, String lastName) {
		super();
		setFirstName(firstName);
		setMiddleName(middleName);
		setLastName(lastName);
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}
	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
}
