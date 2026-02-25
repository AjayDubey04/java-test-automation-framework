package staticConcept;

public class Static_Return {

	public static String st;
	
	public static void main(String[] args)
	{
		System.out.println(Static.name); 
		 st="Hii";
		Return();
		
		System.out.println();
		
		System.out.println(st);
		String vs="Hello"+" "+st;
		System.out.println(vs);
		
	}
public static String Return()
{

	return st;
}
}
