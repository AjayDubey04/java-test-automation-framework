package staticPractice;

public class V_Tiger {

	int a=5;
	static String b="Hii";
	
	public static void main(String[] args) {
		
		digital();
		System.out.println("hello sir");
		
//		System.out.println(b);
//		
//		V_Tiger obj1=new V_Tiger();
//		System.out.println(obj1.a);
//		
//		b="Hello";
//		obj1.a=10;
//		
//		V_Tiger obj2=new V_Tiger();
//		System.out.println(obj2.a);
//		System.out.println(b);
//		
//		obj2.a=20;
//		System.out.println(obj2.a);
//		
//		V_Tiger obj3=new V_Tiger();
//		System.out.println(obj1.a);
		
	}
	public static void digital() {
		
		int num=58556;
		int rem;
		int add=0;
		while (num<0) {
	
			rem=num%10;
			add=add+rem;
			num=num/10;
		}
		System.out.println(add);
		
		
	}

}
