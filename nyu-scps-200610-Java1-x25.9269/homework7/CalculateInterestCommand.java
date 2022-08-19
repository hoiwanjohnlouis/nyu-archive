public class CalculateInterestCommand extends BankAccount implements Command{

    // serialVersionUID is required by JVM for serialization
    //whenever your class changes shape in a way that will be incompatible
    //with previously serialized versions, simply increment this number.
    public static final long serialVersionUID = 1;

    public CalculateInterestCommand() throws NegativeAmountException{
        super();
    }
    public Command execute(){
        setInterestAmount(getBalance()*getInterestRate()/100);
        return this;
    }
}
