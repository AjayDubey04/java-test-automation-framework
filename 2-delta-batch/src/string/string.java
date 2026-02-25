package string;

public class string 
{
public static void main(String[] args) 
{
	st1(); 
	System.out.println();
	
	st2();
	System.out.println();
	
	st3();
	System.out.println();

}
public static void st1() 
{
String a="HEllo";
String b="java";
char d=97;
String c=a+b+d;
System.out.println("Frist number = "+a);
System.out.println("Second  number = "+b);
System.out.println("Third  number = "+d);
System.out.println("Addition of three number = "+c.length());

}
public static void st2() 
{
	String e="60";
	String f="Hello";
	System.out.println(e+f);
}

public static void st3()
{
	 String a="Hii";
	 String b="Hello";;
	 if (a==b) {
		 System.out.println(a);}
	 else
	     if (b==b) {
		 System.out.println(b);}
	 
	 }

public static void Buffer() 
{
	 String A="java programme";
   StringBuffer obj=new StringBuffer(A);
   System.out.println(obj.reverse());
   
}


public static void print() 
{ 
	// String is a class
	// "+" means concatenation in String
	// a, b, name is local variable of print method
	// we can keep numeric number in string
	// hello is  String value
	// String will be take 8 byte
	
	String a="Hello";    
	String b="Ajay";
	String name=a+" "+b;
	System.out.println(name);
			
			
}	

public static void Name()
{
	String num=new String ("java"); // String object //
	String num1=new String ("java");
	
	            
//	if (num.contains(num1)){       //  check content 
//	if (num.equals(num1)) {	      //  even it will check content
	
	if(num==num1) {              // check address due to new keyword
		System.out.println("True");
		}
	
	else {
		System.out.println("false");
	
	}
}

public static void object()
{
	String a="java";
	String b="practice";
	
	String str=a.concat(b); // String method //
	System.out.println(str); // concatenation //
	
	String c=a+b;    // concatenate //
	System.out.println(c);
	
}

}			
	
