public class BankAccount2{ 
	 /** declare a field to hold current balance. */
	private double balance; 

	/** Deposit method with some print statement to show progress.
	* @param amount Deposit Amount.
	* @param n Deposit number 1,2,3 .. etc.
	*/
	public synchronized void  deposit(double amount, int n){
		try{
			System.out.println("Deposit " + n +" In Progress...");
			double temp1 = balance;
			temp1 = temp1 + amount;
			int random = (int) (Math.random()*100);
			System.out.println("Deposit " + n + " Sleeping for: " + random +" ms");
			Thread.sleep(random);
			balance = temp1;
			System.out.println("After Deposit " + n + " the balance is " 
						+ balance);
			System.out.println("Deposit " + n +" Finshed.");
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	/** Withdrawal method with some print statement to show progress.
	* @param amount Withdrawal Amount.
	* @param n Deposit number 1,2,3 .. etc.
	*/
	public synchronized void withdrawal(double amount, int n){
		try{
			System.out.println("Withdrawal " + n +" In Progress...");
			double temp2 = balance;
			temp2 = temp2 - amount;
			int random = (int) (Math.random()*100);
			System.out.println("Withdrawal " + n + " Sleeping for: " + random +" ms");
			Thread.sleep(random);
			balance = temp2;
			System.out.println("After Withdrawal " + n + " the balance is " +
		 				balance);
			System.out.println("Withdrawal " + n +" Finshed.");
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	/** getBalance method with some print statement to show progress.
	* @param n Deposit number 1,2,3 .. etc.
	* @param strThreadName A String indicating which thread is calling it - 
	* 'Deposit' or 'Withdrawal' thread.
	*/
	public synchronized double getBalance(int n,String strThreadName){
		System.out.println("'getBalance' returns after " + strThreadName+ " " + n +
			 		": " +	balance);
		return balance;
	}
} 
