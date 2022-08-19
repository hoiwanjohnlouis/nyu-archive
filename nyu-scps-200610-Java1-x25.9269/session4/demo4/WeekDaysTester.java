
public class WeekDaysTester {

	public static void main(String[] args){
		WeekDays today;
		today = WeekDays.Wednesday;
		System.out.println(today.name());
		if (today==WeekDays.Wednesday){
			System.out.println("Wednesday is good");
		}
	}
}
