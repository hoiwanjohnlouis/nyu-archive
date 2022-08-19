public class InsufficientBalanceException extends Exception{

	// serialVersionUID is required by JVM for serialization
	//whenever your class changes shape in a way that will be incompatible 
	//with previously serialized versions, simply increment this number. 
	public static final long serialVersionUID = 1;

	/** Field to store the withdrawal amount.*/
	private double amount;

	/** Field to store the current balance.*/
	private double balance;
	 
	/** Constructor that receives the the amount and current balance.
	* @param anyAmount Withdrawal Amount.
	* @param anyBalance Current Balance.
	*/
	InsufficientBalanceException (double anyAmount, double anyBalance){
		super("Insufficient balance, withdrawal amount: " + anyAmount +
			 	",balance: " + anyBalance);
		//store in private field.
		amount=anyAmount;
		balance=anyBalance;
	}

	//** getter for amount */
	public double getAmount() {
		return amount;
	}

	//** getter for balance */
	public double getBalance() {
		return balance;
	}
	public boolean equals(Object o){
		if (!(o instanceof InsufficientBalanceException)){
			return false;
		}
		InsufficientBalanceException e = (InsufficientBalanceException) o;
		if ((this.amount==e.amount)&& (this.balance==e.balance)){
			return true;
		}
		else{
			return false;
		}
	}

}
