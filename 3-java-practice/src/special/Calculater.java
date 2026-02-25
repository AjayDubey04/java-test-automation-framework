package special;

import java.util.Scanner;

public class Calculater {

	public static void main(String[] args) 
	{



	}

	public static void calculater_1()
	{

		System.out.println("Calculator Machine");
		Scanner sc=new Scanner (System.in);

		int a=sc.nextInt();
		String opr=sc.next();
		int b=sc.nextInt();


		if(opr.equals("+")) {
			System.out.println("Result = "+(a+b));
		}else
			if(opr.equals("-")) {
				System.out.println("Result = "+(a-b));
			}else
				if(opr.equals("*")) {
					System.out.println("Result = "+(a*b));
				}else
					if(opr.equals("/")) {
						System.out.println("Result = "+(a/b));
					}

	}

	public static void calculater_2() 
	{
		System.out.println("Addition Number");
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=a+b;
		System.out.println(a+b);
		{

			System.out.println("Subtraction Number");
			int i=sc.nextInt();
			int j=sc.nextInt();
			int k=i-j;
			System.out.println(k);
			{
				System.out.println(" multipliction Number");
				int d=sc.nextInt();
				int e=sc.nextInt();
				int f=d*e;
				System.out.println(f);
				{
					System.out.println("Divison Number");
					double x=sc.nextDouble();
					double y=sc.nextDouble();
					double z=x/y;
					System.out.println(z);

				}}
		}
	}
	public static void calculater_3()
	{
		System.out.println("calculater");

		String opr="";
		Scanner sc=new Scanner (System.in);
		int num1=sc.nextInt();
		opr=sc.next();
		switch(opr) {
		case "+":{
			int num2=sc.nextInt();
			System.out.println(num1+num2);
			break;
		}
		case "-":{
			int num2=sc.nextInt();
			System.out.println(num1-num2);
			break;
		}
		case "*":{
			int num2=sc.nextInt();
			System.out.println(num1*num2);
			break;
		}
		case "/":{
			int num2=sc.nextInt();
			System.out.println(num1/num2);	
			break;
		}
		case "%":
			int num2=sc.nextInt();
			System.out.println(num1%num2);
			break;


		}}
}








