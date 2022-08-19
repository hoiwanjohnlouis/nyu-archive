public class CheckingAccount5 extends CheckingAccount4 implements Taxable
{
	private double taxRate;
	
	//constructor
	public CheckingAccount5(){
		super();
		System.out.println("\tFinished CheckingAccount5() Constructor");
	}

	//constructor
	public CheckingAccount5(double initialDeposit){
		super(initialDeposit);
		System.out.println("\tFinished CheckingAccount5(double initialDeposit) Constructor");
	}

	/** A method that assigns tax rate.
	* @param anyTaxRate Tax Rate.
	* @return success/failure
	*/
	public boolean setTaxRate(double anyTaxRate){
		if (anyTaxRate>=0){
			taxRate = anyTaxRate;
			return true;
		}
		else{
			return false;
		}
	}

	/** A method that returns the assigned tax rate.
	* @return Tax Rate.
	*/
	public double getTaxRate(){
		return taxRate;
	}

	/** A method that returns the tax amount.
	* @return Tax Amount.
	*/
	public double calculateTax(){
		double tax = calculateInterest()*taxRate/100;
		return tax;
	}

}
