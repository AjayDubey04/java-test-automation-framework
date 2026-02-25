package inheritance;

public class Single {
	
	public  void  singleOne() {
		System.out.println("Hello singleOne Method ");
	}
	
	public  void singleTwo() {
		System.out.println("Hello singleTwo Method ");
	}

}



class Two extends Single {
	
	public  void  childOne() {
		System.out.println("Hello ChildOne Method ");
	}
	
	public  void childTwo() {
		System.out.println("Hello ChildTwo Method ");
	}
	
	public static void main(String[] args) {
		
		Two obj=new Two();
		obj.childOne();
		
		Single obj1=new Two();
		obj1.singleOne();
		
	}

}
