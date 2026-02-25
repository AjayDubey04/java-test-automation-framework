package object;

public class Object_Concept {

//	Non static loaded with object //
	public int m; 
	public int n;
	
//	static loaded with class //
	public static int o;
	
	public static void main(String[] args) {
		
		
//		System.out.println(o); // we can use directly // -- static
//		System.out.println(m); // we can not use directly -- non static
		
		
		Object_Concept t=new Object_Concept();
//		t.m=100;
		t.o=200; // -- static variable
		Object_Concept a=new Object_Concept();
		t.m=100; // -- instance variable 
		System.out.println(a.m);
		
		Object_Concept k=new Object_Concept();
		System.out.println(k.o);
		
//	String	jl=new Object(); // -- Wrong
//	Object jk=new Object();	 // -- Right
		
	 Object_Concept e=null;
	 System.out.println(e);
//	 String v=null;
//	 System h=null;
	
		
		
		Object_Concept take=new Object_Concept();
		take=null;
		System.out.println(take);
		new Object_Concept();
		new Object_Concept();
		take=new Object_Concept();
		System.out.println(take);
		System.out.println(new Object_Concept());
		

	}

}
