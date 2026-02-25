package breakContinue.statement;

public class ContinueStatement {

	public static void main(String[] args) {


		//		continueStatement();
//		continueStatement_1();
//		continueStatement_2();
		continueStatement_3();
//		statement();
	}

	public static void continueStatement() {

		for(int i=0; i<=10; i++) {

			if(i%2==0) 
				continue;

			System.out.print(" "+i);
		}
	}

	public static void continueStatement_1() {

		int i=0;
		while(i<=10) {   
			if(i%2==0) {
				i++;
				continue;
			}
			System.out.print(" "+i);
			i++;
		}

	}
	public static void continueStatement_2() {

		int i=0;
		do {
			if(i%2==0) { 
				i++;
				continue;
			}
			System.out.print(" "+i);
			i++;
		}while(i<=10);
	}
	public static void continueStatement_3() {

		for(int i=1;i<=3;i++){     
			for(int j=1;j<=3;j++){    
				if(i==2&&j==2){    
					continue;    
				}    
				System.out.println(i+" "+j);    
			}    
		}    
	}
	public static void statement() {
		
		  for(int i=0; i<=10; i++) {
			  
			  if(i==3) {
				  break;
			  }
		  
			for(int j=0; j<=2; j++) {
				
				if(j==1) {
					 continue;
				}
				System.out.println(i+" "+j);
			}
		}}
}
