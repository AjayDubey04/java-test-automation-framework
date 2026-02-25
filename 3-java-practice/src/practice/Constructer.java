package practice;

public class Constructer {

	Constructer(){
		System.out.println(b);
		System.out.println("this is constructer");
	}
	Constructer(int i){
		System.out.println(b);
		System.out.println(i);
		System.out.println("this is parameterize constucter");
	}
	
	static{ m1(); }
	
	{
		m1(); m2();
	}
	public static void m1() {
		System.out.println(b);
	}
	public void m2() {
		System.out.println(a+b);
	}
	int a=1;
	static int b=2;
	
	public static void main(String[] args) {
		Constructer obj=new Constructer();
		new Constructer(2);
		new Constructer().m2();
		System.out.println(new Constructer().a);

	}

}
