public class TaxBracketTester {

    public static void main(String[] args) {

        //these blocks {} are little protection against using the
        // the same varible like tb1 again by accident down below
        {
        TaxBracket tb1 = TaxBracket.High;
        System.out.print("Name: " + tb1.name());
        System.out.println("\tValue: " + tb1.value());
        }
        {
        TaxBracket tb2 = TaxBracket.Low;
        System.out.print("Name: " + tb2.name());
        System.out.println("\tValue: " + tb2.value());
        }
    }
}
