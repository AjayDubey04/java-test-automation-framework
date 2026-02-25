package variables;

public class Instance_V {

//	This is NonStatic Variable Concept //
	
	public int num;
	public String name;
	public  double dbl;
	
	
	public static void main(String[] args) {

		Take_Return();
		Instance_V obj=new Instance_V();

//		System.out.println(obj.name);
		System.out.println(obj.num);
		System.out.println(obj.dbl+"\n");
		
		
		obj.num= 10;
		obj.dbl=5;
		obj.name="Hello";
		System.out.println(obj.num);
//		System.out.println(obj.name);
		System.out.println(obj.dbl);
		
		System.out.println();
		Non();
        
	}
//	Non static variable //
	public String a;
	
public static void Non() {
	
System.out.println(new Instance_V().a);
	
Instance_V obj=new Instance_V();
Instance_V obj2=new Instance_V();
Instance_V obj3=new Instance_V();

obj.a="Hii";
System.out.println(obj2.a);
obj2.a="object";
System.out.println(obj.a);
obj3.a="Hello";
System.out.println(obj3.a);

}
	public static String Take_Return() {
		
		Variable_Import	obj=new Variable_Import();
		String take=obj.Non_Static_Return();
		System.out.println(take);
		
		return take;
	}
}
