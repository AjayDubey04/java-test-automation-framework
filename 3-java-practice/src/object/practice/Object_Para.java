package object.practice;

import java.util.Scanner;

public class Object_Para {

	static String take=m3();

	Object_Para() {
		System.out.println("Hello");
	}
	

	   Object_Para(String a){
		System.out.println(a);
	}
	   public static String m3() {
		   System.out.println("Constructer");
		  Scanner sc=new Scanner (System.in);
		   String a=sc.next();
		   System.out.println(a);
		   return a;
	   }
	
	public String m1() {
		
		String a="Hi..";
		System.out.println(a);
		return a;
	}
	
	{
		m1();
		System.out.println("java");
	}
	public static void main(String[] args) {
	
		Object_Para	obj=new Object_Para();
        obj.Main();
       
	}
	
	int A;
	
 public  void Main() {
	 
	 m1();
	int b=5;
	System.out.println(A);
	System.out.println(b);
}
}
