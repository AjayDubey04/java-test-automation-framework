package SuperThis.keyword;

public class SuperKeyword {

	public int PARENT_V;
	public static String PARENT_STR="Hello Parent";

	public SuperKeyword(){
		System.out.println("Hello parent non parameterize constructor");
	}

	public SuperKeyword(int a){
		System.out.println("Hello parent  parameterize constructor");
	}

	public void parentMethod1() {
		System.out.println("Hello parent Method1");
	}


	public static void main(String[] args) {

	}

}


class ChildClass extends SuperKeyword {

	public ChildClass() {
		System.out.println("hello child non parameterize constructor");
	}

	public ChildClass(String obj) {
		super(5);
		System.out.println("hello child  parameterize constructor");
	}


	{
		System.out.println(super.PARENT_V);
		super.parentMethod1();
		System.out.println(super.PARENT_STR);
	}



	public static void main(String[] args) {

		ChildClass obj=new ChildClass();

	}
}