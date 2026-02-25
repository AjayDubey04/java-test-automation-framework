package exception;



public class ExceptionHandlingRecape {
	
	
	
	public void exceptionHandling() {
		
//		File we=null;
//		 Files.copy(we, we); // checked exception 
		
		try {
			System.out.println("code that may occur an exception");
		}catch(NullPointerException c) {
			c.printStackTrace();
		}
		catch(Exception c) {
			System.out.println("code to handle for exception");
		}
		
		
		try {
			System.out.println("code that may occur an exception");
		}
		catch(Exception c) {
			System.out.println("code to handle for exception");
		}finally {
			System.out.println("code always executed");
		}
		
		
		
	}
	
	
	
	

}
