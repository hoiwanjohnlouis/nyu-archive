//  JAVA 1, HOMEWORK 4.1
//
//  HOI WAN JOHN LOUIS
//
//  1.  Create an enumeration called TaxBracket  that has:
//
//      Zero =0
//      Low=10
//      Medium=20
//      High = 30
//      Highest=40
//
//      TaxBracket should also have a public value() method
//      that will return the value like 10, 20, 30, 40.
//
public enum TaxBracket {
    Zero(0),
    Low(10),
    Medium(20),
    High(30),
    Highest(40);

    private int taxValue;

    // used to turn off tracing for this class
    private boolean DEBUG = false;

    /**
     * Class Contructor
     * @param int anyValue
     */
    TaxBracket(int anyValue) {
        this.taxValue = anyValue;
        Debugger( DEBUG, "\tIn Enum Contructor TaxBracket with anyValue parameter");
    }

    /**
     * The value method gets the taxValue
     * @return int this.taxValue
     */
    public int value() {
        return this.taxValue;
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
