package array;


public class ArrayRecape {

	static String []d;
	static int[]b=new int[2];

	public static void main(String[] args) {

		//		System.out.println(d); 
		//		System.out.println(b[1]); 
		//		
		//		int[]b=new int[2];
		//		System.out.println(b[0]);  // 0
		//		
		//		String []a=new String[3];
		//		System.out.println(a[1]); // null
		largestArray();
	}

	public static void largestArray() {

		int[]arr= {10,45,778,10,20,20,34,67,10};
		int ass;

		for (int i =0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {

				if(arr[i]>=arr[j]) {
					ass=arr[j];
					arr[j]=arr[i];
					arr[i]=ass;
				}
			}
		} 
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}


	}

}
