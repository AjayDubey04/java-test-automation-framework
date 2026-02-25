package testng.practice;

public @interface Hello {
	

    String  str();
    
    int num();
    

}

class hii {
	
	@Hello(str = "", num = 0)
	public  void main() {
		
	}
	
	@java.lang.Deprecated
	public static void java() {
		
	}
	
}

class  hey{
	
	public static void main(String[] args) {
		m1();
//		hii.java();
		
	}
	
	
	public  static void m1() {
		
		
		System.out.println("hi");
		
		
		
		
	}
	
}


