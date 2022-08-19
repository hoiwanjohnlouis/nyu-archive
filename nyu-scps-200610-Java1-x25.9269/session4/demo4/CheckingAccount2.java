public class CheckingAccount2 extends BankAccount
{
	// flag to store account maintenance charge.
	private boolean maintenanceFlag;

	// private field to keep track of last issue check number on check book.
	private int lastCheckNumber;

	/** This method increments last issued check number.
	* @param howManyChecks Last issued check number on check book.
	*/
	public int requestLastCheckNumber(int howManyChecks){
		System.out.println("\tIn requestLastCheckNumber  of CheckingAccount2");
		lastCheckNumber += howManyChecks;
		return lastCheckNumber;
	}

	/** This method returns the last issued check number.
	* @return Last issued check number on check book.
	*/
	public int getLastCheckNumber(){
		System.out.println("\tIn getLastCheckNumber  of CheckingAccount2");
		return lastCheckNumber;
	}
	
	/** Overwritten withdrawal method that calls the 
	* the original method and then sets maintenance flag.
	*/
	public boolean withdrawal(double amount){
		System.out.println("\tIn withdrawal of CheckingAccount2");

		// call the withdrawal method of BankAccount Class.
		boolean success= super.withdrawal(amount);

		if (success){
			// call the inherited getBalance method.
			double currentBalance=getBalance();

			// if current balance is less then $2000 - set the flag.
			if (currentBalance < 2000){
				maintenanceFlag=true;
			}
		}
		return success;
	}

	/** New method added that returns the maintenance charge flag.
	* @return Maintenance Charge Flag.
	*/
	public boolean getMaintenanceFlag()
	{
		System.out.println("\tIn getMaintenanceFlag of CheckingAccount2");
		return maintenanceFlag;
	}

}
