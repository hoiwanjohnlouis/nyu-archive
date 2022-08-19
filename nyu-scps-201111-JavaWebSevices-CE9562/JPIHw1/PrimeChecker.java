/**
 * An utility class to identify prime numbers.
 * @author Mohammed Rahman
 * @version 2.0
 */
public class PrimeChecker {
	/**
	 * A method that returns true  if the input is a prime number.
	 * @param anyNumber any input number
	 * @return true/false indicator of primeness.
	 */
    public static boolean checkPrime(int anyNumber){

    	// all negative numbers and zero and 1 is not prime.
    	if (anyNumber <= 1){
    		return false;
    	}
    	
    	//2 is prime
    	if (anyNumber==2){
    		return true;
    	}
    	
    	//all other even numbers are not prime
    	if (anyNumber % 2==0){
    		return false;
    	}
    	
    	/*The most basic method of checking the primality
    	 *  of a given integer n is called trial division.
    	 *  This routine consists in dividing n by each 
    	 *  integer m which is greater than 1 and less 
    	 *  than or equal to the square root of n. 
    	 *  If the result of any of these divisions 
    	 *  is an integer, then n is not a prime, 
    	 *  otherwise, it is a prime.
    	 *  
    	 *  see: http://en.wikipedia.org/wiki/Prime_number for details
    	 */
    	for (int i = 2;i < Math.sqrt(anyNumber);i++){
    		//if a number is equally divisible it is not prime.
    		if ((anyNumber % i) == 0){
    			return false;
    		}
    	}
    	return true;
    	
    }

    /**
     * The main method that JVM invokes. 
     * This method is a tester method for checkPrime method.
     * This method will generate random numbers and check for 
     * prime.
     * @param args command level arguments
     */
    public static void main(String[] args) {
    	boolean found = false;
		int myNumber =0;
		for (int p=1; p <= 40;p++){
			// get a random number between -20 and 79
			myNumber = (int) (Math.random() * 100) - 20;
			found = checkPrime(myNumber);
			if (found){
				// print only prime numbers in tab separated format
				System.out.print(myNumber  + "\t");
			}
		}
    }
}
