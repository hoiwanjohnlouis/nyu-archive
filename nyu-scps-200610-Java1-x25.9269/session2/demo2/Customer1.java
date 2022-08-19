public class Customer1{
	// private fields to hold customer information.
	private String firstName;
	private String middleName;
	private String lastName;
	private String street;
	private String city;
	private String state;
	private String zip;
	
	/** Customer constructor that takes name as input.
	*/
	public Customer1(String anyFirstName, String anyMiddleName, String anyLastName){
		firstName= anyFirstName;
		middleName= anyMiddleName;
		lastName= anyLastName;
	}
	

	/** Customer constructor that takes name and address as input.
	*/
	public Customer1(String anyFirstName, String anyMiddleName, String anyLastName, 
			String anyStreet, String anyCity, String anyState, String anyZip){
		firstName= anyFirstName;
		middleName= anyMiddleName;
		lastName= anyLastName;
		street= anyStreet;
		city= anyCity;
		state=anyState;
		zip= anyZip;
	}

	public String getCity() {
		return city;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getState() {
		return state;
	}

	public String getStreet() {
		return street;
	}

	public String getZip() {
		return zip;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
}
