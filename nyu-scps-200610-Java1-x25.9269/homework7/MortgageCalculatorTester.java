public class MortgageCalculatorTester {

    public static void main(String[] args){
        MortgageCalculator stub = new MortgageCalculator_Stub();
        {
        Mortgage mortgage1 = new Mortgage();
        mortgage1.setInterestRate(6);
        mortgage1.setLoanAmount(500000);
        mortgage1.setYears(30);
        Integer monthlyPaymentAmount =stub.calculateMonthlyPayment(mortgage1);

        System.out.println("Mortgage Interest Rate: " + mortgage1.getInterestRate());
        System.out.println("Loan Amount: " + mortgage1.getLoanAmount());
        System.out.println("# of Years: " + mortgage1.getYears());
        System.out.println("Returned Monthly Payment Amount: " + monthlyPaymentAmount);
        System.out.println();
        }
        {
        Mortgage mortgage2 = new Mortgage();
        mortgage2.setInterestRate(6);
        mortgage2.setMonthlyPayment(2998);
        mortgage2.setYears(30);
        Integer loanAmount =stub.calculateLoanAmount(mortgage2);

        System.out.println("Mortgage Interest Rate: " + mortgage2.getInterestRate());
        System.out.println("Monthly Payment Amount: " + mortgage2.getMonthlyPayment());
        System.out.println("# of Years: " + mortgage2.getYears());
        System.out.println("Returned Mortgage Amount: " + loanAmount);
        }

    }
}
