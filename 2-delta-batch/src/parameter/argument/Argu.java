package parameter.argument;

public class Argu {

	public static void main(String[] args) {
		
		
//		Argument //
      Area(50, 55);
      Area(100, 25);
      Area(20, 55);
      Area(20, 75);
      Area(57, 65);
		
		
	}
//                      --   parameter --
public static void Area(int length,int widgth) {
	
	
	int total=2*(length+widgth);
	System.out.println(total);
	int rate=2000;
	int cost=rate*total;
	System.out.println(cost);
}
}
