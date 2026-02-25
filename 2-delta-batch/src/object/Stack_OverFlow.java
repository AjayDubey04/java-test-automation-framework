package object;

public class Stack_OverFlow {

// this is Stack_Overflow condition //	
	
//	(1)
//	{
//		System.out.println("call method");
//		test();
//	}
//	public void test() {
//		System.out.println("i am test method");
//		new Stack_OverFlow();
//	}
	
	
// (2)	
//	{
//		new Stack_OverFlow ();
//		System.out.println("i am non static block");
//	}
	
// (3)	
//	Stack_OverFlow(){
//		
//		System.out.println("i am constructor");
//		new Stack_OverFlow();
//	}
	
//	(4)
	Stack_OverFlow abc=new Stack_OverFlow();
	static Stack_OverFlow ab=new Stack_OverFlow();
	static Stack_OverFlow a;
	
	public static void main(String[] args) {
//		 ab=null;
//		System.out.println(new Stack_OverFlow().ab);;
//		System.out.println(ab.abc);
//		System.out.println(a.a);
//        System.out.println("method");
        m2(); // -- stack overflow --
	}
	public static void m1() {
		System.out.println("Hi..m1");
		m2();
	}
	public static void m2() {
		m1();
	}
}

