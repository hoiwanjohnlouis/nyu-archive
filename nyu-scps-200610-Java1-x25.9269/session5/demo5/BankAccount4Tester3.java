public class BankAccount4Tester3 {

	public static void main(String[] args) {
		try{
			BankAccount4 b = new BankAccount4();
			System.out.println("Successfully constructed BankAccount4");
			b.deposit(5000);
			System.out.println("Successfully deposited");
			b.withdrawal(6000);
			System.out.println("Successfully withdrew");
			System.out.println("Account Number: " + b.accountNumber);
			System.out.println("Balance: " + b.getBalance());
			System.out.println("Successfully completed the try block");
		}
		catch(Exception e){
			System.out.println("Error Message: " +e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Completed the main method, success or failure");
	}
}
