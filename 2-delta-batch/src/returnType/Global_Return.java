package returnType;

public class Global_Return {

	static String nam;
	static int ik;
	
	String name;
	int num;
	
	public static String turn() {
		System.out.println(nam);
		System.out.println(ik);
		nam="i am String static";
		ik=75;
		nam=nam+ik;
		return nam;
	}
	public static void main(String[] args) {
		
		String take=turn();
		System.out.println(take);

		Global_Return obj=new Global_Return();
		  String tke=obj.Non();
		System.out.println(tke);
	}
public String Non() {
	System.out.println(name);
	System.out.println(num);
	
	name="Hello";
	num=5;
	name=name+num;
	return name;
}
}
