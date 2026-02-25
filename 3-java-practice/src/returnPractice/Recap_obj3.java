package returnPractice;

public class Recap_obj3 {

	Recap_obj3 xyz;
	Recap_obj2 vb;
	
	Recap_obj3() {
		System.out.println(xyz);
		System.out.println(vb);
		System.out.println("Frist constructor");
	}
	
	public int num;
	public String name;
	public static String hd;
	
	{
		String sd="Hello";
		hd=sd;
		System.out.println(hd);
		System.out.println(num);
		System.out.println(name);
	}
//	
	static {
		
		Recap_obj3 obj=new Recap_obj3();
		obj.num=50;
		
		Recap_obj3 objl=new Recap_obj3();
		objl.name="Hii";
	}
//	
	public static void main(String[] args) {
		
		
		Recap_obj3 obj=new Recap_obj3();
		obj.First(); 
//		obj.Fir
//		st_2();

	}
	
 public  void First() {
	
	new Recap_obj3();
	Recap_obj3 abc=null;
	System.out.println(abc);
}

public void First_2() {

	int a;
	a=5;
	{
System.out.println(a);
}
}}
