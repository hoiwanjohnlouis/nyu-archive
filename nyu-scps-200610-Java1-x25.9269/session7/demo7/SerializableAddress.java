import java.io.Serializable;

public class SerializableAddress implements Cloneable,Serializable{

	public static final long serialVersionUID = 1;
	// attributes to store address
	private String street;
	private String city;
	private String state;
	private String zip;

	public SerializableAddress(String anyStreet, String anyCity, String anyState, String anyZip){
		street= anyStreet;
		city= anyCity;
		state=anyState;
		zip= anyZip;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
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
