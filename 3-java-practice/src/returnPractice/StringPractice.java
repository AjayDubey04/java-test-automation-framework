package returnPractice;

public class StringPractice {

	public static void main(String[] args) 
	{
//		Practice();
//		Practice_1();
//		ABC();
//		Star();
		
	}
	public static void Practice() {
		
    String name="Hello";
    String name1="Hello";
    
    System.out.println(name==name1);
    System.out.println(name.equals(name1));
    
    new String("java");
    
    String st=new String("Java");
    String str=new String("Java");
    System.out.println(st==str);
    System.out.println(st.equals(str));   
	
  
	}
	public static void Practice_1() 
	{
		String str[]= {"Hello"};
		System.out.println(str);
		char a[]= {'A','J','A','Y'};
		char b[]= {68,85,66,69,89};
		System.out.println(a);
		System.out.println(b);
		String obj=new String(a);
		System.out.println(a);
	}
	public static void Star() 
	{
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=i; j++) {
			System.out.print("* ");
			}System.out.println();
		}
	}
public static void ABC() {
	
	char ch='A';
	for(int i=1; i<=7; i++) {
		for(int j=1; j<=i; j++) {
		System.out.print(" "+ch++);
		}System.out.println();
		if(i==6) {
			ch--;
			ch--;
	}	
}
}
}
