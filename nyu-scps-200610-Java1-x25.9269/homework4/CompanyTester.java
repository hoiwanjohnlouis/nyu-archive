public class CompanyTester {

    public static void main(String[] args) {

        //these blocks {} are little protection against using the
        // the same varible like c1 again by accident down below
        {
            Company c1 = new Company();
            c1.setLegalName("Coca Cola Company Inc.");
            String[] tradeNames = new String[2];
            tradeNames[0]="Coke";
            tradeNames[1]="Coca Cola";
            c1.setTradeNames(tradeNames);
            c1.setProfit(5000000);
            Address a1 = new Address("1234, West 4th Street", "NY","NY", "10063");
            c1.setLegalAddress(a1);
            // You have to populate CEO info here for the company.

            // setIncome will also set tax bracket
            Employee e1 = new Employee();
            e1.setNickName(c1.getLegalName());
            e1.setLegalAddress(a1);
            e1.setEmpType(EmployeeType.FullTime);
            e1.setIncome(300000);
            c1.setCeo(e1);

            printCompanyInfo(c1);
        }
        {
            Company c2 = new Company("Pepsi Cola Company Inc.");
            String[] tradeNames = new String[2];
            tradeNames[0]="Pepsi";
            tradeNames[1]="Pep-Pop";
            c2.setTradeNames(tradeNames);
            c2.setProfit(4000000);
            Address a2 = new Address("344, East 7th Avenue", "NY","NY", "10022");
            c2.setLegalAddress(a2);
            // You have to populate CEO info here for the company.

            // setIncome will also set tax bracket
            Employee e2 = new Employee();
            e2.setNickName(c2.getLegalName());
            e2.setLegalAddress(a2);
            e2.setEmpType(EmployeeType.FullTime);
            e2.setIncome(250000);
            c2.setCeo(e2);

            printCompanyInfo(c2);
        }
        {
            Address a3 = new Address("12-23, 102nd Street", "Corona","NY", "11234");
            Company c3 = new Company("Fanta Inc.",a3);
            String[] tradeNames = new String[2];
            tradeNames[0]="Fanta";
            tradeNames[1]="Fonta";
            c3.setTradeNames(tradeNames);
            c3.setProfit(1000000);
            // You have to populate CEO info here for the company.

            // setIncome will also set tax bracket
            Employee e3 = new Employee();
            e3.setNickName(c3.getLegalName());
            e3.setLegalAddress(a3);
            e3.setEmpType(EmployeeType.FullTime);
            e3.setIncome(60000);
            c3.setCeo(e3);

            printCompanyInfo(c3);
            }
    }

    private static void printCompanyInfo(Company c){
        System.out.println("Id: " + c.id);
        System.out.println("Legal Name: " + c.getLegalName());
        System.out.println("Street: " + c.getLegalAddress().getStreet());
        System.out.println("Trade Names:");
        String[] tradeNames = c.getTradeNames();
        for(int i=0;i<tradeNames.length;i++){
            System.out.println("Trade Name: " + tradeNames[i]);
        }
        System.out.println("Profit: " + c.getProfit());
        showTaxInfo(c);
        Person p = c.getCeo();
        System.out.println("Ceo's Income: " + p.getIncome());
        System.out.println("Ceo's Tax Info:");
        showTaxInfo(p);
        System.out.println();

    }

    //showTaxInfo method goes here
    /**
     * @param Taxable anyTaxable
     *
     *   b) Write a polymorphic, private, static void method showTaxInfo that
     *      will accept Taxable, yes Taxable, yes, I know Taxable is an
     *      interface name – still Taxable and print taxRate (both in
     *      word and number) and calculated tax.
     */
    private static void showTaxInfo(Taxable anyTaxable) {

        System.out.println("Tax Rate: " + anyTaxable.getTaxRate() + "(" +anyTaxable.getTaxRate().value()+"%)");
        System.out.println("Tax: " + anyTaxable.calculateTax());
        return;
    }



}
