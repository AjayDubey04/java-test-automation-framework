package inheritance;

public class ItSelf  {

	//extends ItSelf..... is not possible in java
	
	public void methodOne() {
		System.out.println("itSelf MethodOne");
	}
	
	public static void main(String[] args) {
		
		ItSelf obj=new ItSelf();
	}

}


