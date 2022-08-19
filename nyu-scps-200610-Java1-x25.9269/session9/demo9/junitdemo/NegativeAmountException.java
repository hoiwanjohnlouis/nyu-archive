public class NegativeAmountException extends Exception{

	// serialVersionUID is required by JVM for serialization
	//whenever your class changes shape in a way that will be incompatible 
	//with previously serialized versions, simply increment this number. 
	public static final long serialVersionUID = 1;

	/** Field to store the negative amount.*/
	private double amount;
	
	/** Constructor that receives the negative amount.
	* @param anyAmount The negative amount.
	*/
	NegativeAmountException(double anyAmount){
		super("Negative amount " + anyAmount);
		amount=anyAmount;
	}

	/** getter for amount.*/
	public double getAmount() {
		return amount;
	}
	public boolean equals(Object o){
		if (!(o instanceof NegativeAmountException)){
			return false;
		}
		NegativeAmountException e = (NegativeAmountException) o;
		if (this.amount==e.amount){
			return true;
		}
		else{
			return false;
		}
	}
}
