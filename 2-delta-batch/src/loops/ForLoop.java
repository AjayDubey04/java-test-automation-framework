package loops;

public class ForLoop 
{
 public static void main(String []args)
 {
	Loop_6();
	
	}
	public static void Loop_1()
	{
		int i=5;
		System.out.println(++i + i++);
		System.out.println(i);
		
	}

 public static void Loop_2() 
 {
	
	for(int i=1; i<=5; i++)
	{
    i=i+2;
    System.out.println(--i);
     i=i+1;
	}
} 

 public static void Loop_3() 
 {
		
	int	i,temp=2;
	for( i=1; i<=5; i++)
		temp=temp+i;
	System.out.println(++temp);
	temp=temp+i;
	}
	
public static void Loop_4()
{
for(int i=1; i<=3; i++)
{ 
for(int j=1; j<=i; j++)
	System.out.print(i+"\n");
}
}

public static void Loop_5()
{
	
	for(int i=1; i<=3; i++)
	{
		for(int j=1; j<=2; j++) {
			i=i+j;
			System.out.print(i);
		System.out.println();
	}
	}
}
public static void Loop_6() 
{
	for(int a=1; a<=4; a++) {
		for(int b=a; b>=1; b-- )
			System.out.print(b);
		System.out.println();
		}
	}


public static void Loop_7() 
{
	for(int i=1; i<=3; i++) {
		for(int j=1; j<=i; j++) {
			System.out.print(j);
	System.out.println();
}
}
}
public static void Loop_8() 
{
	int m=0;
	for(int i=1; i<=4; i++) {
		for(int j=1; j<=i; j++) {
			m++;
		System.out.println(m);
	}
}
}

public static void Factorial() 
{ 
	int i,j=1;
	for( i=5; i>=1; i--) {
		j=j*i;
		System.out.print(i+"*");
	}
		
     System.out.print(" = "+j);

	}	

public static void Length() {
	int  count=0;
	int num=34987;
	for(int j=1; num!=0; j++) {
		num=num/10;
		count++;
}
	System.out.println("34987 ki length"+" = "+count);
}

	public static void Nasted_Loop()
	{
		int i,j,k;
		for(i=1; i<=2; i++) {
			for(j=1; j<=i; j++) {
				i=i+j;
				for(k=1; k<=2; k++)
					i=k+i;
				System.out.println(i++);
			}
		}
	}
	
public static void Nasted_Loop_2()
{
		int i,j,k;
		for(i=1; i<=5; i++) {
			for(j=1; j<=2; j++) {
				for(k=1; k<=3; k++) {
					System.out.println(i);
				System.out.println();
			}
			System.out.println(k);
		}
	}
}

public static void FourLoop()
{
int i,j,k,l;
for(i=1; i<=3; i++) {
	for(j=1; j<=2; j++) {
		i=i+j;
		for(k=1; k<=2; k++) {
			for(l=1; l<=j; l++) {
				k=k+l;
				System.out.println(i);
				System.out.println(j);
				System.out.println(k);
				
			}System.out.println(l);
		}
	}
}
}

public static void Statement()
{
// we can use break and continue	keyword with any loop //
for(int i=1; i<6; i++) {
	System.out.println(i);
	if(i<=3)
		break;
	continue; 
}
}
public static void Without_Condition()
{
	
//	if we will not attach condition only loop then he will understand by default true //
	
	for(int i=1; ; i++) {
		System.out.println(i);
//		he will be take only true condition //
	}
	
}

}

