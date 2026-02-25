package staticConcept;

public class NextClass {


			public static void main(String[] args) {
				
				new NextClass();
				System.out.println("main");                //=============7
			}
			public NextClass() {
				System.out.println("next");
			}
			static {
				System.out.println("static-block-2");             //===1   
			}
			public static void m1() {
				System.out.println("static-method-1");           // ====3
			}
			public void m2() {
				System.out.println("non-static-1");               //=====4
			}
			{
				System.out.println("non-static -block");       //===\2               //==6
			}
			static {
				NextClass nc=new NextClass();
				nc.m1();
				nc.m2();
				System.out.println("static-block-1");           //=======5
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
//			public static void main(String[] args) {
		//
//				String str = new String("vinay y");
		//
////				int count = str.length();
////				System.out.println(count);
		////
////				boolean bool = str.isEmpty();
////				System.out.println(bool);
		//
//		   		
////			boolean boo=str.equals("vinay");	
////				System.out.println(boo);	
//				
//				if (str.equalsIgnoreCase("VINAY yadav")) {
//					System.out.println("hiii");
//				}
		//
//			}

//			public int length() {
//				
		//	
//				System.out.println("m1");
//				return 23;
//			}
		


	}


