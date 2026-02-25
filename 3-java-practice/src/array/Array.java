package array;

public class Array {

	public static void main(String[] args) 
	{

		//		m1();
		//		m2();
		//		array();
		//		array_1();
		//		array_2();
		//		array_3(); 
		array_4(); 
	}

	public static  void m1() 
	{
		String a[]= {"Hello","Hii","GM","GN","Ok"};
		int b[]= {1,2,3,4,5,6,7,8};
		for(int i=0; i<=7; i++) {
			b[4]=10;
			System.out.println(b[i]);

		}	
	}


	public static void m2() 
	{
		int a[]= {10,20,30,40,50,60,70,80,};
		for(int i=0; i<8; i++) {
			a[i]=a[i]+(i+1);
			System.out.println(a[i]);
		}
	}
	public static void array() 
	{
		int a[]= {12,7,3,953,90};

		a[2]=50;
		a[3]=100;
		System.out.println(a.length);
		for(int i=1; i<=4; i++) {
			System.out.println(a[i]);
		}}

	public static void array_1() {

		int a[][]={{2,5,8,5,8,6,9}, {1,3,5,7,8,2}, {7,6,76,7,4}};

		for(int i=0;i<=2; i++) { 

			if(i==0) {
				for(int j=0; j<=6; j++) 
					System.out.print(" "+a[i][j]); 
			}
			if(i==1) {
				for(int j=0; j<=5; j++) 
					System.out.print(" "+a[i][j]); 
			}
			if(i==2) {
				for(int j=0; j<=4; j++) 
					System.out.print(" "+a[i][j]); 
			}
			System.out.println();

		}
	}

	public static void array_2() {
		
		int a[][]={{2,5,8,5,8,6,9}, {1,3,5,7,8,2,}, {7,6,76,7,4,} };
		int b=1;
		for(int i=0;i<=2; i++) { 
			for(int j=0; j<=a[i].length-b; j++) {
				System.out.print(" "+a[i][j]); 

			}
			System.out.println();
		}
		b++;
	}

	public static void array_3() {

		int b[][]= {{2,5,8,0},{1,3,5,7},{7,6,76,7}};

		System.out.println(b.length);
		System.out.println(b[1].length);
		for(int i=0; i<=2; i++) {
			for(int j=0; j<=3; j++) {
				System.out.print(" "+b[i][j]);
			}System.out.println();
		}
	}

	public static void array_4() {

		int a[][]= {{4,5,7,45,34,2},{12,21,34,3},{34,32,4,3,3},{2,32,33,21,3,1,2,4},{1,3,4,5,5,6,7}};
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				System.out.print(" "+a[i][j]);
			}
			System.out.println();

		}

	}
}