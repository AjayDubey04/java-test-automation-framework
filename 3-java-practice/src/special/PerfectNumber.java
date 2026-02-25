package special;

public class PerfectNumber {

	public static void main(String[] args) {
		
		int a=6;
		int sum=0;
		for(int i=1; i<a; i++) {
			
			if(a%i==0) {
				sum=sum+i;
			}
		}
		if(a==sum) {
			System.out.println("This is a perfect number");
		}else {
			System.out.println("This is a not perfect number");
		}
	
	}

}
