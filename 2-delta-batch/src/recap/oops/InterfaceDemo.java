package recap.oops;

public interface InterfaceDemo {


	default void m4() {

	}

	private  void m2() {
		
	}


}


class A{

	protected void m() {

	}

}

class B extends A implements InterfaceDemo {

	protected void m3() {

	}


	 public void m() {


	}

	public static void main(String[] args) {

		InterfaceDemo obj=new B();
		
	}


}