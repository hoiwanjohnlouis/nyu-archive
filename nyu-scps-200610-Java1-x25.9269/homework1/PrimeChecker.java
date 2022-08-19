
public class PrimeChecker {

    public static boolean checkPrime(int anyNumber){
        boolean flag = false;

        int i = 0;
        int MAX = anyNumber;

        // brute force method.  just use a loop
        // looking for modulus value of zero
        // We only need to check numbers greater than one
        if (anyNumber > 1) {

            // start the interation
            for (i = 2; i <= MAX; i++) {

                // have we found a zero modulus?
                if ((anyNumber % i) == 0) {

                    // we've reached our parameter value
                    if (i == MAX) {
                        // must be prime
                        flag = true;
                        break;
                    }
                    else {
                        // found another divisor for this number which is not itself
                        // cannot be prime; break out and return
                        break;
                    }
                }
                else {
                    // have a non zero modulus. keep checking
                    continue;
                }

            }   //  END for (i = 2; i <= MAX; i++) {
        }   //  END if (anyNumber> 1) {

        return flag;
    }

    public static void main(String[] args) {
        boolean found = false;
        for (int p=-5; p<35;p++){
            found = checkPrime(p);
            if (found){
                System.out.print(p  + "\t");
            }
        }
    }
}
