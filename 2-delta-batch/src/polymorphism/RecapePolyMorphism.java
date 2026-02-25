package polymorphism;

public class RecapePolyMorphism {
	
	private  String name;
	private int num;
	
	
	//   Method Hiding
	public static void hide() {
		System.out.println("methodHiding of  Xyz SuperClass");
	}

	//  Overriding 
	public void overrid() {
		System.out.println("Overriding of Xyz SuperClass");
	}

	
	public void setter(String name) {
		this.name=name;
	}
	public String getter() {
		return null;
	}
	
	

	//	 Overloaded
	public void jvm() {
		System.out.println("jvm");
	}

	public void jvm(int num) {
		System.out.println(num);
	}

	public void jvm(String str) {
		System.out.println(str);
	}


	public static void main(String[] args) {

	}
}



class RcapeUse extends RecapePolyMorphism {

	public static void hide() {
		System.out.println("methodHiding of Abc dirrivedClass");
	}


	public void overrid() {
		System.out.println(" Overriding of Abc dirrivedClass");
		
	}


	public static void main(String[] args) {

		RcapeUse obj=new RcapeUse();
		obj.hide();       // it will be execute Abc class method == ( methodHiding )
		obj.overrid();   // it will be execute Abc class method == ( overriding )

		RecapePolyMorphism obj1=new RcapeUse();
		obj1.hide();       // it will be execute Xyz class method == ( methodHiding )
		obj1.overrid();   // it will be execute Abc class method == ( overriding )

		hide();          // it will be execute Abc class method == ( methodHiding )
		RecapePolyMorphism.hide();     // it will be execute Xyz class method == ( methodHiding )
		
		RecapePolyMorphism obj2=new RecapePolyMorphism();
		obj2.overrid();  // it will be execute Xyz class method == ( overriding )
		
	}
}



class Check {

	public static void main(String[] args) {
		RecapePolyMorphism.hide();
		RcapeUse.hide();
	}
}
