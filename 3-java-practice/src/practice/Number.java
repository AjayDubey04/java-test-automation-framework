package practice;

public class Number {
	
	static int a=1;
	int b=2;
	static {
		m1();
		System.out.println(a);
		System.out.println(a);
	}

	{
		m2();
		System.out.println(a+" "+b);
	}
	static int e=5;
	public static void m1() {
		System.out.println(a);
		System.out.println(d);
		System.out.println(e);
	}
	static {
		m1(); m2();
		int c=3;
System.out.println(c);
	}
	static int d=4;
	public static void m2() {
		System.out.println(d);
	}
	
	static {
		m2();
	}
	
	{
		m1(); m2();
	}
	static {
		m1(); m2();
	}
	
	public static void main(String[] args) {
		m1();
		m2();
		 Number obj=new Number();
	}

}
