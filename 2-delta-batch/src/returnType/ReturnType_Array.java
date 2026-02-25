package returnType;

public class ReturnType_Array {

	public static void main(String[] args) {
		
		int b[]=m1();
		System.out.println(b.length);
		for(int i=0; i<b.length; i++) {
			System.out.print(b[i]+",");
		}
       System.out.println();
	}
public static int [] m1() {
	
	
	int [][]a= {  {10,20,30,40,50}, {60,70,80,90} };
	System.out.println(a.length);
	
	return a[0];
}
}
