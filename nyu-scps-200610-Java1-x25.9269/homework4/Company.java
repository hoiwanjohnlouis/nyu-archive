//  JAVA 1, HOMEWORK 4.6
//
//  HOI WAN JOHN LOUIS
//
//  6.  Create a class called Company that is sub-class of Party.
//      Company is not abstract at all. Company has the following
//      additional private fields:
//
//      String legalName – with getter and setter
//      String[] tradeNames – with getter and setter
//      Person ceo – with getter and setter
//      double profit – with getter and setter
//      TaxBracket taxRate - we already have the getter getTaxRate()
//                           from Taxable interface and also anther
//                           method called calculateTax(). Both of
//                           these methods will be actually implemented here.
//
//      Company should have 3 constructors:
//
//      1.  First one takes no arguments
//      2.  Second one takes Name as arguments.
//      3.  Third one takes Name and Address as arguments.
//
//      Rule:
//
//      a.  You may notice there is no setTaxRate() method to implement but
//          there is a private field called taxRate and getTaxRate() to
//          return tax rate. The question is how does the taxRate field
//          gets initialized? It will be initialized in setProfit() method
//          by the following rule:
//
//              If profit<0 then TaxRate is Zero.
//              If profit<60000 then TaxRate is Medium.
//              if profit >=60000 and <100000  then TaxRate is High.
//              if profit >=100000  then TaxRate is Highest.
//
//
//      The company tester class below is incomplete. Here is what you have to do:
//
//      a)  For each company, you have to populate ceo’s name, employee type and income
//      b)  Write a polymorphic, private, static void method showTaxInfo that
//          will accept Taxable, yes Taxable, yes, I know Taxable is an
//          interface name – still Taxable and print taxRate (both in
//          word and number) and calculated tax.
//
//
public class Company extends Party {
    String      legalName;
    String[]    tradeNames;
    Person      ceo;
    double      profit;
    TaxBracket  taxRate;

    // used to turn off tracing for this class
    private boolean DEBUG = false;

    /**
     * Default Company Constructor
     */
    public Company() {
        this(null);
        Debugger( DEBUG, "\tLeaving Default Company Constructor");
    }
    /**
     * Company Constructor with String anyName as parm
     * @param String anyName
     */
    public Company(String anyName) {
        this(anyName, null);
        Debugger( DEBUG, "\tLeaving Company Constructor with String anyName");
    }
    /**
     * Company Constructor with String anyName as parm
     * @param String anyName
     * @param Address anyAddress
     */
    public Company(String anyName, Address anyAddress) {
    	// use Party's constructor to set address
        super(anyAddress);
        // set instance vars
        setLegalName(anyName);
        // need to instance a new copy of Employee,
        // since we cannot do it directly for abstract Person 
//        Employee e1 = new Employee();
//        e1.setNickName(anyName);
//        e1.setLegalAddress(anyAddress);
//        e1.setEmpType(EmployeeType.FullTime);
//        ceo = e1;
        Debugger( DEBUG, "\tLeaving Company Constructor with String anyName, Address anyAddress");
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

        returnTax = (profit * myTaxRate);
        return returnTax;
    }

    /**
     * @return the ceo
     */
    public Person getCeo() {
        return ceo;
    }
    /**
     * @param ceo the ceo to set
     */
    public void setCeo(Person ceo) {
        this.ceo = ceo;
    }
    /**
     * @return the legalName
     */
    public String getLegalName() {
        return legalName;
    }
    /**
     * @param legalName the legalName to set
     */
    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }
    /**
     * @return the profit
     */
    public double getProfit() {
        return profit;
    }
    /**
     * @param profit the profit to set
     */
    public void setProfit(double profit) {
        this.profit = profit;

        /**
         * what's my taxRate?  use Mohammed's algorithm above
         */
        if  (this.profit < 0) {
            taxRate = TaxBracket.Zero;
        }
        else {
            if  (this.profit < 60000) {
                taxRate = TaxBracket.Medium;
            }
            else {
                if  ((this.profit >= 60000) & (this.profit < 100000)) {
                    taxRate = TaxBracket.High;
                }
                else {
                    if  (this.profit >=100000) {
                        taxRate = TaxBracket.Highest;
                    }
                    else {
                        Debugger( DEBUG, "\tIncorrect Income:" + this.profit);
                    }
                }
            }
        }
    }
    /**
     * @return the tradeNames
     */
    public String[] getTradeNames() {
        return tradeNames;
    }
    /**
     * @param tradeNames the tradeNames to set
     */
    public void setTradeNames(String[] tradeNames) {
        this.tradeNames = tradeNames;
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
