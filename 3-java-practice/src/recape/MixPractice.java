package recape;

import java.util.Scanner;



public class MixPractice {
	
	
	public void name() {
		 new MixPractice();
		//System.out.println("Hello");
	}
	{   //name();
		 new MixPractice();
		System.out.println("k");
	}

	public static void main(String[] args) 
	{
		
		
	
		
//		new  Test();
//		Add();
//		forloop();
//		fact();
//		While();
//		Do_while();
//		table();
		Calulatoer();
//		
	}
	public static void Add()
	{
		int a=5;
		int b=5;
		int c=a+b;
		System.out.println("First number = "+a);
		System.out.println("Second number = "+b);
		System.out.println("Addition of two number = "+c+"\n");
	}
	public static void forloop()
	{
		for(int a=1; a<=3; a++) {
			for(int i=1; i<=a; i++) {
			System.out.print(i+"\n");
		}
//			for(int k=1; k<=3; k++)
//				System.out.println(k++);
	}
		}
		public static void fact()
		{
			int a=1;
			for(int i=5; i>=1; i--) {
				 a=a*i;
			}
					System.out.println(a);
			
		}
		public static void While() {
			int i=1;
//			int j=1;
			while(i<=2) {
				int j=1;
				while(j<=i) {
					System.out.println(j);
					j++;
				}
				i++;
			}
		}
		public static void Do_while() {
			int i=1;
			do {
				int j=1;
				do {
					System.out.println("Hello"+j);
					j++;
				}while(j<=i);
	
				i++;
			}while(i<=5);
			
		}
		public static void table() {
			
			Scanner sc=new Scanner (System.in); 
			int i=1;
			int temp=sc.nextInt();
			for(i=1; i<=10; i++) {
				System.out.println(temp+"x"+i+"="+temp*i);
			}
		}
		
		public static void Calulatoer() {
			
			System.out.println("calcolater");
			Scanner sc=new Scanner (System.in);
			
			int num=sc.nextInt();
			String opr=sc.next();
			int num2=sc.nextInt();
			
			if(opr.equals("+")) {
				System.out.println(num+num2);;;;;}
			
			else ;
					
				if(opr.contains("-")) {
					System.out.println(num-num2); }
				
				else
					
					if(opr.contains("*")) {
						System.out.println("result = "+num*num2);  }
					
					else
						
						if(opr.contains("/")) {
							System.out.println("result = "+num/num2);
						}
				}
				
				
}

