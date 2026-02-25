package interFace;

public interface InterF {

	 int a=6;
	
   public static void m1() {
	   System.out.println("method One of InterF");
   }
   
   private static void m2() {
	   
   }
    
    default void m3() {
	   
   }
    
    void m4();
   
   public static void main(String[] args) {
	
}
 
}

interface InterF_1 extends InterF {
	
	 public static void m1() {
		 InterF.m1();
		   System.out.println("method One of InterF_1");
	   }

	void m5();
	
}
class Take implements InterF ,InterF_1{
	
	public static void main(String[] args) {
		
		InterF.m1();
		InterF_1.m1();
		
		InterF_1 obj=new Take();
		
	}

	@Override
	public void m4() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m5() {
		// TODO Auto-generated method stub
		
	}
	
}


interface InterF_2 extends InterF_1,InterF {
	
	
}


abstract class One implements InterF_1  {
	
	
	
	
	
}


abstract class Two  implements InterF_1, InterF {
	
	
	
}
