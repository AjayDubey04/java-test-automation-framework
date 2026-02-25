package loop.practice;

public class Loop_Test {


	public static void main(String[] args) {

		//		While();
		//  Hd(); 
		//  JVM();
		// System.out.println();
		//		test();
		//		System.out.println();
		//		While_2();
		//		
		//		System.out.println();
		Do_While();
		//		
		//		System.out.println();
		//		Do_While();

	}
	public static void ForLoop() {
		for(int i=1; i<=2; i++) {
			System.out.println(i+" Hello");

		}
	}
	public static void While() {
		int i=1;
		int var=2;
		while(i<=5) {
			var=var+i;
			System.out.println(var);
			i++;
		}
	}
	public static void While_2() {

		int a=1;
		while(a<=5) {

			int var=2;
			var=var+a;
			System.out.println(var);
			a++;
		}


	}
	public static void Do_While() {
		int i=1;
		int m=1;
		do {
			int j=1;
			do {	
				System.out.println(m);
				m++;
				j++;
			}while(j<=i);
			i++;
		}while(i<=4);
	}

	public static void Forloop() {

		int m=1;
		for(int i=1; i<=4; i++) {
			for(int j=1; j<=i; j++) {
				System.out.println(m);
				m++;
			}
		}
	}

	public static void test(){

		int a=121;
		int v=0;
		for(int i=1; a!=0; i++) {
			a=a/10;
			v++;

		}
		System.out.println(v);
	}
	public static void JVM() {


		int a=45678;
		int rem;
		int b=0;
		for(int i=1; a!=0; i++) {
			rem=a%10;
			b=b*10+rem;
			a=a/10;
		}System.out.println(b);
	}

	public static void Hd() {

		for(int i=1; i<=3; i++) {
			System.out.print("*");
		}System.out.println();

	}
}
