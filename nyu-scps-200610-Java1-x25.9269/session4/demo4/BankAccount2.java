public abstract class BankAccount2
{ 
	/** Static final  integer field to hold the first account number. */
	// we still want to keep the value as our little secret - private.
	public static final int DEFAULT_INTEREST_RATE =4;	/** Double field to hold current interestRate. */

	private double interestRate;

	/** Static integer field to hold next account number. */
	private static int nextAccountNumber =1;

	/** Integer field to hold account number. */
	public final int  accountNumber;

	/** Double field to hold current balance. */
	private double balance; 

	/** A constructor that assigns an account number to a bank account. 
	*/
	public BankAccount2(){
		//sorry can't do System.out.println() here since this() call must be the first line.
		this(0);
		System.out.println("\tFinished BankAccount2() Constructor");
	}

	/** A constructor that assigns an account number and balance to a bank account. 
     * @param anyInitialBalance The initial balance
	*/
	public BankAccount2(double anyInitialBalance){
		System.out.println("\tIn BankAccount2(double anyInitialBalance) Constructor");
		if (anyInitialBalance <0){
			accountNumber= nextAccountNumber++;
			return;
		}
		else{
			accountNumber= nextAccountNumber++;
		}
		balance=anyInitialBalance;
		System.out.println("\tFinished BankAccount2(double anyInitialBalance) Constructor");
	}

	/** An abstract method that should calculate interest
	*/ 
	public abstract double calculateInterest();

	/** A method that makes a deposit to the bank account.
	* Accept deposit only if the deposit amount is > 0 
	* @param anyAmount The deposit amount.
	* @return success or failure as boolean.
	*/ 
	
	/** An overloaded method that sets default interest rate 
	* @return The Assigned interestRate.
	*/
	public double setInterestRate(){
		System.out.println("\tIn setInterestRate() of BankAccount2");
		setInterestRate(DEFAULT_INTEREST_RATE);
		return interestRate;
	}

	/** An overloaded method that sets interest rate 
	* @return Success or Failure.
	*/
	public boolean setInterestRate(double anyInterestRate){
		System.out.println("\tIn setInterestRate(double anyInterestRate) of BankAccount2");
		if (anyInterestRate>=0){
			interestRate=anyInterestRate;
			return true;
		}
		else{
			return false;
		}
	}
	
	/** A method that returns interest rate 
	* @return The Assigned interestRate.
	*/
	public double getInterestRate(){
		System.out.println("\tIn getInterestRate() of BankAccount2");
		return interestRate;
	}
	public boolean deposit(double anyAmount){
		System.out.println("\tIn deposit of BankAccount2");
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
		System.out.println("\tIn withdrawal of BankAccount2");
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
		System.out.println("\tIn getBalance of BankAccount2");
		return balance;
	}
}
