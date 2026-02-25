package loops;

public class Amazing_Loop {

	public static void main(String[] args) 
	{

		//		M1();
		//		Hii();
		//		Diff();
		Diff_1();

		//		Exact_Loop();
		//		System.out.println();
		//		Table_Loop();
		//		
		//		 Hii_1();
		//		 System.out.println();
		//		 Hii_2();
	}
	public static void M1() {


		for(int i=1; i<=5; i++) {
			int a=i;
			int b=0;
			for(int j=1; j<=i; j++) {
				System.out.print(" "+a);
				a=a+4;
				a=a-b;
				b++;
			}System.out.println();
		}
	}
	public static void Hii() {
		int i=1;
		i+=1;
		while(i<=5) {
			System.out.println(i);
			i++;
		}
	}
	public static void Diff() {

		char c=65;
		char d=c;
		int i=0;
		for(int a=1; a<=5; a++) {
			for(int b=1; b<=5+i; b++) {
				System.out.print(" "+d);
				d++;
			}System.out.println();
			i++;
		}

	}
	public static void Diff_1() {

		char z=65;
		for(int a=1; a<=5; a++) {
			if(a==5) {
				System.out.print(z);
				z++;
			}
			for(int b=1; b<=5; b++) {
				System.out.print(" "+z++);
			}System.out.println();

		}
	}
	public static void Exact_Loop(){

		int a=100;
		int b;
		for(int i=1; i<=10;i++) {
			b=i;
			for(int j=1; j<=10; j++) {

				System.out.print(" "+b);
				b=b+10;
			}System.out.println();

		}
	}
	public static void Table_Loop() {

		for(int i=1; i<=10; i++) {
			for(int j=2; j<=10; j++) {
				System.out.print(" "+i*j);
			}System.out.println();
		}
	}
	public static void Hii_1() {
		int a=1;
		for(int i=1; i<=10; i++) {
			for(int j=1; j<=10; j++) {
				System.out.print(" "+a);
				a++;
			}System.out.println();
		}
	}
	public static void Hii_2() 
	{
		for(int i=2; i<=10; i++) {
			for(int j=1; j<=10; j++) {
				System.out.print(" "+i*j);
			}System.out.println();
		}
	}
}
