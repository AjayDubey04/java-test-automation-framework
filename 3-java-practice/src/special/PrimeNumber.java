package special;

public class PrimeNumber {

	public static void main(String[] args) throws InterruptedException {

		primeNumber();
	}
	public static void primeNumber() throws InterruptedException {
		
		int count=0;
		int num=9;
		for(int i=2; i<num; i++) {
			if(num%i==0) {
				count++;
				break;
			}
		}
		if(count==0) {
			System.out.println("This Is a prime Number");
		}else {
			System.out.println("This is a not Prime Number");
		}
	}
}