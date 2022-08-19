public class Name {
    //field to store name attributes
    private String firstName;
    private String middleName;
    private String lastName;

    public Name(String anyFirstName,String anyMiddleName,String anyLastName){
        firstName=anyFirstName;
        middleName=anyMiddleName;
        lastName=anyLastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

}
