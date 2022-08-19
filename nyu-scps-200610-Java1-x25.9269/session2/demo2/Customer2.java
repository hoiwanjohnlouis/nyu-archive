public class Customer2{
	// private fields to hold customer information.
	private Name name;
	private String street;
	private String city;
	private String state;
	private String zip;
	
	/** Customer constructor that takes name as input.
	*/
	public Customer2(Name anyName){
		name = anyName;
	}
	

	/** Customer constuctor that takes name and address as input.
	*/
	public Customer2(Name anyName, String anyStreet, String anyCity, String anyState, String anyZip){
		name = anyName;
		street= anyStreet;
		city= anyCity;
		state=anyState;
		zip= anyZip;
	}

	public String getCity() {
		return city;
	}

	public Name getName() {
		return name;
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


	public void setName(Name name) {
		this.name = name;
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
