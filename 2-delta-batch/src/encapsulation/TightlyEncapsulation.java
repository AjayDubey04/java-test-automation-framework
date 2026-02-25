package encapsulation;

public class TightlyEncapsulation {

	private void fun() {
		System.out.println(" First Method ");
	}

	private void fun1() {
		System.out.println(" Second Method ");
	}

}


class TightlyEncapsulation_1 extends TightlyEncapsulation {

	public  void main() {
		System.out.println(" First Method ");
		main1();
	}

	private void main1() {
		System.out.println(" Second Method ");
	}

}	

class TightlyEncapsulation_2 extends TightlyEncapsulation_1 {


	private String str="Sub Class";

	public static void main(String[] args) {

		TightlyEncapsulation_2 obj=new TightlyEncapsulation_2();
		System.out.println(obj.str);
		obj.main();
	}


}

