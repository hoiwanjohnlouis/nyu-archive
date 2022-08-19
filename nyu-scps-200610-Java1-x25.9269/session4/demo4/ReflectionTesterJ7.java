import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTesterJ7{

	public static void main(String[] args) throws Exception{

		//creating object of type Class - this object knows all about BankAccount Class
		//Class bankAccountClass = Class.forName("BankAccount");
		Class bankAccountClass = Class.forName("BankAccount");

		System.out.println("Creating BankAccount using reflection");
		// creating a BankAccount object from BankAccount Class
		Object bankAccountInstance = bankAccountClass.newInstance();

		//casting the object to BankAccount since it comes as Object
		BankAccount ba = (BankAccount) bankAccountInstance;

		System.out.println("Accessing BankAccount Info using methods");
		System.out.println("Account Number: " +  ba.accountNumber);
		System.out.println("Balance: " +  ba.getBalance());


		System.out.println("Accessing account number field using refrection");
		Field accountNumberField = bankAccountClass.getField("accountNumber");
		int accountNumber = accountNumberField.getInt(bankAccountInstance);
		System.out.println("Account Number: " +  accountNumber);

		System.out.println("Accessing getBalance method using refrection");
		// since the method has no parameter the second argument is null
		// Method getBalanceMethod = bankAccountClass.getMethod("getBalance",null);
		Method getBalanceMethod = bankAccountClass.getMethod("getBalance");
		// since the method needs no argument to be passed in the second argument is null
		// Object balance = getBalanceMethod.invoke(bankAccountInstance,null);
		Object balance = getBalanceMethod.invoke(bankAccountInstance);
		System.out.println("Balance: " +  balance);

		System.out.println("Accessing deposit method using refrection");
		// since deposit only takes one argument we need an array of size 1
		Class[] parameterTypes = new Class[1];
		// deposit takes a double argument
		parameterTypes[0]=double.class;
		// since the method has one double parameter the second argument is size one array of double
		// Method depositMethod = bankAccountClass.getMethod("deposit",parameterTypes);
		Method depositMethod = bankAccountClass.getMethod("deposit",parameterTypes);

		// since the method needs one argument to be passed in the second argument is an array of double of size one
		double amount = 400.50;
		Object[] arguments = new Object[1];
		arguments[0]= new Double(amount);
		Object success = depositMethod.invoke(bankAccountInstance,arguments);
		System.out.println("Deposit Successful: " + success);

		System.out.println("Accessing getBalance method again using refrection");
		// balance = getBalanceMethod.invoke(bankAccountInstance,null);
		balance = getBalanceMethod.invoke(bankAccountInstance);
		System.out.println("Balance: " +  balance);

	}
}
