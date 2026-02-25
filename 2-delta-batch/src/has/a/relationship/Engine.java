package has.a.relationship;

public class Engine {
	
	
	public static void main(String[] args) {
		
	}
	
	public void brand() {
		System.out.println("Engine Brand");
	}
	
	public void material() {
		System.out.println("Engine Material");
	}

}

class Car {
	
	public static void main(String[] args) {
		
		// Car Has A Engine //
		Engine obj=new Engine() ;
		obj.material();
		obj.brand();
				
	}
}
