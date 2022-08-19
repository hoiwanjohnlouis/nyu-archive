public class Customer3{
	// private fields to hold customer information.
	private Name name;
	private Address address;
	
	/** Customer constructor that takes name as input.
	*/
	public Customer3(Name anyName){
		name = anyName;
	}
	
	/** Customer constructor that takes name and address as input.
	*/
	public Customer3(Name anyName, Address anyAddress){
		name = anyName;
		address = anyAddress;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

}
