package staticPractice;

public class Block {
	
	{
		method();
	}
   
	public void method(){
	System.out.println(num);
	}
	int num=10;
	
	public static void method2() {
		System.out.println(j);
	}
	
	static{
		method2();
	}
	static String j="Hii";
	
	public static void m1() {
		
		System.out.println(i);
	}
	static {
		m1();
	}
	static int i=5;
	
	public static void main(String[] args) {
		
		new Block();
		System.out.println(j);
		System.out.println(new Block().num);
		System.out.println(i);
	}
}
