package object;


public class Object_Value {

static int i;
int j;
static String str;
String ster;
	
public static void Value() {
	
	Object_Value ob=new Object_Value();
	ob.i=10;
	ob.j=5;
	ob.str="Hi..";
	ob.ster="Hello";
	
	Object_Value pq=new Object_Value();
//	pq=ob;
	pq.ster="Green";
	pq.j=50;
	System.out.println(pq.str);
	System.out.println(pq.i);
	System.out.println(pq.ster);
	System.out.println(pq.j);
	
	Object_Value ab=new Object_Value();
	
	ab.str="Red";
	ab.ster="Block";
	System.out.println(ob.str);
	System.out.println(ab.ster);
	System.out.println(pq.ster);
	System.out.println(ab.i);
}

public static void main(String[] args) {
	
	Value();
//	System.out.println();
//	Obj();
}
	
		public static String name="Hello"; // -- static variable --
//		String name="Hii ";  // -- instance variable --
		
		public static void Obj() {
			
			Object_Value  obj=new Object_Value ();
			Object_Value  obj2=new Object_Value ();
			Object_Value  obj3=new Object_Value ();
			
			System.out.println(obj.name);
			System.out.println(obj2.name);
			System.out.println(obj3.name);
			
			obj2.name="java";
			
			System.out.println(obj.name);
			System.out.println(obj2.name);
			System.out.println(obj3.name);
		
	}

}
