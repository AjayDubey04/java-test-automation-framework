package inheritance;

public class Multiple {

	private void methodOne() {

		System.out.println("Hello Multiple Method ");
	}
}

class ClassTwo {

	private void methodOne() {

		System.out.println("Hello Two Method ");
	}


}


//class ClassThree extends ClassTwo,Multiple {

// java does not support Multiple inheritance
//  ClassTwo obj=new ClassTwo();
//    obj.methodOne();
// because of ambiguty problem 
  
	
//}
