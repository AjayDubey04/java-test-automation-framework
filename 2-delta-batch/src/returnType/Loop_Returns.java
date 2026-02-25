package returnType;

public class Loop_Returns {

	public static void main(String[] args) 
	{
		
		int a=loop_return();
		a++;
		System.out.println(a);

	}
public static int loop_return() {
	int i;
	for(i=1; i<=5; i++) {
	}
	return i;
}
}
