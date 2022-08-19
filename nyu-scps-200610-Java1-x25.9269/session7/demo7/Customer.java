public class Customer implements Cloneable{
	// private fields to hold customer information.
	private Name name;
	private Address address;
	
	/** Customer constructor that takes name as input.
	*/
	public Customer(Name anyName){
		name = anyName;
	}
	
	/** Customer constructor that takes name and address as input.
	*/
	public Customer(Name anyName, Address anyAddress){
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
