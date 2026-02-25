package polymorphism;

public class MethodHiding {
	

	public static void methodOne() {
		System.out.println(" MethodHiding is Parent Class ");
	}

	public static void methodTwo() {
		System.out.println("methodTwo of Parent Class");
	}

	public static void methodThree() {
		System.out.println("methodThree of Parent Class");
	}

	public static void main(String[] args) {
		methodTwo();
		methodThree();
	}
}


class Hide extends MethodHiding {

	public static void methodOne() {
		System.out.println(" Hide is Child Class ");
	}

	
	public static void hideOne() {
		System.out.println(" hideOne of Hide Child Class ");
	}
	
	public static void main(String[] args) {
		methodOne();
		 hideOne() ;
		 Hide obj1=new Hide();
		 
	}
}



class Test extends Hide {
	
	public static void methodOne() {
		System.out.println(" Test is Child Class ");
	}
	
	public static void main(String[] args) {
		
		MethodHiding obj=new MethodHiding();
		obj.methodOne();  // it will be execute MethodHiding class method 
		
		Hide obj1=new Hide();
		obj1.methodOne(); // it will be execute Hide class method 
		
		MethodHiding obj2=new Hide();
		obj2. methodOne();  // it will be execute MethodHiding class method 
		
		Test obj3=new Test();
		obj3.methodOne();  // it will be execute Test class method 
		
		Hide obj4=new Test();
		obj4.methodOne();  // it will be execute Hide class method 
		
		MethodHiding obj5=new Test();
		obj5.methodOne();  //  it will be execute MethodHiding class method 
		
	}
	
}


