package inheritance;

public class Multilevel {


	private  void a_One() {
		System.out.println("a1");
	}

	public  void a_Two() {
		System.out.println("a2");
	}

	public  void a_Three() {
		System.out.println("a3");
		
	}
}


class ClassB extends Multilevel {

	public  void b_One() {
		System.out.println("b1");
	}

	public  void b_Two() {
		System.out.println("b2");
	}

	private  void b_Three() {
		System.out.println("b3");
	}
}


class ClassC extends ClassB {

	public  void c_One(){
		System.out.println("c1");
	}

	private  void c_Two() {
		System.out.println("c2");
	}

	public  void c_Three() {
		System.out.println("c3");
	}
	public static void main(String[] args) {

		ClassC obj=new ClassC();
		
//		ClassB obj1=new ClassB();
//		Multilevel obj2=new ClassC();
//		ClassB obj3=new ClassB();
//		Multilevel obj4=new ClassB();
//		Multilevel obj5=new Multilevel();
//		ClassB obj6=(ClassB) new Multilevel(); // [ down casting ]
		
	}
}



