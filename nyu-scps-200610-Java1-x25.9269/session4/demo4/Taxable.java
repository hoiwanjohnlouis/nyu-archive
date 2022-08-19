public interface Taxable {

	/** A method that assigns tax rate.
	* @param anyTaxRate Tax Rate.
	* @return success/failure
	*/
	boolean setTaxRate(double anyTaxRate);

	/** A method that returns the assigned tax rate.
	* @return Tax Rate.
	*/
	double getTaxRate();

	/** A method that returns the tax amount.
	* @return Tax Amount.
	*/
	double calculateTax();
}
