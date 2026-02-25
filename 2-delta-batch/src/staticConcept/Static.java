package staticConcept;


public class Static 
{
	
//	  Static variable //
//	Static variable loads with class and he does not give free Ram
	
	public static String name;      //        --default value -- null        
	public static int num;          //       -- 0 --
	public static double dbl;      //         -- 0.0 --
	

public static void main(String[] args) 
{
	System.out.println(Static_Return.Return());
	
//  -- without initialization we can use of static variable. he will give default value --
	
System.out.println(num);
System.out.println(dbl);
System.out.println(name);

System.out.println();
dbl=3456.456;
Hii();

System.out.println();
name="java";
one();
num=60;
test();
	
}
	
public static void one()
{
//	a,b,c is local variable of one method 
	
	System.out.println(name);
	 int a=5;
	 String b="5";
	double c=5.5;
	System.out.println(a+b+c); // -- concatenation
	
}
public static void test()
{
	System.out.println(num);
	
	System.out.println();
	 name="ABC";
	 Hii();
}
public static void Hii()
{
	System.out.println(name);
	System.out.println(num);
	System.out.println(dbl);
//	test();
}
}
