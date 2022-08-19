// this class does not compile
public class BankAccount4Tester1 {

	public static void main(String[] args) {
		BankAccount4 b = new BankAccount4();
		b.deposit(5000);
		b.withdrawal(1000);
		System.out.println("Account Number: " + b.accountNumber);
		System.out.println("Balance: " + b.getBalance());
	}
}
