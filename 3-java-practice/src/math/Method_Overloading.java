package math;

public class Method_Overloading {

//	methods ki overloading 
	
	public static void main(String[] args) {
	
		add ();
        add(5);
	}
   
//	methods with different parameter signature 
//	number of parameter
//	type of parameter
//	sequence of parameter 
	
	public static void add() {
		
		System.out.println("This is a first add method ");
	}
	public static void add(int a) {
		
		System.out.println(a);
	}
	public static void add(int a,String name) {
		
		System.out.println(a+","+name);
	}
	public static void add(String name,int a) {
	
		System.out.println(name+","+a);
		
	}
	public static void add(String name) {
		
		System.out.println(name);
	}
}
