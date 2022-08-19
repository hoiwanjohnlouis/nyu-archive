import java.io.Serializable;

public class SerializableName implements Cloneable,Serializable {

	public static final long serialVersionUID = 1;

	//field to store name attributes
	private String firstName;
	private String middleName;
	private String lastName;
	
	public SerializableName(String anyFirstName,String anyMiddleName,String anyLastName){
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
	public Object clone(){

		// declare a temp variable of object type since we have to return Object.
		Object copy=null;
		try{
			// make of copy of Name using Object's clone() method.
			copy =super.clone();
		}
		catch(CloneNotSupportedException e){
			// do nothing at all - since this exception will never be thrown.
		}
		// return the copied Name.
		return copy;
	}

}
