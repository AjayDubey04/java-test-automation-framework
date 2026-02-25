package exception;

public class UncheckedError {

	public static void main(String[] args) {

		UncheckedError obj=new UncheckedError();
		obj.arithMetic();
		obj.nullPointer();
		obj.arrayIndexOutOfBound();
		obj.handleCustomeError(17);
		obj.exceptionPractice();

	}

	public void arithMetic() {
		/*
		 *  System.out.println(100/0); 
		 *  handle the exception //
		 */		try {
			 System.out.println(100/0);
		 }
		 catch(ArithmeticException e){
			 System.out.println("we handled ArithmeticException");
		 }
		 System.out.println("First Runtime Exception \n");

	}


	public void nullPointer() {
		/*
		 * String str=null; 
		 * System.out.println(str.length());
		 */
		try {
			String str=null;
			System.out.println(str.length());
		}
		catch(NullPointerException e) {
			System.out.println("we handled NullPointerException");
		}
		System.out.println("Second Runtime Exception \n");
	}



	public void arrayIndexOutOfBound() {
		/*
		 int a[]= {1 ,3 ,4, 5};
		   System.out.println(a[4]);
		 */
		try {
			int a[]= {1 ,3 ,4, 5};
			System.out.println(a[4]);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("We Handled ArrayIndexOutOfBoundsException ");	
		}
		System.out.println("Third Runtime Exception \n");

	}

	public void throwKeyword(int age) {

		// the throw keyword is used to create a custom error
		// it is used to create implicitlly exception
		if(age<=18) {
			throw new ArithmeticException("Age must be 18");
		}
		else {
			System.out.println("Custome Error is genetred");
		}

	}

	public void handleCustomeError(int age) {

		try {
			throwKeyword(age);
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
		finally {
			System.out.println("Finally always excuted \n");
		}

	}


	public void exceptionPractice() {
		try {
//			System.out.println(10/0);
//			String str=null;
//			System.out.println(str.length());
			int[] a=new int[3];
			System.out.println(a[4]);
		}catch(ArithmeticException e) {
			System.out.println(e.toString());
		}catch(NullPointerException e){
			System.out.println(e.toString());
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.toString());
		}
		
		finally {
			System.out.println("Finally always excuted == ");
		}
	}

	
	public void recape() {
		
			try {
				
				}catch(ArithmeticException e) {
					
				}catch(NullPointerException e) {
					
				}
			
			try {
					
				}catch(Exception e) {
					
			
		}
	}
	
}
