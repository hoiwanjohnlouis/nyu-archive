//  JAVA 1, HOMEWORK 4.3
//
//  HOI WAN JOHN LOUIS
//
//  3.  Create an abstract class called Party that
//      implements Taxable interface but does not
//      know how to implement getTaxRate() or calculateTax()
//      since the tax rate and tax calculation would be
//      different of each sub-class of Pary � therefore,
//      should be abstract. Party is an abstract class
//      that can represent a person or company in sub-classes
//      as you will see shortly.
//
//      Party should have the following fields:
//
//      a)  int id � that is �write-once� and public.
//          Id would contain a sequential number
//          generated by a sequential number field
//          starting at 1 (you know this stuff from session 2, I hope).
//      b)  Address legalAddress � that is private and
//          has getter and setter (Address from Session2)
//
//      Party should have two constructors:
//          a)  First one takes no arguments
//          b)  Second one takes Address as arguments.
//
public abstract class Party implements Taxable {
    public final int    id;
    private Address     legalAddress;

    // keep track of number of instances
    // useful to take care of setting method variable id.
    private static int objectCount = 0;

    // used to turn off tracing for this class
    private boolean DEBUG = false;

    /**
     * Class Contructor
     */
    public Party () {
        this(null);
        Debugger( DEBUG, "\tLeaving Default Party Constructor");
    }
    /**
     * Class Contructor
     * @param Address anyAddress
     */
    public Party (Address anyAddress) {
        // set the next objectCount for id.
        setObjectCount();
        // satisfy homework requirement 4.3.a
        id = getObjectCount();
        //
        setLegalAddress(anyAddress);
        Debugger( DEBUG, "\tLeaving Party Contructor with Address parameter");
    }

    /**
     * The getLegalAddress method gets the Address
     * @return the legalAddress
     */
    public Address getLegalAddress() {
        return legalAddress;
    }
    /**
     * The setLegalAddress method sets the Address
     * @param Address legalAddress
     */
    public void setLegalAddress(Address legalAddress) {
        this.legalAddress = legalAddress;
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
        Party.objectCount++;
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
