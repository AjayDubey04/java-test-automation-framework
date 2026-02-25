package special;

public class Change_Line {

	public static void main(String[] args) {

		Loop();

		System.out.println();
		While() ;

		System.out.println();
		Do_While();
	}
	public static void Loop() {
		int var;
		for(int i=1; i<=5; i++) {
			var=i;
			for(int j=1; j<=3; j++) {
				System.out.print(" "+var);
				var=var+5;
			}
			System.out.println();
		}
	}
	public static void While() {
		int i=1;
		int var;
		while(i<=3) {
			var=i;
			int j=1;
			while(j<=3) {
				System.out.print(" "+var);
				j++;
				var=var+2;
			}
			System.out.println();
			i++;

		}
	}
	public static void Do_While() {

		int a=1;
		int var;
		do {
			var=a;
			int b=1;
			do {
				System.out.print(" "+var);
				var=var+3;
				b++;
			}while(b<=3);
			System.out.println();
			a++;

		}while(a<=3);
	}}
