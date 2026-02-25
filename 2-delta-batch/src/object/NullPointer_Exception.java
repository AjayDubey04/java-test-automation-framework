package object;

public class NullPointer_Exception {

	NullPointer_Exception abc;	
	
	public static void Null() {
		
		NullPointer_Exception obj=new NullPointer_Exception();
        obj=null;
        System.out.println(obj.abc);
	}
	public static void main(String[] args) {
		
		
	}

}
