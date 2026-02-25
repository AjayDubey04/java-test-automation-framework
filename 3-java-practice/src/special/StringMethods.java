package special;

public class StringMethods {
	
	
	public static void main(String[] args) {
		
		String str="Hello Java";
		
		// charAt method
		System.out.println(str.charAt(6));
		
		// length method
		System.out.println(str.length());
		
		// lowerCase method
		System.out.println(str.toLowerCase());
		
		// upperCase method
		System.out.println(str.toUpperCase());
		
		// subString method
		System.out.println(str.substring(3));
		
		// indexOf method
		System.out.println(str.indexOf('o'));
		
		
		// startWith method
		System.out.println(str.startsWith("He"));
		
		// endWith method
		System.out.println(str.endsWith("va"));
		
		// isEmpty method
		System.out.println(str.isEmpty());
		
		// repalce method
		System.out.println(str.replace('a','i'));
		System.out.println(str.replace("java","python"));
		
		// contains method
		System.out.println(str.contains("llo"));
		
		
		String st=" Hey Java , Is Language ";
		// trim method
		System.out.println(st.trim());
		
        //	split method
		System.out.println(str.split(","));
		
		
		// equalsIgnoreCase method 
		System.out.println(str.equalsIgnoreCase("hello java"));
		
		// equals method 
		System.out.println(str.equals("hello java"));
	}
	

}
