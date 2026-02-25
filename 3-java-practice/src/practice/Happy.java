package practice;

public class Happy {

	Happy(){
		System.out.println("i am constucter");
	}
	Happy(int j){
		System.out.println("this is paramerteriz constucter");
	}
	{
		m1();
	}
	public  void m1() {
		System.out.println(i);
	}
	static int i=10;
	
	public static void main(String[] args) {
		
		new Happy();
		System.out.println("delhi is capital of india");
        new Happy(10);
        Happy obj=new Happy();
        obj.m2();
        m3();
	}
	String a="Hello";
public void m2() {
	 Happy obj=new Happy();
	System.out.println(a);
}
public static void m3() {
	System.out.println("this m3 method");
}
}