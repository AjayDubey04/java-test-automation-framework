package special;

import java.util.Scanner;

public class Tabale {

	public static void main(String[] args) {
		table();
		Table(); 


	}
	public static void table(){
		int i=1;	
		for(i=1; i<=10; i++)
			System.out.println(i+"x"+i+"="+i*2 + "  3*"+i+"="+i*3 + "  4*"+i+"="+i*4 + "  5*"+i+"="+i*5);

	}



	public static void Table() 
	{
		Scanner sc=new Scanner (System.in);
		int a=1;
		int b=sc.nextInt();
		while(a<=10) {
			System.out.println(b+"*"+a+"="+(a*b));
			a++;
		}
	}
}