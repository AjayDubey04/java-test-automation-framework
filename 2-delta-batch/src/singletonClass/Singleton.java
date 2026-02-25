package singletonClass;

public class Singleton {
	
	private static Singleton str;
	
	private Singleton() {
		System.out.println("Singleton Private Constructor");
	}
	
	public static Singleton getter() {
		
		if(str==null) {
			str=new Singleton();
		}
		
		return str;
		
	}
	
}
