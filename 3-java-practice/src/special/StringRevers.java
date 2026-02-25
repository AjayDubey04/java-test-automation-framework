package special;

public class StringRevers {

	public static void main(String[] args) {

		stringRevers();
		//		revers();

	}
	public static void stringRevers() {

		String str="you ever talk to him about this";
		String[] st=str.split(" ");
		for(int i=str.length()-1; i>=0; i--) {
			//			System.out.print(st[i]+" ");
			System.out.print(str.charAt(i));


		}
	}
	public static void revers() {

		String str="Hello";
		for(int i=str.length()-1; i>=0; i--) {
			char st=str.charAt(i);
			System.out.print(st);
		}
	}

	public static void main() {

		StringBuffer buffer=new StringBuffer("Hello");
		System.out.println(buffer.reverse());

		StringBuilder builder=new StringBuilder("Java");
		System.out.println(builder.reverse());


		String str="Hello Java";
		for(int a=str.length()-1; a>=0; a--) {
			System.out.print(str.charAt(a));
		}
	}

}