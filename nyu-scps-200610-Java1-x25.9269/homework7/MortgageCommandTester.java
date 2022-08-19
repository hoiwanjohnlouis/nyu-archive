
public class MortgageCommandTester {

    public static void main(String[] args){
        try{
            MortgageCommand mortgageCommand = new MortgageCommand();
            mortgageCommand.setInterestRate(6);
            mortgageCommand.setLoanAmount(500000);
            mortgageCommand.setYears(30);
            System.out.println("Loan Amount: " + mortgageCommand.getLoanAmount());
            System.out.println("Interest Rate: " + mortgageCommand.getInterestRate());
            System.out.println("# of Years: " + mortgageCommand.getYears());
            System.out.println();
            System.out.println("Mortgage Amount BEFORE Server Connection: " + mortgageCommand.getMortgageAmount());
            CommandRouter router = new CommandRouter();
            mortgageCommand = (MortgageCommand) router.route(mortgageCommand);
            System.out.println("Mortgage Amount AFTER Server Connection: " + mortgageCommand.getMortgageAmount());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


}
