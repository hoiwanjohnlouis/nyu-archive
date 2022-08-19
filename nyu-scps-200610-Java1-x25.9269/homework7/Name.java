import java.io.Serializable;

public class Name implements Serializable,Cloneable
{
    // private fields to hold customer information.
    private String firstName;
    private String middleName;
    private String lastName;

    public Name(){
    }
    public Name(String aFirstName, String aMiddleName, String aLastName){
        // call changeName to store the name information.
        changeName(aFirstName,aMiddleName,aLastName);
    }

    public void changeName(String aFirstName, String aMiddleName, String aLastName){
        firstName= aFirstName;
        middleName= aMiddleName;
        lastName= aLastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getMiddleName(){
        return middleName;
    }

    public String getLastName(){
        return lastName;
    }

    public void printName(){
        System.out.println(firstName + " " + middleName + " " +lastName);
    }

    public Object clone(){
        try{
            return super.clone();
        }
        catch(Exception e){
            //do nothing - will never happen.
            return null;
        }
    }

}
