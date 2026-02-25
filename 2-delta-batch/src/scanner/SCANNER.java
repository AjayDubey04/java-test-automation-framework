package scanner;

import java.util.Scanner;

public class SCANNER {

	public static void main(String []args)
	{

		System.out.println("What is your name");
		Scanner sc=new Scanner (System.in);
		String name=sc .next();
		System.out.println("Hello "+ name);

		{
			System.out.println();

			System.out.println("Where are you form");
			Scanner b= new Scanner (System.in);
			String sum=b.next();
			System.out.println("i am from "+sum);

			{
				System.out.println();


				System.out.println("What is best colour");

				Scanner c= new Scanner (System.in);
				String num=c.next();
				System.out.println(num+" is my best colour");
			}

			System.out.println();

			System.out.println("Enter your table");
			Scanner sca=new Scanner (System.in);
			int table=sca.nextInt();
			for(int i=1; i<=10; i++)
				System.out.println(table+"x"+i+"="+(table*i));

			System.out.println();
			args(); 

		}
	}
	public static void args() 
	{
		System.out.println("Enter Number");

		Scanner sc=new Scanner (System.in);

		int  a=sc.nextInt();
		int  b=sc.nextInt();
		int  c=sc.nextInt();
		for(int i=1; i<=1; i++)
			if(a==10) {
				System.out.println("p");}

			else {
				System.out.println("A");}

		if(b==20) {
			System.out.println("p");}

		else {
			System.out.println("A");}

		if(c==30) {
			System.out.println("p");}

		else {
			System.out.println("A");
		}
	}

}

