package array;

public class practice {
	
	String str;
	
	static int   m1() {
		System.out.println("Hello");
		return 5;
	}
	
	public static void main(String[] args) {
		
	}
	
}
class hye extends practice
{
	
	String st;
	
	
	int  m1(int a) {
		super.m1();
		System.out.println("Hii");
		return 5;
	}
	
}

class result{
	
	public static void main(String[] args) {
		hye a=new hye();
		a.m1();
	}
}