public class WrapperDemo
{

	/** The main method(automatically invoked by JVM) that 
	* creates Wrapper objects like Integer, Boolean etc.
	*/
	public static void main(String[] args)
	{
		int n=8;
		String s="10";
		
		// convert  to Integer Object.
		Integer I = new Integer(n);
		
		// convert String to Integer Object. 
		Integer J = new Integer(s);
	
		// pr the numbers inside Integer Objects.
		System.out.println(I.toString()); //prs 8
		System.out.println(J.toString()); //prs 10
		
		boolean p=true;
		String q="FALSE";
		
		// convert boolean to Boolean Object.
		Boolean P=new Boolean(p);
	
		// convert String to Boolean Object.
		Boolean Q=new Boolean(q);

		// pr the boolean values inside Boolean Objects.
		System.out.println(P.toString()); //prs true
		System.out.println(Q.toString()); //prs false
	}
}
