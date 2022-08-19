/**
* A String Utility class that performs search on String and
* search and replace on StringBuffer.
*
* @version 1.0
* @author Mohammed Ashequr Rahman
*/
public class StringUtility2
{
    /** A method that will perform find on a string
    * between start and end position.
    * @param input Input String.
    * @param find Search String.
    * @param startPosition Starting position for the search.
    * @param endPosition   End position for the search. The search will actually stop at (endPosition-1).
    * @return Number of occurrences.
    */
    public static int findString(String input, String find, int startPosition, int endPosition)
    {
        boolean DEBUG = false;

        //
        Debugger( DEBUG, "findString (four parms) starts...");

        // trace the parms
        Debugger( DEBUG, "String input ............ :" + input)        ;
        Debugger( DEBUG, "String find  ............ :" + find)         ;
        Debugger( DEBUG, "int    startPosition .... :" + startPosition);
        Debugger( DEBUG, "int    endPosition ...... :" + endPosition)  ;

        /**
         * load the parameters into local variables for debugging purposes
         */
        StringBuffer s1    = new StringBuffer(input);
        StringBuffer f1    = new StringBuffer(find);
        int          start = startPosition;
        int          end   = endPosition;

        int numberOfOccurrences = 0;

        /**
         * Start the search using the substring of input (s1), startPosition (start), endPosition (end)
         */
        while (start < end) {
            //
            int cursor = 0;
            cursor = s1.indexOf(f1.toString(), start);
            Debugger( DEBUG, "cursor .................. :" + cursor);
            /**
             * dont forget the zero offset for stringbuffers
             */
            if  (cursor >= 0) {
                if  (cursor < end) {
                    /**
                     * we found a match
                     * increment Occurrences counter
                     * move start and cursor to
                     */
                    numberOfOccurrences++;

                    Debugger( DEBUG, "found match. moving cursor from " + start + " to ");
                    start = cursor + f1.length();
                    Debugger( DEBUG, start + " for next lookup");
                }
                else {
                    Debugger( DEBUG, "Cursor went beyond 'END' parameter, lookup complete");
                    break;
                }
            }
            else {
                // No match found, the loop is done.
                //DEBUG System.out.println("lookup complete\n");
                break;
            }
        }

        //
        Debugger( DEBUG, "findString (four parms) ends...");

        /**
         * Hopefully numberOfOccurrences has some real data by now
         */
        return numberOfOccurrences;
    }

    /** A method that will perform find on an entire string.
    * @param input Input String.
    * @param find Search String.
    * @return Number of occurrences.
    */
    public static int findString(String input, String find)
    {
        boolean DEBUG = false;

        //
        Debugger( DEBUG, "findString (two parms) starts...");

        /**
         * Create local variables to faciliate debugging/readability
         */
        int startPosition;
        int endPosition;
        int numberOfOccurrences;
        startPosition       = 0;
        endPosition         = input.length();
        numberOfOccurrences = -1;

        /**
         * Lets find out how many Occurrences
         */
        numberOfOccurrences = findString(input, find, startPosition, endPosition);

        /**
         * Hopefully numberOfOccurrences has some real data by now
         */

        //
        Debugger( DEBUG, "findString (two parms) ends...");

        return numberOfOccurrences;
    }

    /** A method that will perform find and replace on a string buffer
    * between start and end position.
    * @param input Input StringBuffer.
    * @param find Search String.
    * @param strReplaceWith Replacement String.
    * @param startPosition Starting position for the search.
    * @param endPosition   End position for the search. The search will actually stop at (endPosition-1).
    * @return Nothing but the original StringBuffer will be modified.
    */
    public static void replaceStringBuffer(StringBuffer input,
        String find, String strReplaceWith, int startPosition, int endPosition)
    {
        boolean DEBUG = false;

        //
        Debugger( DEBUG, "replaceStringBuffer (five parms) starts...");

        int numberOfOccurrences = -1;

        // trace the parms
        Debugger( DEBUG, "StringBuffer input ............ :" + input)           ;
        Debugger( DEBUG, "String       find  ............ :" + find)            ;
        Debugger( DEBUG, "String       strReplaceWith ... :" + strReplaceWith)  ;
        Debugger( DEBUG, "int          startPosition .... :" + startPosition)   ;
        Debugger( DEBUG, "int          endPosition ...... :" + endPosition)     ;

        // make sure there are matches before replacing anything
        numberOfOccurrences = findString(input.toString(), find.toString(), startPosition, endPosition);
        if  (numberOfOccurrences > 0) {
            // loop aroung replacing as we go
            int i      = 0;
            int cursor = -1;
            Debugger( DEBUG, "cursor0 ....................... :" + cursor );
            Debugger( DEBUG, "startPosition0 ................ :" + startPosition );
            while(i < numberOfOccurrences) {

            	// find location of next match
            	cursor = input.indexOf(find.toString(), startPosition );
            	
            	// replace it
                input.replace(cursor, cursor + find.length(), strReplaceWith);                

                Debugger( DEBUG, "StringBuffer input (updated) .. :" + input);
                Debugger( DEBUG, "cursor ........................ :" + cursor );
                
                // ensure we skip the already processed data
                startPosition = cursor + strReplaceWith.length();
                Debugger( DEBUG, "startPosition ................. :" + startPosition );
 
                //
                Debugger( DEBUG, "===========================================" +
                                 "===========================================" );

                // alway increment
                i++;
            }
        }

        //
        Debugger( DEBUG, "replaceStringBuffer (five parms) ends...");

        return;
    }

