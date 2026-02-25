package special;

public class DigitalSum {

	public static void main(String[] args) {
		
		int num=58556;
		int rem;
		int add=0;
		for(int i=0; num!=0; i++) {
			
			rem=num%10;
			add=add+rem;
			num=num/10;
		}
		System.out.println(add);
		
		

	}

}
