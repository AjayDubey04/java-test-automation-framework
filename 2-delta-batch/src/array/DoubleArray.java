package array;

public class DoubleArray {

	public static void main(String[] args) {

		A1();
		//	For_eashloop();
		//	For_eashloop_1();
		//		Array();
		//		special();
		//		        special_1();
	}
	public static void A() 
	{
		String[][][] b=new String [5][3][2];
		System.out.println(b);
		System.out.println(b.length);
		System.out.println(b[0][0]);

		int[][] a=new int[2][];
		System.out.println(a);
		System.out.println(a.length);
		//	System.out.println(a[1][0]); // it will be show null pointer Exception //

	}
	public static void For_eashloop() {

		int[][] a=new int [2][2];
		a[0][0]=1;
		a[0][1]=2;
		a[1][0]=3;
		a[1][1]=4;

		for (int[] is : a) {
			for (int is2 : is) {
				System.out.println(is2);	
			}
		}
	}
	public static void For_eashloop_1() {

		int[] a=new int [2];
		a[0]=50;
		a[1]=60;
		for (int i : a) {
			System.out.println(i+2);	
		}
	}
	public static void A1() {

		Object a[]= new Double[2];
		a[0]=4;
		System.out.println(a[0]);


	}
	public static void Argu(int []...a) {

		for(int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
	}
	public static void Array() {

		int arr[][]= { {1,2,3,4,5} , {6,7,8,9}  };
		for (int[] is : arr) {
			for (int is2 : is) {
				System.out.println(is.length);
				System.out.println(arr.length);
				System.out.println(arr[is2]);
				System.out.println(is[is2]);
			}
		}
	}

	public static void special() {

		int arr[]= { 10,20,30,40,50};
		int max=arr[0];
		for (int i = 0; i < arr.length; i++) {
			if(max<arr[i]) {
				max=arr[i];
			}
		}
		System.out.println("max = "+max);
	}
	public static  void special_1() {

		int []a= {10,20,30,40,50,};
		int []b= {70,5,8,9,100, 12};
		int max=0;
		for (int i= 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if(a[i]<b[j]) {
					max=a[0];
				}	
			}

		}
		System.out.println(max);

	}
}
