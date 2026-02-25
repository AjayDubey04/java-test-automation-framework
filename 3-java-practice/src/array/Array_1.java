package array;

public class Array_1 {

	static int[]c;
	int[]ab;
	static int a[]=new int [2];

	protected static void test() {
		
		System.out.println(c);
		Array_1 obj=new Array_1();
		System.out.println(obj.ab);
		System.out.println(obj.a[0]);
		System.out.println(a.length);
		System.out.println(a[0]);
	}
	
	public static int[] Object() {

		int[] b=new int [2];
		return b;

	}
	
	public static void Argument(int[]a) {
		a[0]=50;
		a[1]=60;
		System.out.println(a.length);
		System.out.println(a[0]);
		System.out.println(a[1]);
	}
	
	public static void main(String[] args) {

		Argument(new int[2]);
		//		Single_dimenstional();
		//		double_dimenstional();
		//		Three_dimenstional();
		//		Array_1() ;
		//		test();
		System.out.println(Object());
		int[] c=Object();
		System.out.println(c.length);
		System.out.println(c[0]);
	}

	public static void Single_dimenstional() 
	{
		int a[]= {1,2,3,4,5};
		System.out.println(a);
		System.out.println(a.length);
		System.out.println(a[4]);
	}

	public static void double_dimenstional() {

//		int b[][]=new int[1][2];
		int b[][]= {  {1,2,3,4,5,}, {6,7,}, };
		System.out.println(b);
		System.out.println(b.length);
		System.out.println(b[0].length);
		System.out.println(b[1].length);
		System.out.println(b[0][2]);
	}
	public static void Three_dimenstional() {

		int a[][][]= {  {{1,2,3,4,5} },  {{6,7,8,9,10},{11,12,13,14,15}} , {{16,17,18,19,20} ,{30,40,50,60,70,80,90,100}}};

		System.out.println(a);
		System.out.println(a.length);
		System.out.println(a[0].length);
		System.out.println(a[0][0].length);
		System.out.println(a[0][0][0]);
		System.out.println(a[2][0][4]);
		System.out.println(a[2][1][5]);

		System.out.println();
		int b[][][]= {  { {6,7,8,9,10} ,{16,17,18,19,20} ,{30,40,50,60,70,80,90,100}   }  };

		System.out.println(b.length);
		System.out.println(b[0].length);
		System.out.println(b[0][0].length);
		System.out.println(b[0][0][0]);
		System.out.println(b[0][0][4]);
		System.out.println(b[0][2][7]);

	}
	
	public static void Array1() 
	{
		int a[][][]= {{ {1,2,3,4},{5,6,7},{8,9} }, { {10,11},{12},{13,14,15,16},{17} },{ {18,19},{20,21},{22},{23,24,25},{26} }};
		System.out.println(a);
		System.out.println(a.length);
		System.out.println(a[0].length);
		System.out.println(a[1].length);
		System.out.println(a[2].length);
		System.out.println(a[0][0][3]);
		System.out.println(a[1][1][0]);
		System.out.println(a[1][2][2]);
		System.out.println(a[2][3][2]);
	}

	public static void m1()
	{
		int a[]= {1,2,3 };
		int b[]= {2,3,4};
		if(a.length==b.length){
			System.out.println("true");
		}
		else 
			System.out.println("false");

	}
	public static void m2() {

		int a[]= {12,25,35 };
		int b[]= {12,35,45};
		if(a==b){
			System.out.println("true"); }
		else {
			System.out.println("false");
		}
	}
	public static void m3()
	{
		int a[]= { 12,25,35 } ;
		int b[]= { 12,35,45 } ;
		for(int i=0; i<a.length; i++) {
			if(a[i]==b[i]) {
				System.out.println("true");
			}
			else {
				System.out.println("false");
			}
		}}}
