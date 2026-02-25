package parameter.argument;

import importe.Import_2;

public class Export 
{
	
public static void ecp()
{
	System.out.println("This is a symbol");
	System.out.println("#");
	System.out.println("@");
}

public static void string()
{
	 String sc=new String ("Hello");
	 String ac=new String ("Hello");
	 
	 
	 String a="hii";
	 String b="hii";
      
	 String str=a.concat(b); // concatenation
	 
	 if(a==b) {
		 System.out.println(str);
	 }
	 else {
		 System.out.println("false");}
	 }


public static void city()
{
		System.out.println("Ajay");
		System.out.println("Dubey");
		System.out.println("Bhadohi");
		System.out.println("UP 66");

}
public static void main(String[] args) {
	
	Import_2.test_2();  // import package
	importe.Import_2.test_2(); // in one liner
}
}












