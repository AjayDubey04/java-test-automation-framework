package object;

public class Object_Karo {

	
	static Object_Karo obm=new Object_Karo();
	static Object_Karo xyz;
	Object_Karo abc;
	
	static String nam;
	String name;
	
	public  Object_Karo m1() {
		
		System.out.println("Hello");
//		System.out.println(obm.m1()); -- stack overflow
		Object_Karo obj=new Object_Karo();
		return obj;
	}
	
	public static void main(String[] args) 
	{
		obm.m1();
		System.out.println(xyz);
		System.out.println(xyz.nam);
		Object_Karo ob=new Object_Karo();
		Object_Karo obj=ob.m1();
		System.out.println(obj);
		System.out.println(ob.abc);
		System.out.println(obj.name);
		obj=null;
		System.out.println(obj.xyz);
//		System.out.println(obj.m1()); -- null pointer error
//		System.out.println(obj.abc); -- null pointer error
//		System.out.println(xyz.name); -- null pointer error 
//		xyz.m1(); -- null pointer error
	}

}
