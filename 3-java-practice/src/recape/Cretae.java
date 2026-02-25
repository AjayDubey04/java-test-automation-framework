package recape;

public class Cretae {


	public static void main(String[] args) {

		Cretae obj=new Cretae();
		obj.length("fghj 14");
		obj.upper("ajay");
		obj.lowwer("DUBEYJI");
		
	}
	public  void length(String count) {
		
		int num=count.length();
		System.out.println(num);

	}
	public void upper(String a) {
		
		String b;
		b=a.toUpperCase();
		System.out.println(b);
		
	}
	public void lowwer(String a) {

		String b;
		b=a.toLowerCase();
		System.out.println(b);

	}
}
