public class BankAccount6
{ 
	/** Integer field to hold account number. */
	private int accountNumber;

	/** Double field to hold current balance. */
	private double balance; 

	/** Double field to hold current interestRate. */
	private double interestRate;

	/** A constructor that assigns an account number to a bank account. 
     * @param anyAccountNumber The new account number
	*/
	public BankAccount6(int anyAccountNumber){
		System.out.println("\tIn BankAccount6(int anyAccountNumber) Constructor");
		System.out.println("\tInitially Account Number : " + accountNumber);
		if (anyAccountNumber <=0){
			System.out.println("\tValue of anyAccountNumber parameter is <= 0");
			return;
		}
		else{
			System.out.println("\tValue of anyAccountNumber parameter is NOT <= 0");

		}
		// no need to check the value of accountNumber field, of course it is zero
		// since we are in the middle of constructing it.
		accountNumber= anyAccountNumber;
		balance=0;
		System.out.println("\tAccount Number at the end of Constructor call is : " + accountNumber);
	}

	/** A constructor that assigns an account number and balance to a bank account. 
     * @param anyAccountNumber The new account number
     * @param anyInitialBalance The initial balance
	*/
	public BankAccount6(int anyAccountNumber, double anyInitialBalance){
		System.out.println("\tIn BankAccount6(int anyAccountNumber, double anyInitialBalance) Constructor");
		System.out.println("\tInitially Account Number: " + accountNumber);
		System.out.println("\tInitially Balance: " + balance);
		if (anyAccountNumber <=0){
			System.out.println("\tValue of anyAccountNumber parameter is <= 0");
			return;
		}
		else{
			System.out.println("\tValue of anyAccountNumber parameter is NOT <= 0");

		}
		if (anyInitialBalance <0){
			System.out.println("\tValue of anyInitialBalance parameter is < 0");
			return;
		}
		else{
			System.out.println("\tValue of anyInitialBalance parameter is NOT < 0");

		}
		// no need to check the value of accountNumber field, of course it is zero
		// since we are in the middle of constructing it.
		accountNumber= anyAccountNumber;
		balance=anyInitialBalance;
		System.out.println("\tAccount Number at the end of Constructor call is : " + accountNumber);
		System.out.println("\tBalance at the end of Constructor call is : " + balance);
	}

	/** An overloaded method that sets default interest rate 
	* @return The Assigned interestRate.
	*/
	public double setInterestRate(){
		System.out.println("\tIn setInterestRate()");
		interestRate=4;
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
