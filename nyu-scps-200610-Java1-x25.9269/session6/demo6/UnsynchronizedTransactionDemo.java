
public class UnsynchronizedTransactionDemo{
	public static void main (String[] args){
		//create one and only one bankaccount object.
		BankAccount1 citiBankAccount = new BankAccount1();

		// create deposit thread with name and bank account.
		DepositThread1 depositThread = new DepositThread1("Deposit",citiBankAccount);

		// create withdrawal thread with name and the same bank account.
		WithdrawalThread1 withdrawalThread = new WithdrawalThread1("Withdrawal",citiBankAccount);

		//start both threads.
		withdrawalThread.start();
		depositThread.start();
	}
}
