//  JAVA 1, HOMEWORK 4.5b
//
//  HOI WAN JOHN LOUIS
//
//  EmployeeType is an enum with the following two values :
//      FullTime, PartTime where FullTime is 0 and PartTime is 1.
//
public enum EmployeeType {
    FullTime(0),
    PartTime(1);

    private int value;

    /**
     * Contructor
     * @param int anyValue
    */
    EmployeeType(int anyValue) {
       setEmpType(anyValue);
//       System.out.println("\tLeaving Enum Contructor EmployeeType with anyValue parameter:" + anyValue);
    }
    /**
     * The getValue method gets the value
     * @return int this.value
     */
    public int setEmpType() {
        return this.value;
    }

    /**
     * The setValue method sets
     */
    public void setEmpType(int anyValue) {
        this.value = anyValue;
    }
}


