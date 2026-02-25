package loops;

public class Special_Loop {

	public static void main(String[] args) 
	{
		//		loop();
		//		loop_1();
		//		loop_2();
		loop_3();
		//		Break(); 
		//		Break_1();
		//		Break_3();
		//		Break_4();
	}

	public static void loop() 
	{

		int i=0;
		for(System.out.println("hii"); i<=5; i++) {

			System.out.println("Hello");
		}
	}
	public static void loop_1() 
	{

		int i=0;
		for(System.out.println("Hii"); i<=5; System.out.println("Ram")) {
			System.out.println("Hello");
			i++;
		}
	}
	public static void loop_2() {

		int i=0;
		for( ; i<=5; ) {
			System.out.println(i);
			i++;
		}
	}
	public static void loop_3() {

		for(int i=0; i<=2; i++) {

			for(int j=0; j<=i; j++) {

				if(i==j)
					break;
				System.out.println(i+" "+j);
			}
		}

	}


	public static void Break()  
	{

		for(int i=1; i<=5; i++) {   
			System.out.println("Break statment");
			break;
		}}

	public static void Break_1() {

		for(int j=1; j<=10; j++) {

			//			 break;   we can not use before statement  //
			System.out.print(j);
			if(j==5) {
				break;
			}
			else {
				System.out.println(j);
			}
		}}

	public static void Break_3() {

		for(int i=1; i<=10; i++) {

			if(i==5) {
				break;
			}
			else {
				System.out.println(" "+i);
			}
		}
	}

	public static void Break_4() {

		for(int a=1; a<=10; a++) {

			if(a==7) {
				break;
			}
			else {
				System.out.print(" "+a);
				continue; 
			}}}}
