package staticPractice;

public class RecapeSwapping {

	public static void main(String[] args) {

			
		RecapeSwapping obj=new RecapeSwapping();
	    obj.swap_1();
	    System.out.println();
		obj.swap_2();
		
	}
	
	
	public void swap_1() {
		
		int a=10;
		int b=20;
		int c;
		c=b;
		b=a;
		a=c;
		System.out.println("a = "+a);
		System.out.println("b = "+b);
	
		
	}
	
	public void swap_2() {
		
		int a=10;
		int b=20;
		a=a+b;
		b=a-b;
		a=a-b;
		
		System.out.println("a = "+a);
		System.out.println("b = "+b);
		
	}

}