    /**
     * Centralized debugger logger to default outpuyt
     */
    public static void Debugger (boolean DEBUG, String msg) {
        if  (DEBUG) {
            System.out.println(msg);
        }
    }

    /** A method that will perform find and replace on an entire string buffer.
    * @param input Input StringBuffer.
    * @param find Search String.
    * @param strReplaceWith Replacement String.
    * @return Nothing but the original StringBuffer will be modified.
    */
    public static void replaceStringBuffer(StringBuffer input, String find,
            String strReplaceWith)
    {
        boolean DEBUG = false;

        //
        Debugger( DEBUG, "replaceStringBuffer (three parms) starts...");

        /**
         * Create local variables to faciliate debugging/readability
         */
        int startPosition   = 0;
        int endPosition     = input.length();

        /**
         * Try to replace one substring with another
         */
        replaceStringBuffer(input, find, strReplaceWith, startPosition, endPosition);

        //
        Debugger( DEBUG, "replaceStringBuffer (three parms) ends...");

        return;
    }


    /** The main method(automatically invoked by JVM) that
    * creates String and StringBuffer objects and
    * performs search and search & replace.
    */
    public static void main (String[] args)
    {

        // test string.
        String quote="To be or not to be";

        // search "be" between 0 and 12
            System.out.println("# of 'be' between 0 and 12 : " + findString(quote,"be",0,12));
            System.out.println();

        // search "be" on the entire string.
            System.out.println("Total # of 'be': " + findString(quote,"be"));
            System.out.println();

        // another test string.
        quote="aaaa";

        // search "aa" on the entire string.
            System.out.println("Total # of 'aa': " + findString(quote,"aa"));
            System.out.println();


        // test string buffer
        StringBuffer line1= new StringBuffer("How are you my friend, How is everyone, How is John?");

        System.out.println("Before Replacement of 'How' with 'Where' between 0 and 26:");
        System.out.println(line1);
        System.out.println();

        // replace "How" with "Where" between 0 and 26
            replaceStringBuffer(line1,"How","Where",0,26);

        System.out.println("After Replacement of 'How' with 'Where' between 0 and 26:" );
            System.out.println(line1);
            System.out.println();

        // another test string buffer.
        StringBuffer line2= new StringBuffer("Would you help me with my homework John, would you John? Why not John?");

        System.out.println("Before All Replacement of 'John' with 'Larissa':");
            System.out.println(line2);
            System.out.println();

        // replace "John" with "Larissa" on the entire string butter.
            replaceStringBuffer(line2,"John","Larissa");

        System.out.println("After All Replacement of 'John' with 'Larissa':");
            System.out.println(line2);
            System.out.println();

        // another test string buffer.
        line2= new StringBuffer("Would you help me with my homework John, would you John? Why not John?");

        System.out.println("Before All Replacement of 'o' with 'oo' :");
            System.out.println(line2);
            System.out.println();

        // replace "o" with "oo" on the entire string buffer.
            replaceStringBuffer(line2,"o","oo");

        System.out.println("After All Replacement of 'o' with 'oo' :");
            System.out.println(line2);
            System.out.println();

        // another test string buffer.
        line2= new StringBuffer("Would you help me with my homework John, would you John? Why not John?");

        System.out.println("Before All Replacement of 'John' with 'Jay' :");
            System.out.println(line2);
            System.out.println();


        //replace "John" with "Jay" on the entire string buffer.
            replaceStringBuffer(line2,"John","Jay");


        System.out.println("After All Replacement of 'John' with 'Jay':");
        System.out.println(line2);
        System.out.println();

        line2= new StringBuffer("Would you help me with my homework Barbara,Barbara would you? Why not Barbara?");

        System.out.println("Before All Replacement of 'Barbara' with 'Jay' :");
        System.out.println(line2);
        System.out.println();


        //replace "Barbara" with "Jay" on the entire string buffer.
        StringUtility2.replaceStringBuffer(line2,"Barbara","Jay");


        System.out.println("After All Replacement of 'Barbara' with 'Jay':");
            System.out.println(line2);
            System.out.println();
    }

}


