package array;


public class SpecialArray {

	public static void main(String[] args) {

//				        duplicate();
//						largest();
//						lowest();
//						ascending();
//		                decending();
//		                stringArray();
	}

	public static void duplicate() {

		int []obj= { 78,24,24,29,106,106,246,78};
		for(int i=0; i<obj.length; i++) {
			for(int j=i+1; j<obj.length; j++) {
				if(obj[i]==obj[j]) {
					System.out.println("Duplicate Number "+obj[i]);
				}}
		}}

	public static void largest() {

		int []obj= { 24,29,106,246,78,29};
		int max=obj[0];
		for(int i=0; i<obj.length;i++) {
			if(max<obj[i]) 
				max=obj[i];
		}
		System.out.println("Largest Number "+max);
	}

	public static void lowest() {

		int []obj= { 24,29,106,246,78,29};
		int max=obj[0];
		for(int i=0; i<obj.length;i++) {
			if(max>obj[i]) 
				max=obj[i];
		}
		System.out.println("Lowest Number "+max);
	}
	public static void ascending() {

		int []obj= { 24,29,106,246,78,29};
		int temp;
		for(int i=0; i<obj.length; i++) { 
			for(int j=i+1; j<obj.length; j++) { 
				if(obj[j]<obj[i]) {
					temp=obj[j];
					obj[j]=obj[i];
					obj[i]=temp;
				}
			}
			System.out.println(obj[i]);
		}}
	public static void decending() {

		int []obj= { 24,29,106,246,78,29};
		int max;
		for(int i=0; i<obj.length;i++) {
			for(int j=i+1; j<obj.length; j++) {
				if(obj[i]<obj[j]) {
					max=obj[i];
					obj[i]=obj[j];
					obj[j]=max;
				}
			}
			System.out.println(obj[i]);	
		}
	}
		public static void stringArray() {
			
			String []str= {"Char","Acting","Double","Boy","Fight","Evs"};
			String max;
			for(int i=0; i<str.length;i++) {
				for(int j=i+1; j<str.length; j++) {
					if(str[i].compareTo(str[j])>0) {
						max=str[j];
						str[j]=str[i];
						str[i]=max;
					}
				}
				System.out.println(str[i]);
				
			}
		}

}
