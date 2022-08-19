public class DepositThread1 extends Thread{
	/** A field to hold the account number received by the constructor.*/
	private BankAccount1 bankAccount;

	/** The constructor that receives thread name and bank account as argument.
	* @param threadName ThreadName.
	* @param anyBankAccount Bank Account.
	*/
	DepositThread1(String threadName, BankAccount1 anyBankAccount){
		// call the constructor of Thread that takes thread name as argument.
		super(threadName);

		// save the reference to bankaccount object.
		bankAccount=anyBankAccount;
	}

	public void run(){
		// loops 4 times
		for (int n=1; n<=4; n++)
		{
			// calls deposit of bankaccount with deposit number n.
			bankAccount.deposit(600,n);
		}
	}
}
