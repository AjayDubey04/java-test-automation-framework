package special;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		
		String st="top";
		String str="pot";
		char [] a=st.toLowerCase().toCharArray();
		char [] b=str.toLowerCase().toCharArray();
		Arrays.sort(a);
		Arrays.sort(b);
		
		if(Arrays.equals(a, b)) {
			System.out.println("This Is  Anagram Word");
		}else {
			System.out.println("This Is not a Anagram Word");
		}
	}

}
