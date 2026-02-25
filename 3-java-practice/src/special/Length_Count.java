package special;

public class Length_Count {
	
	

	 static public void main(String[] args) {
		
		Length();
	 Length_2();
	 
	
		
	}

public static void Length() 
{
		
		int num=34567;
		int count=0;
		for(int i=num; num!=0; i++) {
			num=num/10;
			count++;
		}
		System.out.println(count);
	}
static public  void Length_2() {
	
	int A=234567823;
	int count=0;
	for(int i=1; A!=0; i++) {
		A=A/10;
		count++;
	}
	System.out.println(count);
}

}
