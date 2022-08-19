
public class CalculateInterestCommandTester {

    public static void main(String[] args){
        try{
            CalculateInterestCommand command = new CalculateInterestCommand();
            command.deposit(8000);
            command.setInterestRate(4);
            System.out.println("Account Number: " + command.accountNumber);
            System.out.println("Balance: " + command.getBalance());
            System.out.println("Interest Rate: " + command.getInterestRate());
            System.out.println();
            System.out.println("Interest Amount BEFORE Server Connection: " + command.getInterestAmount());
            CommandRouter router = new CommandRouter();
            command = (CalculateInterestCommand) router.route(command);
            System.out.println("Interest Amount AFTER Server Connection: " + command.getInterestAmount());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
