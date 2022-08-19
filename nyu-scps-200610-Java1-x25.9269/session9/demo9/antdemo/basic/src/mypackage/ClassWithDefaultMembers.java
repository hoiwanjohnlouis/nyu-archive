package mypackage;

import java.util.Date;

public class ClassWithDefaultMembers {
	int random = (int) (Math.random()*100);
	Date getDate(){
		return new Date();
	}
}
