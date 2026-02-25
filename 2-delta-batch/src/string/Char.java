package string;

public class Char {

	public static void main(String[] args) {
		
		System.out.println();
		c1();

		System.out.println();
		c2();

		System.out.println();
		c3();
	
}

public static void c1() 
 {
		char i;
		for(i=65; i<91; i++)
			System.out.print(" "+i);

	}
	 
public static void c2()
{
		int i;
		for(i=97; i<123; i++)
			System.out.print(" "+(char)+i);
}
	 
public static void c3()
{
		byte a;
		for(a=48; a<58; a++)
			System.out.print(" "+(char)+a);
	}


}