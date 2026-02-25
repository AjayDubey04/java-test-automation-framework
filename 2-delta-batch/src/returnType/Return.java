package returnType;

public class Return {

	public static void main(String[] args) {
		
		String take=Type();
		String add=take+" Version";
		System.out.println(add+"\n");
		
		
		Return obj=new Return();
		int tke=obj.Type_2();
		System.out.println(tke+"\n");
		
		
		String tk=Type_3(50, 25, " java");
		System.out.println(tk+"\n");
		
		
		int loop=loop_return();
		System.out.println(loop);
	}
	
public static String Type() {
	
	String name="Hello ";
	String sum="Java ";
	int num=5;
	String add=name+sum+num;
	return add;
	
}
public int Type_2() {
	
	int a=5;
	int b=5;
	int c=a+b;
	System.out.println("First number = "+a);
	System.out.println("Second number = "+b);
	System.out.println("Add two number = "+c);
	return c;
	
}
public static String Type_3(int a,int b, String name) {
	
	String add=a+b+name;
	return add;
}
public static int loop_return() {
	
	int i;
	for(i=1; i<=5; i++) {
	}
	return i;
}
public static void condition() {
	
	
}
	}
	
	

