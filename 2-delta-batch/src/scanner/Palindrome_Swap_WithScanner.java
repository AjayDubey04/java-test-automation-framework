package scanner;

import java.util.Scanner;

public class Palindrome_Swap_WithScanner {

	public static void main(String[] args) {
		
		
		swap_scanner();
		Palindrome_scanner();
	}

	public static  void swap_scanner() {
		
		System.out.println("Swap Number");
		Scanner sc=new Scanner (System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println(a);
		System.out.println(b);
	}
	public static void Palindrome_scanner() {
		
		System.out.println("Palindrome Number");
		Scanner sc=new Scanner (System.in);
		int num=sc.nextInt();
		int a=num;
		int b=0;
		for(int i=1; num!=0; i++) {
		b=b*10+num%10;
		num=num/10;
		}
		System.out.println(b);
		if(a==b) {
			System.out.println("This is Palindrome Number");
		}
		else {
			System.out.println("This is Not Palindrome Number");
		}
	}
}
