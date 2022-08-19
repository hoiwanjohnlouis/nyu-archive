public class BankAccount9
{ 
	/** Static integer field to hold next account number. */
	private static int nextAccountNumber =1;

	/** Integer field to hold account number. */
	private int accountNumber;

	/** Double field to hold current balance. */
	private double balance; 

	/** Double field to hold current interestRate. */
	private double interestRate;


	/** A method that returns number of accounts opened 
	* @return The number of accounts opened.
	*/
	public static int getNumberOfAccountsOpened(){
		System.out.println("\tIn getNumberOfAccountsOpened");
		return nextAccountNumber -1 ;
	}

	/** A constructor that assigns an account number to a bank account. 
	*/
	public BankAccount9(){
		//sorry can't do System.out.println() here since this() call must be the first line.
		this(0);
	}

	/** A constructor that assigns an account number and balance to a bank account. 
     * @param anyInitialBalance The initial balance
	*/
	public BankAccount9(double anyInitialBalance){
		System.out.println("\tIn BankAccount9(double anyInitialBalance) Constructor");
		System.out.println("\tInitially Next Account Number: " + nextAccountNumber);
		System.out.println("\tInitially Account Number: " + accountNumber);
		System.out.println("\tInitially Balance: " + balance);
		if (anyInitialBalance <0){
			System.out.println("\tValue of anyInitialBalance parameter is < 0");
			return;
		}
		else{
			System.out.println("\tValue of anyInitialBalance parameter is NOT <= 0");

		}
		accountNumber= nextAccountNumber++;
		balance=anyInitialBalance;
		System.out.println("\tNext Account Number at the end of Constructor call is : " + nextAccountNumber);
		System.out.println("\tAccount Number at the end of Constructor call is : " + accountNumber);
		System.out.println("\tBalance at the end of Constructor call is : " + balance);
	}

	/** An overloaded method that sets default interest rate 
	* @return The Assigned interestRate.
	*/
	public double setInterestRate(){
		System.out.println("\tIn setInterestRate()");
		setInterestRate(4);
		return interestRate;
	}

	/** An overloaded method that sets interest rate 
	* @return Success or Failure.
	*/
	public boolean setInterestRate(double anyInterestRate){
		System.out.println("\tIn setInterestRate(double anyInterestRate)");
		if (anyInterestRate>=0){
			System.out.println("\tThe anyInterestRate parameter is >= 0");
			interestRate=anyInterestRate;
			return true;
		}
		else{
			System.out.println("\tThe anyInterestRate parameter is NOT >= 0");
			return false;
		}
	}
	
	/** A method that returns interest rate 
	* @return The Assigned interestRate.
	*/
	public double getInterestRate(){
		System.out.println("\tIn getInterestRate()");
		return interestRate;
	}

	/** A method that returns account number 
	* @return The Assigned account number.
	*/
	public int getAccountNumber(){
		System.out.println("\tIn getAccountNumber");
		return accountNumber;
	}

	/** A method that makes a deposit to the bank account.
	* Accept deposit only if the deposit amount is > 0 
	* @param anyAmount The deposit amount.
	* @return success or failure as boolean.
	*/ 
	public boolean deposit(double anyAmount){
		System.out.println("\tIn deposit");
		if (anyAmount>0){
			System.out.println("\tThe deposit amount is > 0");
			balance += anyAmount;
			return true;
		}
		else{
			System.out.println("\tThe deposit amount is NOT > 0");
			return false;
		}
	}

	/** A method that makes a withdrawal to the bank account.
	* Accept the withdrawal only if the amount is > 0 and <= balance 
	* @param anyAmount The withdrawal amount.
	* @return success or failure as boolean.
	*/ 
	public boolean withdrawal(double anyAmount){
		System.out.println("\tIn withdrawal");
		if ((anyAmount>0) && (anyAmount <= balance)){
			System.out.println("\tThe withdrawal amount is > 0 and < balance");
			balance -= anyAmount;
			return true;
		}
		else{
			System.out.println("\tThe withdrawal amount is NOT > 0 and < balance");
			return false;
		}
	}

	/** method that returns account balance.
	* @return The account balance.
	*/	
	public double getBalance(){
		System.out.println("\tIn getBalance");
		return balance;
	}
}
