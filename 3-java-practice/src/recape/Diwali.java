package recape;

import java.util.Scanner;

public class Diwali {

	public static void main(String[] args) 
	{
		loop();
		System.out.println();
		Revers();
		System.out.println();
		 Fcat();
		 System.out.println();
		 star();
		 System.out.println();
		 table();
		 System.out.println();
		 Calculater(); 
		 System.out.println();
		 Para(50 ,75);
		 System.out.println();
		String take =Return();
		System.out.println(take);
		While();
		System.out.println();
		DoWhile();
		System.out.println();
		math();
		
		System.out.println();
		 Diwali ob=new  Diwali ();
		ob.Object();
		
		System.out.println();
		BlockAndConstructor();
	}
	public static void loop()
	{
		
    for(int i=1; i<=5; i++) {
	for(int j=1; j<=i; j++) {
		System.out.print(j);
	}
	System.out.println();
}}	
	public static void Revers() {
		int a=856;
		int b=0;
		for(int i=1; a!=0; i++) {
			int c=a%10;
			b=b*10+c;
			a=a/10;
		}
		System.out.println(b);
	}
	public static void Fcat() {
		
		int j=1;
		for(int i=10; i>=1; i--) {
			j=j*i;
		}
		System.out.println(j);
	}
	public static void star() {
		
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	public static void table() 
	{
		System.out.println("Table");
		Scanner sc=new Scanner (System.in);
		int temp=sc.nextInt();
		for(int i=1; i<=10; i++) {
			System.out.println(temp+"x"+i+"="+temp*i);
		}
	}
	public static void Calculater() 
	{
		System.out.println("Calculater");
		Scanner sc=new Scanner (System.in);
		int a=sc.nextInt();
		String opr=sc.next();
		int b=sc.nextInt();
		
		if(opr.equals("+")) {
			System.out.println(a+b);
		}
		else
		if (opr.equals("-")){
			System.out.println(a-b);
		}
		else
			if(opr.equals("*")) {
				System.out.println(a*b);
			}
			else
				if(opr.equals("/")) {
					System.out.println(a/b);
				}
			
			}
	public static void Para(int a,int b) {
		int c=a+b;
		int d=c*200;
		System.out.println(c);
		
	}
	public static String Return() {
		String name="Hello";
		String name1="Java";
		String v="Version";
		int a=18;
		String add=name+name1+v+a;
		return add;
				
	}
	public static void While() {
		int a=1;
	
		while(a<=5) {
			int b=1;
			while(b<=a) {
				System.out.print(a);
				b++;
			}
			System.out.println();
			a++;
		}
	}
	public static void DoWhile() {
		
		int i=1;
		do {
			System.out.println(i);
			i++;
		}while(i<=5);
	}
	public static void math() 
	{
		int a=5;
		int b=5;
		int c=a+b;
		System.out.println("First number = "+a);
		System.out.println("Second number = "+b);
		System.out.println("add two number = "+c);
	}
	public void Object() 
	{
		String a="Hello";
		String b="java";
		String str=a.concat(b);
		System.out.println(str);
		
	}
	
	Diwali(){
		System.out.println("this is Constructor");
		System.out.println(a);
		System.out.println(b);
	}

	{
		System.out.println(" this is non static block");
		System.out.println(b);
	}
	
	int a=5;
	static String b="Hello";
	static {
		System.out.println();
		System.out.println("this is a static block");
	}
	public static void BlockAndConstructor() {
		
		Diwali obj= new Diwali();
		System.out.println(obj.a);
		System.out.println(new Diwali().a);
		
	}
	}
















