package special;

public class Factoreal {

	public static void main(String[] args) {
		
		Fact() ;
		Fact_2();
		Fcat_3();
		
	}

 public static void Fact() {
		int j=1;
		for(int i=5; i>=1; i--) {
			j=j*i;
		}
		System.out.println(j);
		
}	
 
 public static void Fact_2() {
	 int j=10;
	 int i=1;
	 while(j>=1) {
		 i=j*i;
		 j--;
	 }
	 System.out.println(i);
 }
 public static void Fcat_3() {
	 int a=1;
	 for(int i=1; i<=6; i++ ) {
		 
		 a=a*i;
	 }
	 System.out.println(a);
 }
}
