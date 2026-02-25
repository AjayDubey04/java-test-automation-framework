package returnType;

public class Rturn_Value {

	
	static String c;
	static Rturn_Value a;
	int d;
	public static void main(String[] args) 
	{
		Rturn_Value obj =new Rturn_Value();
		obj.a=null;
		System.out.println(obj.a);
		System.out.println(obj.d);
		
		m2();
		int b=c1();
		System.out.println(b);
		System.out.println(c1()+c1());
		System.out.println(c1());

	}
public int m1(int x) 
{
	System.out.println("hi");
	int i=0;
	for( i=0; i<11; i++) {
		System.out.println(x*i);
	}
	return i;
}
public static void m2() 
{
	Rturn_Value a= new Rturn_Value() ;
		a.m1(10);
		System.out.println(a.m1(15));
	
}
public static int c1() 
{
	char c='a';
	System.out.println(c);
	return 20;
}
}
