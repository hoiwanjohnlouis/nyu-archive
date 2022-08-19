public class MortgageCommand extends Mortgage implements Command{

    // serialVersionUID is required by JVM for serialization
    //whenever your class changes shape in a way that will be incompatible
    //with previously serialized versions, simply increment this number.
    public static final long serialVersionUID = 1;

    public MortgageCommand(){
        super();
    }
    public MortgageCommand execute(){
        int years = getYears();
        double interestRate = getInterestRate();
        int loanAmount = getLoanAmount();
        double monthlyInterestAmount = loanAmount * interestRate/12/100;
        double factor = 1 - Math.pow(1 + (interestRate/12/100), (years*12) * -1);
        double monthlyPayment = monthlyInterestAmount / factor;
        int mortgageAmount = (int) Math.round(monthlyPayment);
        this.setMortgageAmount(mortgageAmount);
        return this;
    }
}
