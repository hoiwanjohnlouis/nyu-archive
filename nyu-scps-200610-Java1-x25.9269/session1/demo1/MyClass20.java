public class MyClass20 {

	public static void main(String[] args) {
		int found = 0;
		int i=1;
        while(true){
            found = (int) (Math.random()*100);
            i++;
            if (found % 9 == 0){
                System.out.println("Try #:" + i + " Random number: " + found);
                break;
            }
            else{
            	continue;
            }
        }
	}
}
