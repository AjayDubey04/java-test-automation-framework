package inheritance;

public class Hierarchical {
	
	
	public void firstMethod() {
		System.out.println("hello funMethod");
	}
	
	public static void main(String[] args) {
		
	}
}


class Hierarchical_One extends  Hierarchical {
	
	public void secondMethod() {
		System.out.println("hello funMethod");
	}
	
	public static void main(String[] args) {
		
		Hierarchical_One obj=new Hierarchical_One();
	}
	
}


class Hierarchical_Two extends  Hierarchical { 
	
	public void thirdMethod() {
		System.out.println("hello funMethod");
	}
	public static void main(String[] args) {
		
		Hierarchical_Two obj= new Hierarchical_Two();
		
	}
	
}
