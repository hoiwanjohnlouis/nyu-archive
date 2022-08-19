//this class does not compile.
import java.util.Date;

import mypackage.ClassWithDefaultMembers;

public class ClassWithDefaultAccess extends ClassWithDefaultMembers {
	public int randomPlusFive = random+5;
	public boolean isFuture(Date anyDate){
		Date now = getDate();
		return now.after(anyDate);
	}
}
