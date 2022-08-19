public class BankAccount5Tester3 {

	public static void main(String[] args) {
		
		BankAccount5 b = null;
		try{
			b = new BankAccount5();
			System.out.println("Successfully constructed BankAccount5");
			b.deposit(5000);
			System.out.println("Successfully deposited");
			b.withdrawal(6000);
			System.out.println("Successfully withdrew");
			System.out.println("Account Number: " + b.accountNumber);
			System.out.println("Balance: " + b.getBalance());
			System.out.println("Successfully completed the try block");
		}
		catch(NegativeAmountException e){
			System.out.println("Error Message: " +e.getMessage());
			System.out.println("Amount: " + e.getAmount());
			e.printStackTrace();
		}
		catch(InsufficientBalanceException e){
			System.out.println("Error Message: " +e.getMessage());
			System.out.println("Balance: " + e.getBalance());
			System.out.println("Amount: " + e.getAmount());
			e.printStackTrace();
		}
		finally{
			b = null;
			System.out.println("Completed the try-catch-finally, success or failure");
		}
		System.out.println("Completed the main method, success or failure");
	}
}
