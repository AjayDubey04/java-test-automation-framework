package special;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MaximumTimeInString {
	
	
	public static void main(String[] args) {
		
		String time="02:30:32";
		String time1="12:31:22";
		DateTimeFormatter formate= DateTimeFormatter.ofPattern("HH:mm:ss");
			LocalTime t=LocalTime.parse(time,formate);
			LocalTime t1=LocalTime.parse(time1,formate);
			if(t.isAfter(t1)) {
				System.out.println(time+" is greater then "+time1);
			}else {
				System.out.println(time+" is lower then "+time1);

			}
			
			/*
			 * int a=0; int b=1; System.out.print(a+","+b); 
			 * for(int i=0; i<5; i++){ int
			 * c=a+b; a=b; b=c; System.out.print(","+c); }
			 */
			
	}

}
