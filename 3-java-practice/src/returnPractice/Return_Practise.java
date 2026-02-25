package returnPractice;

public class Return_Practise 
{
	public static String a;
	
public static void main(String[] args)
{
	String Take=Global();
	System.out.println(Take);
	
	Take="Hello";
	System.out.println(Take);
	 
	System.out.println();
	Argu();
	
	int take=Argu(567,456,"Hello");
	int check=take*2000;
	System.out.println(check);
}

public static void Argu()
{
	int a=300;
	int b=40;
	
	int c=Meter(a, b);
	int v=c*2000;
	System.out.println(v);
	
	Meter(325, 50);
	Meter(200, 60);
	
}
	
public static int Meter(int x, int y)
{
		int perimeter=2*x+y;
		System.out.println( perimeter);
	return perimeter;
	
	
}
public static int Argu(int a, int b, String name)
{

	int c=a+b*2;
	name="value ";
	System.out.println(name+c);
	return c;
	
	
}
public static String Global()
{
	System.out.println(a);
	return a;
}

	}
	
	
	
	
	
