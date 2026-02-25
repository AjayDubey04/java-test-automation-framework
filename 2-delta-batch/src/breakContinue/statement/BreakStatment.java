package breakContinue.statement;

public class BreakStatment {

	public static void main(String[] args) {


//		breakStatement(); 
		breakStatement_1();
//		breakStatement_2();
//		breakStatement_3();
//		breakStatement_4();
	}

	public static void breakStatement() {

		for(int i=0; i<10; i++) {

			if(i==5) {
				break;
			}
			System.out.println(i);
		}
	}
	public static void breakStatement_1() {

		for(int i=0; i<=3; i++) {
			for(int j=0; j<2; j++ ) {	
				if(i==1) {
					break;
				}
				System.out.println(i);
			}
		}
	}

	public static void breakStatement_2() {

		int i=0; {
			while(i<10) {
				if(i==5) {
					break;
				}
				System.out.println(i);
				i++;
			}}
	}
	public static void breakStatement_3() {

		int i=0;
		do {
			System.out.println(i);
			i++;
			if(i==5) {
				break;
			}
		}while(i<10);
	}

	public static void breakStatement_4() {

		int i=5;

		switch(5) {
		case 2:{
			System.out.println("Two");
			break;
		}
		case 3:{
			System.out.println("Three");
			break;
		}
		case 4:{
			System.out.println("Four");
			break;
		}
		case 5:{
			System.out.println("Five");
			break;
		}
		default :{
			System.out.println("Unexpected Value "+i);
			break;
		}
		}
	}
}