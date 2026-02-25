package constructor;

public class Constructor {

	Constructor(){
		System.out.println("i am frist constructor");
	}
	Constructor(String a){
		System.out.println("i am parameterize costructer");
	}
	Constructor(int a){
		System.out.println("i am int type constructer");
	}
	Constructor(boolean name){
		System.out.println("i am logical costructer");
	}
	
	static {
		new Constructor(true);
		System.out.println("i am frist static block");
	}
	
	{
	  int i=1;
	  do {
		System.out.println("i am frist non static block");
		i++;
	}while(i<=2);
	}
	
	int a;
	public static void main(String[] args) {

		new Constructor();
		int i=1;
		while(i<=3) {
			System.out.print("No..");
			i++;
		}
		
		 Constructor obj=new Constructor();
		 obj.NonStaticMethod();
		 System.out.println(i);
		 new Constructor("java");
		 Static();
	}
	
	public static String name;
	
 public void NonStaticMethod() {
	
	new Constructor();
	
	for(int a=1; a<=3; a++) {
		for(int i=1; i<=a; i++) {
		System.out.print("*");
		System.out.println();
	}
}
 }
 
 public static void Static() {
	 
	  Constructor obj=new Constructor();
	 System.out.println(obj.a);
	 System.out.println(name);
}
}
