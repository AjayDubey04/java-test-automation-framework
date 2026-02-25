package polymorphism;

public class Overloading {

	public void method(int num) {
		System.out.println(num);
	}

	public void method(String str) {
		System.out.println(str);
	}

	public void method(float flat) {
		System.out.println(flat);
	}

	public void method(double dbl) {
		System.out.println(dbl);
	}

	public void method(int num, String str) {
		System.out.println(num+" "+str);
	}


	public static void main(String[] args) {
     
		Overloading obj=new Overloading();
		 obj.method(10);
		 obj.method("java");
		 obj.method(5, "Hello Java");

	}


}
