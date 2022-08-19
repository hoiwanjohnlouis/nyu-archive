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
public class Appliance {
	
	public final String modelNumber;
	public final int    serialNumber;
	
	// hide the complex class Customer3
	private Customer3 owner;

	// hide the complex class Dimension
	private Dimension dimension;

	// keep track of number of instances
	private static int objectCount;
	private static int objectCountEven;
	private static int objectCountOdd;
	
	// let everyone share these two constants
	private static final int evenStartSerialNumber; 
	private static final int oddStartSerialNumber; 
	
	// use static constructor to init some vars
	static {
		System.out.println("static constructor starts");
		objectCount           = 0;
		objectCountEven       = 0;
		objectCountOdd        = 0;
		evenStartSerialNumber = 100; 
		oddStartSerialNumber  = 7453; 
		System.out.println("static constructor ends");
		System.out.println("----------------------------------");
	}
	
	/**
	 * @param modelNumber
	 */
	public Appliance(final String modelNumber) {
		this(modelNumber, null, null);
		System.out.println("appliance constructor one parm complete");
		System.out.println("----------------------------------");
	}
	/**
	 * @param modelNumber
	 * @param owner
	 */
	public Appliance(final String modelNumber, Customer3 owner) {
		this(modelNumber, owner, null);
		System.out.println("appliance constructor two parms complete");
		System.out.println("----------------------------------");
	}
	/**
	 * @param modelNumber
	 * @param owner
	 * @param dimension
	 */
	public Appliance(final String modelNumber, Customer3 owner, Dimension dimension) {
		super();

		System.out.println("appliance constructor three parms starts");
		this.modelNumber = modelNumber;
		setOwner(owner);
		setDimension(dimension);

		// conditionally set the starting serialNumber, using even or odd timestamp
		long timer = System.currentTimeMillis();
		System.out.print("timer " + timer + ": ");
		if	((timer % 2) == 0) {
			// increment even object count, used to offset serial number
			setObjectCountEven();
			// remember to subtract one from ohject count so we will use the initial serial number
			this.serialNumber = (evenStartSerialNumber + getObjectCountEven() - 1);
			System.out.println("using evenStartSerialNumber " + evenStartSerialNumber);
		}
		else {
			// increment odd object count, used to offset serial number
			setObjectCountOdd();
			// remember to subtract one from ohject count so we will use the initial serial number
			this.serialNumber = (oddStartSerialNumber + getObjectCountOdd() - 1);
			System.out.println("using oddStartSerialNumber " + oddStartSerialNumber);
		}
		System.out.println("this.serialNumber " + this.serialNumber);

		// increment total object count
		setObjectCount();
		System.out.println("appliance constructor three parms ends: Added Appliance Number: " + getObjectCount());
		System.out.println("----------------------------------");
	}

	// let the outside work know how many objects were created
	static int getNumberOfApplianceCreated() {
		// we could have just returned objectCount,
		// but use the getters instead
		// also load it into a local variable before returing
		int count = getObjectCount();
		return count;
	}
	/**
	 * @return the dimension
	 */
	public Dimension getDimension() {
		return dimension;
	}
	/**
	 * @param dimension the dimension to set
	 */
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}
	/**
	 * @return the owner
	 */
	public Customer3 getOwner() {
		return owner;
	}
	/**
	 * @param owner the owner to set
	 */
	public void setOwner(Customer3 owner) {
		this.owner = owner;
	}
	/**
	 * @return the objectCount
	 */
	public static int getObjectCount() {
		return objectCount;
	}
	/**
	 * @param objectCount the objectCount to set
	 */
	public static void setObjectCount() {
		Appliance.objectCount++;
	}
	/**
	 * @return the objectCountEven
	 */
	public static int getObjectCountEven() {
		return objectCountEven;
	}
	/**
	 * @param objectCountEven the objectCountEven to set
	 */
	public static void setObjectCountEven() {
		Appliance.objectCountEven++;
	}
	/**
	 * @return the objectCountOdd
	 */
	public static int getObjectCountOdd() {
		return objectCountOdd;
	}
	/**
	 * @param objectCountOdd the objectCountOdd to set
	 */
	public static void setObjectCountOdd() {
		Appliance.objectCountOdd++;
	}

}
