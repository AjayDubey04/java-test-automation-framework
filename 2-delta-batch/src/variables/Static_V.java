package variables;



public class Static_V {
	
//	static variable is knows as class variable // 
//	 This is Static Variable Concept //
	 
 public static int num;
public  static String name;

 static int a=test();
 

  
public static void Hii() {
	
	name="java";
	System.out.println(name);
	System.out.println(a);
}

	public static void main(String[] args) {
		
		Global_Return();
		System.out.println(name);
        System.out.println(num);	
        
		name="Hello";
		System.out.println(name);
		
    num=20;
 System.out.println(num);
   Hii();
   Object();
		
}
	public static int test() {
		int a=5;
		int b=5;
		int c=a+b;
		return c;
	}
	
	public static String add="hello";
	
	public static void Object() {
		
		System.out.println(add);
		System.out.println(add);
		System.out.println(add);
		
		Static_V obj= new Static_V ();
		Static_V obj1= new Static_V ();
		Static_V obj2= new Static_V ();
		
		obj.add="java";
		
		System.out.println(add);
		System.out.println(add);
		System.out.println(add);
	}
	
	
public static void Global_Return() {
	
	 int num=Variable_Import.Static_Return();  
	   System.out.println(num);
	
}
}