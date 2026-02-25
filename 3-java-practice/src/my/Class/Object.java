package my.Class;

public class Object {

	public static void main(String[] args) {
		
//		hii(" hii");
//		hii1(null);
//		m1() ;
//		m2();
		m3();
	}
public static void hii(String a) 
{
	System.out.println("String");
}
public static void hii1(String b) {
	
	System.out.println("System");
}
public static void m1() {
	
	int a;
	for(int i=1; i<=10; i++) {
		a=i;
		for(int j=1;j<=5; j++) {
			System.out.print(" "+a);
			a=a+a;
		}System.out.println();
	}
}
public static void m2() {
	
	for(int i=1; i<=5; i++) {
		int a=i;
		int c=0;
		for(int j=1; j<=i; j++) {
			System.out.print(" "+a);
			a=a+4;
			a=a-c;
			c++;
		}System.out.println();
	}
}
public static void m3() {
	int c=1;
	char a=90;
	for(int i=1; i<=5; i++) {
	for(int k=1; k<=5; k++) {
	System.out.print(" "+a--);
		}System.out.println();
			
	} 
		System.out.println(a--);
	}}

