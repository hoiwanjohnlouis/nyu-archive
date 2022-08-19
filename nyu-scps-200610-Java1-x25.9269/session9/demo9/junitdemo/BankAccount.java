public class BankAccount
{ 
	/** Static integer field to hold next account number. */
	private static int nextAccountNumber =1;

	/** Integer field to hold account number. */
	public final int  accountNumber;

	/** Double field to hold current balance. */
	private double balance; 

	/** A constructor that assigns an account number to a bank account. 
	*/
	public BankAccount(){
		this(0);
	}

	/** A constructor that assigns an account number and balance to a bank account. 
     * @param anyInitialBalance The initial balance
	*/
	public BankAccount(double anyInitialBalance){
		if (anyInitialBalance <0){
			accountNumber= nextAccountNumber++;
			return;
		}
		else{
			accountNumber= nextAccountNumber++;
		}
		balance=anyInitialBalance;
	}


	/** A method that makes a deposit to the bank account.
	* Accept deposit only if the deposit amount is > 0 
	* @param anyAmount The deposit amount.
	* @return success or failure as boolean.
	*/ 
	public boolean deposit(double anyAmount){
		if (anyAmount>0){
			balance += anyAmount;
			return true;
		}
		else{
			return false;
		}
	}

	/** A method that makes a withdrawal to the bank account.
	* Accept the withdrawal only if the amount is > 0 and <= balance 
	* @param anyAmount The withdrawal amount.
	* @return success or failure as boolean.
	*/ 
	public boolean withdrawal(double anyAmount){
		if ((anyAmount>0) && (anyAmount <= balance)){
			balance -= anyAmount;
			return true;
		}
		else{
			return false;
		}
	}

	/** method that returns account balance.
	* @return The account balance.
	*/	
	public double getBalance(){
		return balance;
	}
}
