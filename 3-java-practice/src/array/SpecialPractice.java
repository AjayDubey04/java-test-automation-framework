package array;

import java.util.ArrayList;
import java.util.List;

public class SpecialPractice {


	public static void main(String[] args) {


		int arr[]= {3,6,7,4,9};
		int arr1[]= {9,10,55,4,3};
		List<Integer> arr2=new ArrayList<Integer>();

		for(int i=0; i<arr.length; i++) {

			for(int j=0; j<arr1.length; j++) {

				if(arr[i]==arr1[j]) {
					arr2.add(arr1[i]);

				}

			}

		}

		System.out.println(arr2);
		int count=0;
		int num=0;
		for(int i=0; i<arr2.size(); i++) {
			num=arr2.get(i);

			for(int j=2; j<num; j++) {
				if(num%j==0) {
					count++;
					break;
				}			
			}

			if(count==0) {
				System.out.println(num+" is prime number");
			}else {
				System.out.println(num+" is not prime number");
			}

		}

	}	
	
	
	
	
	
	
	

}