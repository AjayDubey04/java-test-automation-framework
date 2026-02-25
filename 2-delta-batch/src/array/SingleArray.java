package array;

public class SingleArray {

	static int a[];

	public static void main(String[] args) {

		//		System.out.println(a);
		//		System.out.println(a.length); // null pointer exception
		//				single();
		//				single_1();
		//				single_negativ();
		//				single_loop();	
		for_each_loop();
	}
	public static void single() {

		int []b=new int[0];
		//	  System.out.println(b[0]);/// it will be give default vale as [0]
		System.out.println(b.length);
		int a[]={0};
		System.out.println(a[0]);
		System.out.println(a[5]); // it will be show exception //
	}
	public static void single_1() {

		int []a=new int[5];
		a[0]=10;
		a[1]=20;
		a[2]=30;
		a[3]=40;
		a[4]=50;
		for(int i=0; i<=a.length-1; i++) {
			System.out.println(a[i]);
		}
	}
	public static void single_negativ() 
	{  
		int v[]=new int [-5];
		System.out.println(3);

		int b[]=new int [-0];
		System.out.println(b[0]);

		int c[]=new int[2];
		System.out.println(c[-0]);
		System.out.println(c[-1]);
	}

	public static void single_loop() 
	{  
		int a[]= { 1,2,3,4,5 };
		for(int i=0; i<=a.length-1;i++) {
			System.out.println(a[a.length-1]);
			System.out.println(a[a.length+1]);
			System.out.println(a[a.length-(i-1)]);
			System.out.println(a[(a.length-1)-(i-1)]);
		}
	}

	public static void for_each_loop() 
	{
		int a[][][]= {  {  {1,2,3} ,{4,5,6} }, { { 10 ,20,30,},{40,50,60} }};
		for(int[][] i: a) {
			for (int[] js : i) {
				for (int js2 : js) {
					System.out.println(a.length);
					System.out.println(i.length);
					System.out.println(js.length);
					System.out.println(js2);

				}
			}
		}}
}
