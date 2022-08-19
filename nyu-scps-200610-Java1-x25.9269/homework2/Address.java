//	JAVA 1, HOMEWORK 2b
//
//  HOI WAN JOHN LOUIS
//
//	b)	Create a class called Appliance that has the following:
//		1)	One String type field called modelNumber that can not be modified after initialization and it is visible to outside world.
//		2)	One int tyle field called serailNumber that can not be modified after initialization and it is visible to outside world.
//		3)	One Customer3 type field called owner that is NOT visible to the outside world without using Getter and Setter.
//		4)	One Dimension  type field called dimension that is NOT visible to the outside world without using Getter and Setter.
//		5)	Three public constructors – the first one only takes model number, the second one takes model number and owner and the third one takes model number, owner and dimension.
//		6)	Public Getters and Setters for four fields.
//		7)	A method getNumberOfApplianceCreated() that will return object count.
//
//	Rules:
//
//		a)	Serial number should be automatically assigned by all three consturctors by incrementing a number by one.
//		b)	If the current time in millisecond is even, the starting serial number should be 100. If odd, the starting serial number is 7453. You should use System.currentTimeMillis() function for the current time in millisecond. Use constant to store starting serial number.
//		c)	Constructors should not repeat the same code. They should call one another for execution of the same code.
//
//
public class Address {
		// attributes to store address
		private String street;
		private String city;
		private String state;
		private String zip;

		
		
		/**
		 * @param street
		 * @param city
		 * @param state
		 * @param zip
		 */
		public Address(String street, String city, String state, String zip) {
			super();
			setStreet(street);
			setCity(city);
			setState(state);
			setZip(zip);
		}
		/**
		 * @return the city
		 */
		public String getCity() {
			return city;
		}
		/**
		 * @param city the city to set
		 */
		public void setCity(String city) {
			this.city = city;
		}
		/**
		 * @return the state
		 */
		public String getState() {
			return state;
		}
		/**
		 * @param state the state to set
		 */
		public void setState(String state) {
			this.state = state;
		}
		/**
		 * @return the street
		 */
		public String getStreet() {
			return street;
		}
		/**
		 * @param street the street to set
		 */
		public void setStreet(String street) {
			this.street = street;
		}
		/**
		 * @return the zip
		 */
		public String getZip() {
			return zip;
		}
		/**
		 * @param zip the zip to set
		 */
		public void setZip(String zip) {
			this.zip = zip;
		}
}
