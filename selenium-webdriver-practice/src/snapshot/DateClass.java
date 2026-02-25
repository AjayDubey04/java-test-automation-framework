package snapshot;

import java.util.Date;

public class DateClass {
	
	
	
	public static void main(String[] args) {
		
		DateClass obj=new DateClass();
		obj.dateClassPractice();
	}
	
	
	public void dateClassPractice() {
		
		Date obj=new Date();
		System.out.println(obj.getTime());
		System.out.println(obj.getTimezoneOffset());
		System.out.println(obj.getDate());
		System.out.println(obj.getDay());
		System.out.println(obj.getHours());
		System.out.println(obj.getMinutes());
		System.out.println(obj.getMonth());
		System.out.println(obj.getSeconds());
		System.out.println(obj.getYear());
		
	}
	
	public static void dateClass() {

		Date obj=new Date();
		System.out.println(obj.getTime());

	}

}
