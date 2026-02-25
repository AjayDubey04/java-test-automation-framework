package staticPractice;

public class Block_2 {

	public Block_2() {
		System.out.println(name);
		System.out.println("i am constructor");
	}
	
	public Block_2(int a){
		System.out.println(i);
		System.out.println(a);
	}
	
	public void m1() {
		System.out.println(i);
	}
	{
		m1();
	}
	int i=10;
	
	public static void Hii() {
		System.out.println(name);
	}
	static {
		Hii();
	}
	static String name="Hello";
	
	static {
		new Block_2(10);
		M2();
		System.out.println("Static red");
		M2();
	}
	public static void M2() {
		System.out.println("i am m2");
	}
	public  String M3() {
		 name="M3";
		 i=5;
		String b=name+i;
		return b;
	}
	public static void main(String[] args) {
		
		Block_2 obj=new Block_2();
       obj.m1();
       Block_2 obj1=new Block_2();
       String take=obj1.M3();
       System.out.println(take);
       
	}

}
