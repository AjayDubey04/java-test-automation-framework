package polymorphism;

public class Overriding {
	
	public void preority() {
		System.out.println("preority method of Overriding class");
		
	}
	
	public void marry() {
		System.out.println("marry method");
	}
	
	public static void main(String[] args) {
		
	}
}



class Ride extends Overriding {
	
	public void preority() {
		System.out.println("preority method of Ride class");
	}
	
	public void seority() {
		System.out.println("seority method");
	}
}



class Third extends Ride {
	
	public void preority() {
		System.out.println("preority method of Third class");
	}
	
	public static void thirdMethod() {
		System.out.println("Third Name Method");
	}
	
	
}

class Result {
	
	public static void main(String[] args) {
		
		Overriding obj=new Overriding();
		obj.preority();  // it will be execute Overriding class method 
		
		Ride obj1=new Ride();
		obj1.preority();  //  it will be execute Ride class method 
		
		Overriding obj2=new Ride();
		obj2.preority(); // it will be execute Ride class method 
		
		
		Third obj3=new Third();
		obj3.preority(); // it will be execute Third class method 
		
		Ride obj4=new Third();
		obj4.preority();  // it will be execute Third class method 
		
		Overriding obj5=new Third();
		obj5.preority(); // it will be execute Third class method 
		
		
	}
	
}

