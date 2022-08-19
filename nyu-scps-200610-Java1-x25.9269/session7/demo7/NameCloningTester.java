public class NameCloningTester {

	public static void main(String[] args){
		// create a name object using default no argument constructor.
		Name name1 = new Name("John","A","Smith");

		System.out.println("Original Name:");
		printNameInfo(name1);

		// clone() method returns Object - let's cast it back to Name.
		Name name2 = (Name) name1.clone();
		System.out.println("Clone of Name");
		printNameInfo(name2);
		
		name1.setFirstName("Barbara");
		System.out.println("Original Name - Changed Once:");
		printNameInfo(name1);

		System.out.println("Clone of Name - Still Unchanged");
		printNameInfo(name2);
		
		name2.setFirstName("Eric");
		System.out.println("Original Name - Changed Once Unchanged Now:");
		printNameInfo(name1);

		System.out.println("Clone of Name - Changed Now");
		printNameInfo(name2);
	}
	public static void printNameInfo(Name name){
		System.out.println("First Name: " + name.getFirstName());
		System.out.println("Middle Name: " + name.getMiddleName());
		System.out.println("Last Name: " + name.getLastName());
		System.out.println();
	}
}
