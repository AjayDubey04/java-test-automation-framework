
package special;

public class NumberRevarse {

	public static void main(String[] args) 
	{

		Revars();

		System.out.println();

		Revars_();
		m1();

	}

	public static void Revars()
	{
		int b=345678;
		while(b!=0) {
			System.out.print(b%10);
			b=b/10;
		}
	}

	public static void Revars_()
	{
		int num=56789;
		int rs=0;
		//	for(int i=1; num!=0; i++) {
		while(num!=0){
			int take=num%10;
			rs=rs*10+take;
			num=num/10;
		}
		System.out.println(rs);
	}
	public static void m1() {

		int num=655;
		int b=0;
		for(int i=1; num!=0; i++) {
			int res=num%10;
			b=b*10+res;
			num=num/10;
		}
		System.out.println(b);
	}
}
