package object.practice;



public class Return_2 {

	int b=10;
	static String name;
	 Return_2(int a){
		b=a;
		System.out.println(a);
		System.out.println(b);
	}
	String c="Hello";
	{
		name=c;
		System.out.println(b);
		System.out.println(c);
	}
	
	public static void main(String[] args) {
		
		Return_2 obj=new Return_2(5);
//       obj.b=100;
//       obj=new Return_2(5);
//       name="Hi..";
//       new Return_2(100);
      
	}

}
