public class Address {
	// attributes to store address
	private String street;
	private String city;
	private String state;
	private String zip;

	public Address(String anyStreet, String anyCity, String anyState, String anyZip){
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

}
