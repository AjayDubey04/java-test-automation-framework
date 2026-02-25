package special;

public class Palindrome_Number {

	public static void main(String[] args) 
	{
		
		int num=121;
		int take=num;
		int a=0;
		for(int i=1; num!=0; i++) {
			int b=num%10;
			a=a*10+b;
			num=num/10;
		}
//		System.out.println(a);
//		System.out.println(take);
		if(take==a) {
			System.out.println(" This is palinedrone Number = "+a);
		}
		else {
			System.out.println(" This is not paileindrone Number = "+a);
		}
		
		
	}

}
