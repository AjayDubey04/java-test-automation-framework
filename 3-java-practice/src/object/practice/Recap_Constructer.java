package object.practice;

public class Recap_Constructer {

	Recap_Constructer() {
//		new Constructer_Practice();
		System.out.println("Hello");
	}
	
	public void Test() {
		
		new Recap_Constructer();
		int i=1;
		while(i<=3) {
			System.out.println(i);
			i++;
		}
	}
	
 static {
	    int a=1;
	    do {
		  int b=1;
		  do {
			  System.out.println("java");
			  b++;
		  }while(b<=a);
		  a++;
	  }while(a<=5);
	  
	  }
	
 
	    {
//		Test();
//	    new Constructer_Practice();
		System.out.println("instance block");
	   }
	    
	    
	    {
	    	int i;
	    	for(i=1; i<=5; i++);{
	    		System.out.println(i);
	    		i=i+2;
	    	}
	    	System.out.println(i);
	     }
	    
	public static void main(String[] args) {
		
		new Recap_Constructer();
  Recap_Constructer	obj=new Recap_Constructer();
 obj.Test();
	}

}
