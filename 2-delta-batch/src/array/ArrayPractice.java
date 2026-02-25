package array;

public class ArrayPractice {

	public static void main(String[] args) throws InterruptedException {
		
		array();
		arrayPractice();
		
	}
	public static void array() {
		int num=58556;
		int rev;
		int add=0;
		for(int i=0; num!=0; i++) {
			rev=num%10;
			add=add+rev;
			num=num/10;
		}
		System.out.println(add);
		
		int []a= {100,60,15,20,200};
		int b;
		for(int i=0; i<a.length; i++) {
	    for(int j=i+1; j<a.length; j++) {
	    	if(a[i]>a[j]) {
	    		b=a[j];
	    		a[j]=a[i];
	    		a[i]=b;
	    	}
	    }
	    System.out.println(a[i]);
		}
		
	}
	
	public static void arrayPractice() {
		
		String []a=new String [10];
		for(int i=0; i<a.length; i=i+3) {
			a[i]="Hello"+(i+3);
			System.out.println(a[i]);
		}
		
	}
}
