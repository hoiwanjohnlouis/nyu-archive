//	JAVA 1, HOMEWORK 2a
//
//  HOI WAN JOHN LOUIS
//
//	a)	Write a class Dimension that has the following:
//		1)	private double fields length, height, width
//		2)	One and only one pubic constructor that takes all three dimesion attributes to create Dimension Object.
//		3)	Public Getters and Setters for all three fields.
//
//	Here is a tester for Dimension:
//
//	Here is the output:
//
//	Length: 7.1
//	Height: 8.2
//	Width: 9.3
//
//	Length: 5.0
//	Height: 6.0
//	Width: 7.0
//

public class DimensionTester {

	public static void main(String[] args) {

		Dimension dimension = new Dimension(7.1,8.2,9.3);

		//print dimension
		System.out.println("Length: " 
				+ dimension.getLength());
		System.out.println("Height: " 
				+ dimension.getHeight());
		System.out.println("Width: " 
				+ dimension.getWidth());
		System.out.println();
		
		// change dimension
		dimension.setLength(5);
		dimension.setHeight(6);
		dimension.setWidth(7);

		//print dimension
		System.out.println("Length: " 
				+ dimension.getLength());
		System.out.println("Height: " 
				+ dimension.getHeight());
		System.out.println("Width: " 
				+ dimension.getWidth());
		System.out.println();
	}
}

