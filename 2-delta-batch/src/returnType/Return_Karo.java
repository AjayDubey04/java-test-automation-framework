package returnType;

public class Return_Karo {

	public static void main(String[] args) {
		
		String a=Return();
		System.out.println(a);
		
		 Return_Karo take=new  Return_Karo();
		 Return_Karo b=take.obj();
		 System.out.println(b);
	}
	
 public static String Return() {
	 
	 return "Hello java";
	
}
 public  Return_Karo obj() {
	 Return_Karo oj= new Return_Karo();
	 return oj;
 }
}