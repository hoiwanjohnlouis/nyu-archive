public class EmployeeTypeTester {

    public static void main(String[] args) {

        //these blocks {} are little protection against using the
        // the same varible like e1 again by accident down below
        {
        EmployeeType et1 = EmployeeType.FullTime;
        System.out.println("Name: " + et1.name());
        }

        {
        EmployeeType et2 = EmployeeType.PartTime;
        System.out.println("Name: " + et2.name());
        }

        EmployeeType[] etTypes = EmployeeType.values();
        System.out.println("All Possible Names:");
        for (int i=0;i<etTypes.length;i++){
            System.out.println(etTypes[i]);
        }
    }

}
