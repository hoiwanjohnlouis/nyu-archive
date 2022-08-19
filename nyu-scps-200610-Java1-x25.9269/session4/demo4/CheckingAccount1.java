public class CheckingAccount1 extends BankAccount
{
	// private field to keep track of last issue check number on check book.
	private int lastCheckNumber;

	/** This method increments last issued check number.
	* @param howManyChecks Last issued check number on check book.
	*/
	public int requestLastCheckNumber(int howManyChecks){
		System.out.println("\tIn requestLastCheckNumber of CheckingAccount1");
		lastCheckNumber += howManyChecks;
		return lastCheckNumber;
	}

	/** This method returns the last issued check number.
	* @return Last issued check number on check book.
	*/
	public int getLastCheckNumber(){
		System.out.println("\tIn getLastCheckNumber of CheckingAccount1");
		return lastCheckNumber;
	}
}
