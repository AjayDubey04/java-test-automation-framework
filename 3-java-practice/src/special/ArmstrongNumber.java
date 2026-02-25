package special;

import java.util.Scanner;

public class ArmstrongNumber {
	
	
public static void main(String[] args) {
	
	int num,arm=0,rem,org;
	Scanner sc=new Scanner(System.in);
	num=sc.nextInt();
	org=num;
	
	for(int i=0; num!=i; i++) {
		rem=num%10;
		arm=(rem*rem*rem)+arm;
		rem=rem/10;
	}
	
	if(org==arm) {
		System.out.println(" Armstrong Number");
	}else {
		System.out.println("Not Armstrong Number");
	}
	
	
} 

	
	

}
