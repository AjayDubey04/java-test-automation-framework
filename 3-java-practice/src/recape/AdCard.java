package recape;

import java.util.Random;
import java.util.Scanner;


public class AdCard {

	
	public static int aadharnumber;

	public static void Create() {
		
		System.out.println("creating aadhar");
	aadharnumber=new Random().nextInt(2000000000);
	
	String a=getname();
	System.out.println("Aadhar Name "+a);
	
	}
	
	public static String getname() {
		
		System.out.println("Use "+aadharnumber);
		Scanner sc=new Scanner (System.in);
		String aadharname=sc.next();
		return aadharname;
	
	}
	
	public static int a;
	public static double b;
	
	public static void main(String[] args) {
		
	
		
	System.out.println(a);
	System.out.println(b);
	Create();

	}

}
