public class SynchronizedTransactionDemo{
	public static void main (String[] args){
		//create one and only one bankaccount object.
		BankAccount2 citiBankAccount = new BankAccount2();

		// create deposit thread with name and bank account.
		DepositThread2 depositThread = new DepositThread2("Deposit",citiBankAccount);

		// create withdrawal thread with name and the same bank account.
		WithdrawalThread2 withdrawalThread = new WithdrawalThread2("Withdrawal",citiBankAccount);

		//start both threads.
		withdrawalThread.start();
		depositThread.start();
	}
}
