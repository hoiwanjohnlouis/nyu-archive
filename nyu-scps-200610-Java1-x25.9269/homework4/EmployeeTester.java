public class EmployeeTester {

    public static void main(String[] args) {

        //these blocks {} are little protection against using the
        // the same varible like e1 again by accident down below
        {
        Employee e1 = new Employee();
        e1.setEmpType(EmployeeType.FullTime);
        Name n1 = new Name("John", "K", "Smith");
        e1.setName(n1);
        Address a1 = new Address("21-34, 14th Street", "Flushing", "NY", "11345");
        e1.setLegalAddress(a1);
        e1.setNickName("Jay");
        e1.setIncome(120000);
        printEmployeeInfo(e1);
        }

        {
        Name n2 = new Name("Barbara", "J", "Cohen");
        Employee e2 = new Employee(n2);
        e2.setEmpType(EmployeeType.PartTime);
        Address a2 = new Address("1740, Broadway", "NY", "NY", "10048");
        e2.setLegalAddress(a2);
        e2.setNickName("Becky");
        e2.setIncome(29500);
        printEmployeeInfo(e2);
        }
        {
        Name n3 = new Name("Charles", "Y", "King");
        Address a3 = new Address("123 River Street", "Hoboken", "NJ", "07030");
        Employee e3 = new Employee(n3,a3);
        e3.setEmpType(EmployeeType.FullTime);
        e3.setNickName("Chuck");
        e3.setIncome(98300);
        printEmployeeInfo(e3);
        }

    }

    private static void printEmployeeInfo(Employee e){
        System.out.println("Id: " + e.id);
        System.out.println("Employee Type: " + e.getEmpType());
        System.out.println("First Name: " + e.getName().getFirstName());
        System.out.println("Street: " + e.getLegalAddress().getStreet());
        System.out.println("Nick Name: " + e.getNickName());
        System.out.println("Income: " + e.getIncome());
        System.out.println("Tax Rate: " + e.getTaxRate() + "(" +e.getTaxRate().value()+"%)");
        System.out.println("Tax: " + e.calculateTax());
        System.out.println();

    }
}
