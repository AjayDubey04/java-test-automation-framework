package parameter.argument;

public class Calculat {

	
	
	public static void main(String[] args) {
		
		count(5000,25000,2500,"java ");
		count(6000,27000,2700,"java2 ");
		count(8000,30000,3000,"Hello ");
		count(10000,32000,3500,"Hello2 ");
        count(12000,35000,4000,"Hi.. ");
	}
public static void count(int hra,int basic, int pf, String name) {
	
	int total=hra+basic+pf;
	System.out.println(name+total);
	
}
}
