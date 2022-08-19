public class SynchronizedBlockTransactionDemo{
	public static void main (String[] args){
		//create one and only one bankaccount object.
		BankAccount3 citiBankAccount = new BankAccount3();

		// create deposit thread with name and bank account.
		DepositThread3 depositThread = new DepositThread3("Deposit",citiBankAccount);

		// create withdrawal thread with name and the same bank account.
		WithdrawalThread3 withdrawalThread = new WithdrawalThread3("Withdrawal",citiBankAccount);

		//start both threads.
		withdrawalThread.start();
		depositThread.start();
	}
}
