package condition;

import java.util.Scanner;

public class Condition_Practice {

	public static void main(String[] args) {
		
//		swich();
//		Case();
//		If_Else();
		Switch_case();
		Condition();
		Condition_2();
	
	}
	public static void If_Else() 
	{
		System.out.println("Ho rha h");
		Scanner sc=new Scanner (System.in); 
		
		int a=sc.nextInt();
		switch(a) {
		case (7):{
			System.out.println(a);
			break;
		}
		case 2:{
			System.out.println(a);
			break;
		}
		case 3:{
			System.out.println("Hello");
			break;
		}
		default :{
			System.out.println("unwanted");
			
		}
		}
	}
	public static void swich() 
	{
		int i=5;
		switch(i) {
		
		case 1:{
			System.out.println("one");
			break;
		}
		case 2:{
			System.out.println("two");
			break;
		}
		case 3: {
			System.out.println("three");
			break;
		}
		default:{
			System.out.println("Unaxpected value "+i);
		}
	}
	}
	public static void Case() {
		
		String a="Hii";
				
		switch(a) {
		
		case "Hii":{
			System.out.println("First");
			break;
		}
		
		case " Hello":{
			System.out.println("Second");
			break;
		}
		case " By":{
			System.out.println("Final");
			break;
		}
		
		default :{
			System.out.println("Unexpected");
		}
		}
	}
	public static void Switch_case() {
		
		int a=3;
		char b='a';
		String c="Hello";
		switch(a) {
		case 2:System.out.println("2");
		case 3:System.out.println("3");
		case 'a':System.out.println("a");
		case 'b':System.out.println(b);
        default :System.out.println("Unwanted");	
	}
}
	public static void Condition() {
		 
		 for(int i=1; i<=100; i++) {
			 
			 if(i==11) {
				 System.out.println();
			 }
			 if(i==21) {
				 System.out.println();
			 }
			 if(i==31) {
				 System.out.println();
			 }
			 if(i==41) {
				 System.out.println();
			 }
			 if(i==51) {
				 System.out.println();
			 }
			 if(i==61) {
				 System.out.println();
			 }
			 if(i==71) {
			 System.out.println();
			 }
			 if(i==81) {
				 System.out.println();
			 }
			 if(i==91) {
				 System.out.println();
			 }
			 if(i==101) {
				 System.out.println();
				 }
				 else {
					 System.out.print(" "+i);
				 }
			 }
}
public static void Condition_2() {
	 
	 System.out.println();
	 for(int j=2; j<=10; j++) {
		 System.out.println();
		 if(j==2) {
		 for(int i=1; i<=10; i++) 
		 System.out.print(" "+2*i);
		 }
		 if(j==3) {
			 for(int i=1; i<=10; i++) 
			 System.out.print(" "+3*i);
			 }
		 if(j==4) {
			 for(int i=1; i<=10; i++) 
			 System.out.print(" "+4*i);
			 }
		 if(j==5) {
			 for(int i=1; i<=10; i++) 
			 System.out.print(" "+5*i);
			 }
		 if(j==6) {
			 for(int i=1; i<=10; i++) 
			 System.out.print(" "+6*i);
			 }
		 if(j==7) {
			 for(int i=1; i<=10; i++) 
			 System.out.print(" "+7*i);
			 }
		 if(j==8) {
			 for(int i=1; i<=10; i++) 
			 System.out.print(" "+8*i);
			 }
		 if(j==9) {
			 for(int i=1; i<=10; i++) 
			 System.out.print(" "+9*i);
			 }
		 if(j==10) {
			 for(int i=1; i<=10; i++) 
			 System.out.print(" "+10*i);
			 }
	 }
}
}



	
	
