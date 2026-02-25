package returnPractice;

public class Recap_obj2 {

	static Recap_obj2 abc;
	static Recap_obj3 xyz;
	
	public static void main(String[] args) {
		
		System.out.println(xyz);
//		Object_Para	obj=new Object_Para();
//		obj.m1();
//		System.out.println(obj.A);;
//		obj.mh();
//		 main();
}
	void m1() {
		System.out.println("java");
	}
void m2() {
	
	abc.m1();
	System.out.println("Hello");
}

public static void main() {
	
	Recap_obj2 obj=new Recap_obj2();
	obj.m2();
//	Fake abc;
//	abc=null;
//	obj.m2();
}
}
