public class DataTypeTest
{
public static void main(String[] args)
	{
	// print the title
	System.out.println("Type" + "\t" + "\t" + "Min Value" + "\t" + "\t" + "\t" + "Max Value");
	
	// print min and max of byte
	System.out.println(Byte.TYPE + "\t" + "\t" + Byte.MIN_VALUE + "\t" + "\t" + "\t" + "\t" 
					+ Byte.MAX_VALUE);

	// print min and max of short
	System.out.println(Short.TYPE + "\t" + "\t" + Short.MIN_VALUE + "\t" + "\t" + "\t" + "\t" 
					+ Short.MAX_VALUE);

	// print min and max of integer
	System.out.println(Integer.TYPE + "\t" + "\t" + Integer.MIN_VALUE + "\t" + "\t" + "\t" 
					+ Integer.MAX_VALUE);

	// print min and max of long
	System.out.println(Long.TYPE + "\t" + "\t" + Long.MIN_VALUE  + "\t" + "\t" + Long.MAX_VALUE);

	// print min and max of float
	System.out.println(Float.TYPE + "\t" + "\t" + Float.MIN_VALUE + "\t" + "\t" + "\t" + "\t" 
					+ Float.MAX_VALUE);

	// print min and max of double
	System.out.println(Double.TYPE + "\t" + "\t" + Double.MIN_VALUE + "\t" + "\t" + "\t" 
					+ Double.MAX_VALUE);
	}
}
