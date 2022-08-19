//  JAVA 1, HOMEWORK 4.4
//
//  HOI WAN JOHN LOUIS
//
//  4.  Create an abstract class called Person that is sub-class of Party.
//      Person has the following additional private fields:
//      1. Name name – with getter and setter (Name from Session2)
//      2. String nickname – with getter and setter
//      3. int income – with getter and setter
//      4. TaxBracket taxRate – we already have the getter getTaxRate()
//         from Taxable interface and also anther method called calculateTax().
//         Both of these methods will be actually implemented here, in this class
//
//      Person should have 3 constructors:
//
//          1.  First one takes no arguments
//          2.  Second one takes Name as arguments.
//          3.  Third one takes Name and Address as arguments.
//
//      Notice Person does not have any constructor that takes on Address like
//          Party does.  Also notice, Person has no abstract method yet the
//          class is declared abstract since we don’t want anybody to create
//          object from Person – which is perfectly legal in Java.
//
//      Rule:
//
//          a.  You may notice there is no setTaxRate() method to implement but
//              there is a private field called taxRate and getTaxRate() to
//              return tax rate and calculateTax method to calculate tax.
//              The question is how does the taxRate field get initialized?
//              It will be initialized in setIncome() method by the following rule:
//
//                  if income<30,000 then TaxRate is Low.
//                  if income>=30,000 and <60,000 then TaxRate is Medium.
//                  if income>=60,000 and <100,000  then TaxRate is High.
//                  if income>=100,000  then TaxRate is Highest.
//
//          b.  calculateTax() method should use income and taxRate to compute tax.
//              By the way, if a person’s taxRate is High (40%) and his income is $80,000
//              his tax is NOT $3,200,000 – if you are planning on paying that kind of tax,
//              please contact me and I will do your taxes.
//
//  Abstract classes can’t be instantiated. Therefore, I can’t really give you a tester for this.
//
public abstract class Person extends Party {

    private Name        name;
    private String      nickName;
    private int         income;
    private TaxBracket  taxRate;

    // used to turn off tracing for this class
    private boolean DEBUG = false;

    /**
     * Class Contructor
     */
    public Person () {
        this(null);
        Debugger( DEBUG, "\tLeaving Default Person Constructor");
    }
    /**
     * Class Contructor
     * @param Name anyName
     */
    public Person (Name anyName) {
        this(anyName,null);
        Debugger( DEBUG, "\tLeaving Person Constructor with Name parameter");
    }
    /**
     * Class Contructor
     * @param Name anyName
     * @param Address anyAddress
     */
    public Person (Name anyName, Address anyAddress) {
        // set address in inherited Party class
        super(anyAddress);
        this.name = anyName;
        setIncome(0);
        
        Debugger( DEBUG, "\tLeaving Person Constructor with Name & Address parameters");
    }

    /**
     * implement getTaxRate for Taxable Class
     */
    public TaxBracket getTaxRate() {
        return taxRate;
    }

    /**
     * implement calculateTax for Taxable Class
     */
    public double     calculateTax() {
        /**
         * TaxRate is in whole numbers, we need the decimal rate.  eg 40% is really 0.40
         */
        double myTaxRate = 0.0;
        double returnTax = 0;

        myTaxRate = getTaxRate().value();
        myTaxRate = (myTaxRate / 100.0);

        returnTax = (income * myTaxRate);
        return returnTax;
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
    protected void setName(Name name) {
        this.name = name;
    }
    /**
     * @return the nickName
     */
    public String getNickName() {
        return nickName;
    }
    /**
     * @param nickName the nickName to set
     */
    protected void setNickName(String nickName) {
        this.nickName = nickName;
    }
    /**
     * @return the income
     */
    public int getIncome() {
        return income;
    }
    /**
     * @param income the income to set
     */
    protected void setIncome(int anyIncome) {
        this.income = anyIncome;

        /**
         * what's my taxRate?  use Mohammed's algorithm above
         */
        if  (this.income >=100000) {
            taxRate = TaxBracket.Highest;
        }
        else {
            if  ((this.income >= 60000) & (this.income < 100000)) {
                taxRate = TaxBracket.High;
            }
            else {
                if  ((this.income >= 30000) & (this.income < 60000)) {
                    taxRate = TaxBracket.Medium;
                }
                else {
                    if  (this.income < 30000) {
                        taxRate = TaxBracket.Low;
                    }
                    else {
                        Debugger( DEBUG, "\tIncorrect Income:" + this.income);
                    }
                }
            }
        }
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
