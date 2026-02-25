package array;

public class Array_Object {

	static String b[];
	static int a[];
	public static void main(String[] args) {

		System.out.println(a);
		//		args=new String[1];
		//		System.out.println(args);
		//		System.out.println(args.length);
		//		main(null);

		main_1();
		Array();
		Delta();
		Alpha();
		Fie();
		Char();
		Duplucat();
		Char_object();
		Default();
		Default_1();

		System.out.println(Hii().length);
		int []a=Hii();
		for(int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
	}
	public static void main_1() {

		int [] cc=new int[-0];
		System.out.println(cc.length);

		System.out.println(b);
		Array_Object obj=new Array_Object();
		System.out.println(obj.a);
		int[] b=new int[10];
		System.out.println(b.length);
		System.out.println(b[3]);
		for(int i=0; i<=6; i++) {
			b[0]=10;
			b[1]=20;
			b[2]=30;
			b[3]=40;
			b[4]=50;
			b[5]=60;
			System.out.println(b[i]);
		}
	}
	public static int[] Hii() {

		int [][]a= {{2,5,10},{15,20,25},{60,70,80,90}};
		return a[2];

	}

	public static void Array() {

		int[][]a=new int[2][3];
		System.out.println(a.length);
		a[1][2]=10;
		System.out.println(a[0][2]);
		System.out.println(a[1][2]);
		System.out.println(a);

	}
	public static void Delta() {

		int b[][]=new int[2][3];
		b[1][1]=30;
		for(int i=0; i<b.length; i++) {
			for(int j=0; j<b[i].length;j++) {
				System.out.print(" "+b[i][j]);
			}   System.out.println();
		}
	}
	public static void Alpha() {

		int a[][]=new int[1][3];
		a[0][0]=20;
		a[0][1]=50;
		a[0][2]=60;
		System.out.println(a[0][0]+" \n"+a[0][1]+" \n"+a[0][2]);
	}
	public static void Fie() {

		int [][][]a= {{{2,4,6,8,10,3,16},{12,14,16,18,20,},{22,12,86,24,26,28,30},{32,34,36,74,38,40},}, {, }};

		System.out.println(a[1][0].length);
		System.out.println(a+"\n");

		for(int i=0; i<a[0].length; i++) {
			for(int j=0; j<a[0][i].length;j++) {
				System.out.print(a[0][i][j]+",");
			}   System.out.println();
		}
	}
	public static void Char() {

		char a[][]= { {65,66,67,68,69, },{90,89,88,87,86}};
		for(int i=0; i<a.length;i++) {
			for(int j=0; j<a[i].length; j++) {
				System.out.print(a[i][j]+",");
			}System.out.println();
		}
	}
	public static void Duplucat() {

		int a[][]= {{  2,3,4,5},{3,7,8,9,},{2,3,5}};
		System.out.println(a[0][0]+"\n"+a[0][1]+"\n"+a[1][0]+"\n"+a[2][0]+"\n"+a[2][1]);
	}
	public static void Char_object() {

		char[][]a=new char[1][5];
		System.out.println(a.length);
	}
	public static void Default() {

		String name[][]=new String[2][1];
		System.out.println(name.length);
		name[0][0]="Hello";
		System.out.println(name[0][0]);
		//	System.out.println(name[1].length);

	}
	public static void Default_1() {

		String a[][]=new String[2][];
		a[0]=new String[4];
		System.out.println(a.length);
		System.out.println(a[0].length);
		System.out.println(a[1].length);
	}
}