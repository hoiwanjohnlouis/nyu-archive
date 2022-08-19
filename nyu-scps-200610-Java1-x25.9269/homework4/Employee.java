//  JAVA 1, HOMEWORK 4.5
//
//  HOI WAN JOHN LOUIS
//
//  5.  Create a class called Employee that is sub-class of Person.
//      Employee is not abstract at all.
//      Employee has the following additional private field:
//
//      EmployeeType empType – with getter and setter.
//
//      EmployeeType is an enum with the following two values :
//          FullTime, PartTime where FullTime is 0 and PartTime is 1.
//
public class Employee extends Person {
    private EmployeeType empType;

    // used to turn off tracing for this class
    private boolean DEBUG = false;

    /**
     * Class Contructor
     */
    public Employee () {
        this(null);
        Debugger( DEBUG, "\tLeaving Default Employee Constructor");
    }
    /**
     * Class Contructor
     * @param Name anyName
     */
    public Employee (Name anyName) {
        this(anyName,null);
        Debugger( DEBUG, "\tLeaving Employee Constructor with Name parameter");
    }
    /**
     * Class Contructor
     * @param Name anyName
     * @param Address anyAddress
     */
    public Employee (Name anyName, Address anyAddress) {
    	super(anyName, anyAddress);
        Debugger( DEBUG, "\tLeaving Employee Constructor with Name & Address parameters");
    }
    /**
     * @return the empType
     */
    public EmployeeType getEmpType() {
        return empType;
    }
    /**
     * @param empType the empType to set
     */
    public void setEmpType(EmployeeType empType) {
        this.empType = empType;
    }

    /**
     * Centralized debugger logger to default output
     */
    public static void Debugger (boolean DEBUG, String msg) {
        if  (DEBUG) {
            System.out.println(msg);
        }
    }

}

