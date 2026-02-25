package object.practice;

public class ObjectPractice {
	
	ObjectPractice() {
		System.out.println("Constructor");
	} 
	
	ObjectPractice(String a)  {
		System.out.println(a); 
		}
	
	 ObjectPractice(int a){
		 System.out.println(a);
	 }
	
 static	{
		System.out.println("static block");
	}
 
       {
			System.out.println(name);
			System.out.println("Non Static Block");
		}
		
	public static String name="Hi..";
	public String a;
	public int b;
	
	public void main() {
			
		new ObjectPractice();
		System.out.println(b);
		test();
	}
	
	static{
		
		new ObjectPractice("Other");
	}
	
	public static void main(String[] args) {
		
		
		new ObjectPractice().main();
		System.out.println(new ObjectPractice("Java_2").a);
		
	}

{
	int a=5,b=5;
	System.out.println(a+" "+b);
}	
	
 public  void test() {
	 
	new ObjectPractice("java");
	System.out.println("Hello");
	
}
}
