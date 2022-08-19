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
		//sorry can't do System.out.println() here since this() call must be the first line.
		this(0);
		System.out.println("\tFinished BankAccount() Constructor");
	}

	/** A constructor that assigns an account number and balance to a bank account. 
     * @param anyInitialBalance The initial balance
	*/
	public BankAccount(double anyInitialBalance){
		System.out.println("\tIn BankAccount(double anyInitialBalance) Constructor");
		if (anyInitialBalance <0){
			accountNumber= nextAccountNumber++;
			return;
		}
		else{
			accountNumber= nextAccountNumber++;
		}
		balance=anyInitialBalance;
		System.out.println("\tFinished BankAccount(double anyInitialBalance) Constructor");
	}


	/** A method that makes a deposit to the bank account.
	* Accept deposit only if the deposit amount is > 0 
	* @param anyAmount The deposit amount.
	* @return success or failure as boolean.
	*/ 
	public boolean deposit(double anyAmount){
		System.out.println("\tIn deposit of BankAccount");
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
		System.out.println("\tIn withdrawal of BankAccount");
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
		System.out.println("\tIn getBalance of BankAccount");
		return balance;
	}
}
