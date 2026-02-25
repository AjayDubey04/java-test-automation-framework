package encapsulation;

public abstract class Abstraction  implements Subclass  {

	String str;

	 abstract  void  main();
	
	 void m1() {
		 System.out.println("non static method of Abstract Class");
	}
	
	public static void m2() {
		 System.out.println("public method of Abstract Class");
	}
	
	private void m3() {
		 System.out.println("private method of Abstract Class");
		
	}
	
	public static void main(String[] args) {
		
	}
	
	
}


interface Subclass  {

	
	public abstract  void  inter();

	public abstract  void  inter1();	

	public static void main(String[] args) {


	}
}


class TestAbstraction extends Abstraction{

	@Override
	public void inter() {
		// TODO Auto-generated method stub
		System.out.println("TestAbstraction @Override inter method ");
	}

	@Override
	public void inter1() {
		// TODO Auto-generated method stub
		System.out.println("TestAbstraction @Override inter1 method ");
	}

	@Override
	void main() {
		// TODO Auto-generated method stub
		System.out.println("TestAbstraction @Override main method ");
	}
	
	public static void main(String[] args) {
		TestAbstraction obj=new TestAbstraction();
		obj.inter();
		System.out.println(obj.str);
		
		Subclass obj1=new TestAbstraction();
		obj1.inter();
		
		Abstraction obj2=new TestAbstraction();
		obj2.m1();
		obj2.inter();
	}
	
	
}
