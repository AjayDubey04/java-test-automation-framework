package parameter.argument;

import variables.Static_V;

public class Self_Practice {

	int c=10;

	
	public static void main(String[] args) {
		
		
		System.out.println("This is Argument And Parameter");
		
		Self_Practice M=new Self_Practice();
		int d=M.argu(args,50,50);
		System.out.println(d);
		
		String take=para("45","15");
		String add=take+"15";
		System.out.println(add);
		
		M.Char('a','b');
		
	}
	public  int argu(String[] args, int a , int b) {
		
		System.out.println(c);
		int c=a+b;
		return c;
		
	}
	
  static String para(String a ,String b) {
	 
	  String str=a.concat(b);
	  return str;
	  
	  
 }
  void Char(char a, char b) {
	  
	  a++;
	  if(1<=5);
	  System.out.println(a+b);
	 
  }
  
  void Hii(){
	 System.out.println("Hello"); 
  }
}