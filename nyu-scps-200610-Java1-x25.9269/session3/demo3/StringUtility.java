public class StringUtility{


	/** A method that will perform find and replace all occurrences of a string on a given string 
	* between start and end position.
	* @param input Input String.
	* @param find Search String.
	* @param replaceWith Replacement String.
	* @param startPosition Starting position for the search.
	* @param endPosition   End position for the search. The search will actually stop at (endPosition-1).
	* @return Replaced String.
	*/
	public static String replaceString(String input, String find,
		 String replaceWith, int startPosition, int endPosition)
	{
		// declare a temp variable.
		String temp;

		// find the length of find string.
		int findLength=find.length();

		// initial return string 0 to (startPosition-1)
		String returnValue = input.substring(0,startPosition);
		
		while (true)
		{
			// if the rest of the string is smaller than the find string
			// concatenate the rest with return string and return.
			if ((startPosition + findLength)> endPosition){
				returnValue=returnValue + input.substring(startPosition);
				return returnValue;
			}
			
			// get the next chunk
			temp=input.substring(startPosition,startPosition+findLength);
			
			// compare with find string.
			// if equal, do the replacement
			// increment your position by the
			// length of find string
			if (temp.equals(find)){
				returnValue=returnValue+replaceWith;
				startPosition += findLength;
			}
			// if not equal, it is ok to add 1 character
			// to the return string and
			// increment your position by 1
			else
			{
				returnValue=returnValue+input.charAt(startPosition);
				startPosition++;
			}
		}
	}

	/** The main method(automatically invoked by JVM) that 
	* creates String objects and calls the replaceString method.
	*/
	public static void main(String[] args)
	{
		//declare variables.
		String oldString;
		String newString;
		
		// original string
		oldString = new String("How are you? How is Everyone else? How is your friend Jim Doing?");
		
		// newString string where "How" is replaced by "Where" between
		// position 10 and 20
		newString = replaceString(oldString,"How","Where",10,20);
		
		// print the original and replaced string
		System.out.println("Old String: " + oldString);
		System.out.println("New String: " + newString);

		// original string
		oldString = new String("Never say never never never never again!!!!");
		
		// newString string where "How" is replaced by "Where" between
		// position 10 and 20
		newString = replaceString(oldString,"never","ever",16,35);
		
		// print the original and replaced string
		System.out.println("Old String: " + oldString);
		System.out.println("New String: " + newString);

	}	

}
