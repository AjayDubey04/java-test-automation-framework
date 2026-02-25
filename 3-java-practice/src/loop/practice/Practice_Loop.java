package loop.practice;

public class Practice_Loop  
{

	public static void main(String[] args) 
	{	


		//	
		////	 OBJECT //
		//  Loop_Practice main=new Loop_Practice ();
		//	main.While_Star();

		//	 System.out.println();
		//	 
		//	 MixLoop();
		chracter();

		Star(); 

	}
	
	public static void For_Loop() {
		int i,j,k;

		for(i=1; i<=3; i++) {
			for(j=1; j<=2; j++) {
				j=i+j;
				for(k=1; k<=2; k++) {
					k=k+i;
					System.out.println(i);
					System.out.println(j);
					System.out.println(k);
				}
			}
		}
	}
	//////   Reverse  ///////

	public static void Loop_Revars()
	{
		int a=698;
		for(int i=1; a!=0; i++) {
			//			while(b!=0) {
			System.out.print(a%10);
			a=a/10;
		}
	}


	public static void Revars_()
	{
		int num=56789;
		int rm;
		int rs=0;
		for(int i=1; num!=0; i++) { 
			//		while(num!=0){
			rm=num%10;
			rs=rs*10+rm;
			num=num/10;
		}
		System.out.println(rs);
	}	

	public static void Do_While()
	{
		int i=1;
		do {
			int j=1;
			do {
				int k=1;
				do{
					System.out.println(k);
					k++;
				}while(k<=2);
				System.out.println(j);
				j++;
			}while(j<=i);
			System.out.println(i);
			i++;
		}while(i<=2);

	}

	public static void Star_Do_While()
	{
		int i=1;
		do {
			int j=5;
			do {
				System.out.print("*");
				j--;
			}while(i<=j);
			System.out.println();
			i++;
		}while(i<=5);
	}

	public  void While_Star()
	{
		int a=5;
		while(a>=1) {
			int b=1;
			while(b<=a) {
				System.out.print(" *");
				b++;
			}
			a--;
			System.out.println();
		}

	}
	public static void MixLoop()
	{
		int i=1;
		for(i=1; i<=5; i++) {

			int j=1;
			while(j<=i) {
				System.out.println(i);
				j++;
			}System.out.println(j);
			int k=1;
			do {
				System.out.println("Hello");
				k++;
			}while(k<=2);
		}
	}


	public static  void chracter()
	{
		for(char i=65; i<=70; i++) {
			for(char j=65; j<=i; j++) {
				System.out.print(" "+j);

			}
			System.out.println();
		}
	}

	public static void Star()
	{
		int i,j,k;
		for(i=1; i<=5; i++) {
			for(j=5; j>=i; j--) {
				System.out.print(" ");
			}
			for(k=1; k<=i; k++) {
				System.out.print(" *");
			}System.out.println();

		}
		for(i=1; i<=5; i++) {
			for(j=1; j<=i; j++) {
				System.out.print(" ");
			}
			for(k=5; k>=i; k--) {
				System.out.print(" *");
			}System.out.println();

		}
	}
}






