package importe;

public class Import_2 {

	String a;
	static int b;
	public static void main(String[] args) {
		
  System.out.println(b);
   b=5;
   Import_2 obj=new Import_2();
   System.out.println(obj.a);
		obj.a="hi..";
		
		
	}
	public static void test() {
		
		System.out.println(b);
		String a="Hello";
		String b="java";
	    String str=a.concat(b);
		System.out.println(str);
		System.out.println(b);
	}
public static void test_2() {
	
	int i=50;
	int j=50;
	int k=i+j;
	System.out.println(k);
}
}
