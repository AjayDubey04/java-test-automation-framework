package practice;

public class Check {

	static{
		Check a=new Check();
		a.m1();
	}
	static int i=1;
	static{
		System.out.println(i);
	}
	static int j=5;
	{
	System.out.println(j);	
	}
	
	public void m1() {
		System.out.println(i+" "+j);
		System.out.println(j);
	}
	public static void main(String[] args) {
		
		System.out.println(i+" "+j);
		new Check();
	}
	{
		m1();
	}
}
