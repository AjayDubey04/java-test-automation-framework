package loops;

import java.util.Scanner;

public class DO_While_Loop 
{

	public static void main(String[] args)
	{
		
		do_while();
		System.out.println();
		
		Star();
		
		System.out.println();
		table();
	}
	
public static void do_while()
{
	 int i=1;
		do {
			
			System.out.println("Hello");
			i++;
		}while(i<=5);
		
}
public static void table()
{
	System.out.println(" Enter table");
	Scanner sc=new Scanner (System.in);
	int a=sc.nextInt();
	int i=1;
	do {
		System.out.println(a+"x"+i+"="+a*i);
		i++;
	}while(i<=10);
}

public static void Star()
{
	int i=1;
	do {
		int b=1;
		do {
			System.out.print("*");
			b++;	
		}while(b<=i);
		System.out.println();
		i++;
	}while(i<=5);
}
}

