package constructor;

public class Constructer_2 {
	
	Constructer_2()
	{
		System.out.println(a);
		int a= 5;
		int b=5;
		int c=a+b;
		System.out.println(c);
	}
	Constructer_2(String name)
	{
		System.out.println(name);
		System.out.println("this is parameterize");
	     }
	{
//		System.out.println(a);
		System.out.println("this is non static block");
		System.out.println(b);
	}
	public String a;
	public static String b;
	
	public  void m1() 
	{
		new  Constructer_2("Hey");
		System.out.println(a);
		a="Hello";
	    }
	public static void main(String[] args) 
	{
		Constructer_2 obj=new  Constructer_2();
		
		obj.m1();
		obj=null;
		System.out.println(obj.b);
//	   System.out.println(obj.a);
	    System.out.println(obj);
        }
        }
