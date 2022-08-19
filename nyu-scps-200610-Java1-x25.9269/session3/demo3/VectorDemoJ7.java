import java.util.*;
public class VectorDemoJ7
{

	/** The main method(automatically invoked by JVM) that
	* creates objects and adds them to a Vector.
	*/
	public static void main(String[] args)
	{
		Object element;
		int i=1000, j=0;
		short m=5, n=0;
		boolean q=true, r=false;
		String lastName="Smith", foundString="";

		// convert int to Integer Object.
		Integer I=new Integer(i);

		// covert short to Short Object.
		Short M= new Short(m);


		// convert boolean to Boolean Object.
		Boolean Q = new Boolean(q);

		// create a new vector object and add elements to it.
		// Vector vecDemo = new Vector();
		// HLouis added <Object> for Java7 compliance
		Vector<Object> vecDemo = new Vector<Object>();
		vecDemo.addElement(I);
		vecDemo.addElement(M);
		vecDemo.addElement(Q);
		vecDemo.addElement(lastName);

		//loop thought the elements in a vector and examine them
		for (int s=0; s < vecDemo.size(); s++)
		{
			// set reference to each element inside the vector as Object.
			element=vecDemo.elementAt(s);

			// find out if the object is Integer Object.
			if (element instanceof Integer)
			{
				/* cast the object variable to Integer.
				** call intValue() method of Integer
				** object that returns the int
				** inside an Integer Object.
				*/
				j= ((Integer) element).intValue();

				// print the int just extracted.
				System.out.println("Integer Found: " + j);
			}

			/* find out if the object is an Short Object.
			** This test can be done in two ways.
			** 1. using instanceof as above.
			** 2. using getClass().getName() as below.
			*/
			if ((element.getClass().getName().equals("java.lang.Short")))
			{
				/* cast the object variable to Short.
				** call shortValue() method of Short Object that returns
				** the short value inside a Short Object.
				*/
				n= ((Short) element).shortValue();

				// print the short just extracted.
				System.out.println("Short Found: " + n);
			}

			// find out if the object is Boolean Object.
			if (element instanceof Boolean)
			{
				// cast object to Boolean and call booleanValue() method.
				r= ((Boolean) element).booleanValue();
				//print the boolean.
				System.out.println("Boolean Found: " + r);
			}

			// find out if the object is String.
			if (element instanceof String)
			{
				// get the string out.
				foundString= element.toString();

				//print the string.
				System.out.println("String Found: " + foundString);
			}
		}
	}
}
