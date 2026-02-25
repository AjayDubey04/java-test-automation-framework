package variables;

public class Variable_Import {

	
	public static String take=Instance_V.Take_Return(); // i am taking return of non static variable method //
	
	public static void main(String[] args) {
		
		Static_Return();
	    Access();
		System.out.println(take);
	}

	public static void Access() {
		
		System.out.println(Static_V.a);
		
		Instance_V obj=new Instance_V();
		System.out.println(obj.name);
	
	}
	
public static int Static_Return() {
	
	System.out.println(	Static_V.num);
	
	Static_V.num=500;
	System.out.println(Static_V.num);
	 return Static_V.num;
  
}
public  String Non_Static_Return() {
	
	Instance_V obj=new Instance_V();
	System.out.println(obj.name);
	obj.name="java";
	System.out.println(obj.name);
	return obj.name; 
}
}

