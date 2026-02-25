package variables;

public class Variable_Type_Concept 
{

//	we can make class object of static variable //
	public static String a;                // Static variable -- default value -- null //
	public int b;                         //  instance variable -- default value -- 0  //
	
//	Automatic load with class //
	static {
	     	int x=5;
		System.out.println(x);
	}
	
public static void main(String[] args) 
{
//		there is scope of local variable inside method not outside method //
		
		int i=5+5;  // local variable //
		System.out.println(i);
		System.out.println(a); 
		
		a="Hello"; // assign value in static variable //
		Hii(); //  method call //
		
}

// non static variable //
int v=10;
	
public static void Hii()
{
//	we have to create class object for instance variable //
	
	 Variable_Type_Concept obj=new  Variable_Type_Concept();
	 System.out.println(obj.b);
	 
	 System.out.println(obj.a); // static variable with class object // 
	 System.out.println(obj.v);
}


}
