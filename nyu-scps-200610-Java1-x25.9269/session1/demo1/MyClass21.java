public class MyClass21 {

	public static void main(String[] args) {
        int found = 0;
        int i = 0;
        int j = 1;
        start:
        while(true)
        {
            i = 1;
            System.out.println("Outer Loop # " + j++);
            for (; ; )
            {
                found = (int) (Math.random()*100);
                System.out.println("Inner Loop #:" + i++ + " Found Random number: " + found);
                if ((found % 9) == 0)
                {
                    System.out.println("Random number: " + found + " is divisable by 9");
                    if (j < 4)
                    {
                        continue start;
                    }
                    else
                    {
                        break start;
                    }
                }
                else
                {
                    System.out.println("Random number: " + found + " is no good");
                    continue;
                }
            }
        }
 	}
}
