package staticConcept;

public class Static_Object {

	Static_Object(){
		
		System.out.println("i am first constructer");
		System.out.println(name);
		System.out.println(num);
	}
	
	
	 static {
		 String name="Hello";
		System.out.println(name);
		System.out.println("i am static block");
		System.out.println("i am block");
	}
	
	static String name;
	static int num;
	
	public static void Static() {
		
		new Static_Object();
		System.out.println("i am static method ");
		
	}
	
	public static void main(String[] args) {
		
		Static_Object obj=new Static_Object();
		obj.Static();
		name="String null";
		num=5;
		System.out.println(obj.num);
		System.out.println(obj.name);

	}

}
