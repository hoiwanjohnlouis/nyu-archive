package mypackage;

import java.util.Date;

public class ClassWithProtectedMembers {
	protected int random = (int) (Math.random()*100);
	protected Date getDate(){
		return new Date();
	}
}
