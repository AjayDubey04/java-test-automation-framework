package returnPractice;

public class Recap_Obj4 {

	Recap_Obj4 abc;
	
	public static void m1() {
		System.out.println("Hello i am m1");
	}
	public static void m2() {
		System.out.println("i am m2");
		Recap_Obj4  obj=new Recap_Obj4 ();
		System.out.println(obj.abc);
		System.out.println(obj);
	}

	static Recap_Obj4 abz;
	Recap_Obj4 xyz;
	
	public static void m3() 
	{
	 Recap_Obj4 a=new Recap_Obj4();
	 System.out.println(a.abz);
	 System.out.println(a.xyz);
		a=null;
	 System.out.println(a.abz);
	 System.out.println(a.xyz);
	}
	
	public static void main(String[] args) {
		
		 Recap_Obj4 a=new Recap_Obj4();
		 a.abz=a;
		 System.out.println(a);
		 
		 System.out.println(abd);
			Recap_Obj4 obj=new Recap_Obj4();
	}
	static Recap_obj2 abd;
	
	{
		System.out.println(abc);
	}
	Recap_Obj4() {
		
		m2(5);
		System.out.println("java");
	}
	public void m2(int a) {
		m4();
		System.out.println("Hello");
	}
	public  void m4() {
		
		System.out.println("Hey constucter");
	}
}
