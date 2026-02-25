package special;

import java.util.Arrays;
import java.util.Random;

public class InterviewProgramm {

	public static void main(String[] args) {


		randomSumToNine();


	}

	public static void randomSumToNine() {

		int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};

		Random rnd = new Random();

		for (int i = 0; i <500; i++) {

			for (int y = a.length - 1; y > 0; y--) {
				int index = rnd.nextInt(y + 1);
				// Swap elements
				int temp = a[index];
				a[index] = a[y];
				a[y] = temp;
			}	

			// Randomly pick two or three values and calculate their sum
			int sum = 0;
			int count =rnd.nextInt(3-2+1)+2;
			for (int k=0; k<count; k++) {
				sum =sum+a[k];
			}

			// Check if the sum is equal to 9
			if (sum == 9) {
				System.out.print("Random values: ");
				for (int j = 0; j < count; j++) {
					System.out.print(a[j]+" ");
				}
				System.out.println(" => Sum is 9");
				
			}
		}


	}


	public static void countCapitalLatter() {

		String str="I Am Going To marKet";
		int countLength=0;
		for (int i = 0; i<str.length(); i++) {
			for (char j =65; j <95; j++) {
				if(str.charAt(i)==j) {
					countLength++;
					System.out.println(str.charAt(i));
				}
			}		
		}
		System.out.println("Length ==>> "+countLength);

	}


	public static void meargTwoArray() {

		int a[]= {1,2,3,4,5};
		int b[]= {6,7,8,9,10};
		int length=a.length+b.length;
		int[] arr=new int[length];
		int count =0;
		for (int i = 0; i < a.length; i++) {
			arr[count]=a[i];
			count++;
		}
		for (int i = 0; i < b.length; i++) {
			arr[count]=b[i];
			count++;
		}
		System.out.println(Arrays.toString(arr));


	}
}
