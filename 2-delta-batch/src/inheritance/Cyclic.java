package inheritance;

public class Cyclic {
	
	// extends CyclicUse.....is not possibles
	
	public void cyclicOne() {
		System.out.println("First Cyclic Method");
	}
	
	public static void main(String[] args) {
		
	}
}

class CyclicUse extends Cyclic {
	
	public void cyclicUseOne() {
		System.out.println("First CyclicUseOne Method");
	}
	
}
