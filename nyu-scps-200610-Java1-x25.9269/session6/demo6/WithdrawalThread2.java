public class WithdrawalThread2 extends Thread{
	/** A field to hold the account number received by the constructor.*/
	private BankAccount2 bankAccount;

	/** The constructor that receives thread name and bank account as argument.
	* @param threadName ThreadName.
	* @param anyBankAccount Bank Account.
	*/
	WithdrawalThread2(String threadName, BankAccount2 anyBankAccount){
		// call the constructor of Thread that takes thread name as argument.
		super(threadName);

		// save the reference to bankaccount object.
		bankAccount=anyBankAccount;
	}

	public void run(){
		// loops 4 times
		for (int n=1; n<=4; n++)
		{
			// calls withdrawal of bankaccount with withdrawal number n.
			bankAccount.withdrawal(600,n);
		}
	}
}
