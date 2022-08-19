// this class does not compile
public class BankAccount1{ 
	/** Static integer field to hold next account number. */
	private static int nextAccountNumber =1;

	/** Integer field to hold account number. */
	public final int  accountNumber;

	/** Double field to hold current balance. */
	private double balance; 

	/** A constructor that assigns an account number to a bank account. 
	*/
	public BankAccount1(){
		this(0);
	}

	/** A constructor that assigns an account number and balance to a bank account. 
     * @param anyInitialBalance The initial balance
     * @exception Exception When the deposit amount is negative
	*/
	public BankAccount1(double anyInitialBalance){
		if (anyInitialBalance <0){
			throw new Exception("Deposit Amount can not be negative");
		}
		accountNumber= nextAccountNumber++;
		balance=anyInitialBalance;
	}

	/** A method that makes a deposit to the bank account.
	* Accept deposit only if the deposit amount is > 0 
	* @param anyAmount The deposit amount.
     * @exception Exception When the deposit amount is negative
	*/ 
	public void deposit(double anyAmount){
		if (anyAmount <0){
			throw new Exception("Deposit Amount can not be negative");
		}
		balance += anyAmount;
	}

	/** A method that makes a withdrawal to the bank account.
	* Accept the withdrawal only if the amount is > 0 and <= balance 
	* @param anyAmount The withdrawal amount.
     * @exception Exception When the withdrawal amount is negative or not enough balance
	*/ 
	public void withdrawal(double anyAmount){
		if (anyAmount <0){
			throw new Exception("Withdrawal Amount can not be negative");
		}
		if (anyAmount>balance){
			throw new Exception("Insufficient balance");
		}
		balance -= anyAmount;
	}

	/** method that returns account balance.
	* @return The account balance.
	*/	
	public double getBalance(){
		return balance;
	}
}
