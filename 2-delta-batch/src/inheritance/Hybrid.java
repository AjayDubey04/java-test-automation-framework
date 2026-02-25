package inheritance;

public class Hybrid {
	
	
	public void hybridOne() {
		System.out.println("Hello Hybrid One Method ");
		
	}
	
	private void hybridTwo() {
		System.out.println("Hello Hybrid Two Method");
	}
}


class Child_Hybrid extends Hybrid {
	
	public void childHybridOne() {
		System.out.println("Hello ChildHybrid One Method");
	}
	
	private void childHybridTwo() {
		System.out.println("Hello childHybrid Two  Method ");
	}

}


class Sub_Hybrid  extends Hybrid {
	
	public void subHybridOne() {
		System.out.println("Hello ChildHybrid One SubClass Method");
	}
	
	private void subHybridTwo() {
		System.out.println("Hello childHybrid Two SubClass Method ");
	}

}


//class Inner_Hybrid extends Child_Hybrid ,  Sub_Hybrid {
//	 java does not also support Hybrid Inheritance
//}


