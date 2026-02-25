package staticPractice;

public class Static_V {
	
static	{
		new Static_V();
	}
	 
//public void m1() {
//	System.out.println(i+" "+j);
//	
	static int i=1;
	static int j=5;
	
	public void m1() {
	System.out.println(i+" "+j);
	}	
	
//	{
//		m1();
//	}
	public static void main(String[] args) {
		
		System.out.println(i+" "+j);	
	}
	
	{
		m1();
	}

}
