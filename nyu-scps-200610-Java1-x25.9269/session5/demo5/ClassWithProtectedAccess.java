import java.util.Date;

import mypackage.ClassWithProtectedMembers;

public class ClassWithProtectedAccess extends ClassWithProtectedMembers {
	public int randomPlusFive = random+5;
	public boolean isFuture(Date anyDate){
		Date now = getDate();
		return now.after(anyDate);
	}
}
