package singletonClass;

public class Doubleton {

	private static Doubleton first;
	private static Doubleton second;
	
	private  Doubleton () {
		System.out.println("This is private Doubleton Constructor ");
	}
	
	private  Doubleton (String str) {
		System.out.println("This is Parameterize private Doubleton Constructor ");
	}
	
	public static Doubleton setter() {
		
		if(first==null) {
			first=new Doubleton();
		}else 
			if(second==null) {
				second=new Doubleton("String");
			}
		
		return first;
		
	}
	
	
}
