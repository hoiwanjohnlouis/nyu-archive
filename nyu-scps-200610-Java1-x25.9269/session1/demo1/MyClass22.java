public class MyClass22 {

	public static void main(String[] args) {
        int found = 0;
        char x = 'a';
        for(int i = 0; i < 20; i++)
        {
        	found = (int) (Math.random()*25);
        	char y = (char) (found + x);
            System.out.print("Character: " + y + " ");
            switch(y)
	        {
                case 'a':
                	System.out.println("vowel");
                    break;
		        case 'e':
		        	System.out.println("vowel");
                    break;
                case 'i':
                	System.out.println("vowel");
                    break;
                case 'o':
                	System.out.println("vowel");
                    break;
                case 'u':
                	System.out.println("vowel");
                    break;
                case 'y':
                	System.out.println("Sometimes a vowel");
                    break;
                case 'w':
                	System.out.println("Sometimes a vowel");
                    break;
                default:
                	System.out.println("consonant");
                    break;
      	    }
        }
 	}
}
