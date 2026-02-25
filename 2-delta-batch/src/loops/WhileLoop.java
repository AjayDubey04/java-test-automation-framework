
package loops;

import java.util.Scanner;

public class WhileLoop {

	public static void main(String[] args) 
	{

		System.out.println();
		 Star();
		 
		 System.out.println();
		 print();
		 
		 System.out.println();
		 print_();
		
		 System.out.println();
		 Hii(); 
		 
		 System.out.println();
		 Hello();
		 
		 System.out.println();
		 While_Loop();
		 
	}
	
	

public static void While_Loop()
{
	int i=1;
	while(i<=10) {
		System.out.println("2*"+i+"="+2*i);
		i++;
	}
}
	public static void Hii() 
	{
		
		int i=1;
		while(i<=3) {
			int j=1;
			while(j<=2) {
				System.out.println(j);
				j++;
			}
			i++;
			}
	}
public static void Hello()
{
	int x=1;
	while(x<5) {
		System.out.println("Hello");
		x++;
	}
	}
		public static void print()
		{
			
			int i=1;
			while(i<=5) {
				int j=1;
				while(j<=i) { 
					System.out.print(" "+j);
					j++;
				}	
				System.out.println();
				i++;
				}
			}	
		
		public static void print_()
		{
			
			int i=1;
			while(i<=5) {
				int j=1;
				while(j<=i) { 
					System.out.print(" "+i);
					j++;
				}	
				System.out.println();
				i++;
			}
		}

public static void Star()
{
	
	int i=1;
	while(i<=5) {
		int j=1;
		while(j<=i) { 
			System.out.print(" *");
			j++;
		}	
		System.out.println();
		i++;	
	}
}
}			
		
	



