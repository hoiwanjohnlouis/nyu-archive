public class BankAccount4
{ 
	/** Integer field to hold account number. */
	private int accountNumber;

	/** Double field to hold current balance. */
	private double balance; 

	/** A constructor that assigns an account number to a bank account. 
     * @param anyAccountNumber The new account number
	*/
	public BankAccount4(int anyAccountNumber){
		System.out.println("\tIn BankAccount4(int anyAccountNumber) Constructor");
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
