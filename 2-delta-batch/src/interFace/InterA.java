package interFace;

public interface InterA {

	  int A=5;
	
	public static void fun() {
    System.out.println(" public method of interface ClassA");
	}

	private static void fun1() {
		System.out.println(" private method of interface ClassA");
	}

	default  void fun2() {
		System.out.println(" default method of interface ClassA");
		}

	abstract  void fun3();
	
	public  void m1();	
   
	private strictfp void fun4() {
		System.out.println(" strictfp method of interface ClassA");
	}
}



interface InterB extends InterA {
	
	public static void fun() {
	    System.out.println(" public method of interface ClassA");
		}
	
}


class ClassOne implements InterA , InterB {

	@Override
	public void fun3() {
		System.out.println("implement method of Interface ClassA");	
	}

	@Override
	public void m1() {
		// TODO Auto-generated method stub	
	}
	
	public static void main(String[] args) {
		
		ClassOne obj=new ClassOne();
	}
}











