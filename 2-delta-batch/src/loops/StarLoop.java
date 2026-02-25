package loops;

public class StarLoop 
{
	
	public static void main(String[] args)
	{
		Trangal();
		System.out.println();
		
		Star_() ;
		System.out.println();
		
		Star();
		System.out.println();
		
		Burffi();
		
	}
public static void Trangal()
{
	int i,j,k;
	for(i=5; i>=1; i--) {
		for(j=1; j<=i; j++) {
			System.out.print(" ");
			}
		for(k=i; k<=5; k++) {
			System.out.print("*");
		}System.out.println();
		}
}
	public static void Star_() 
	{
		
		for(int i=1; i<=5; i++)
		{
		for(int j=1; j<=i; j++){
			System.out.print(" *");
			}System.out.println();
	
		}
		for(int i=1; i<=5; i++)
		{
			for(int j=5; j>=i; j--){
			System.out.print(" *");
			}System.out.println();
	
}
	}
		public static void Star()
		{
			for(int i=1; i<=5; i++) {
				for(int j=1; j<=i; j++)
					System.out.print(" *");
				System.out.println();		
			}
		}
public static void Burffi()
{

int i,j,k;;
for(i=5; i>=1; i--) {
	for(j=1;j<=i; j++) {
		System.out.print(" ");
	}
	for(k=5;k>=i; k--) {
		System.out.print(" *");
		}System.out.println();
	}System.out.println("  *  Ajay *");
int a,b,c;
for(i=5; i>=1; i--) {
	for(j=5;j>=i; j--) {
		System.out.print(" ");
	}
	for(k=1;k<=i; k++) {
		System.out.print(" *");
		}System.out.println();
	}

}
}