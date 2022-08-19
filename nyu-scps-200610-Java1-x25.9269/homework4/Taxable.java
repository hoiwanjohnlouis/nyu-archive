//  JAVA 1, HOMEWORK 4.2
//
//  HOI WAN JOHN LOUIS
//
//  2.  Create an interface called Taxable that has a
//      getTaxRate() method that returns TaxBracket
//      and a calculateTax() method that returns double.
//
public interface Taxable {
    TaxBracket getTaxRate();
    double     calculateTax();
}
