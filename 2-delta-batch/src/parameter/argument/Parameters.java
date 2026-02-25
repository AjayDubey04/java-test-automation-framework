package parameter.argument;

public class Parameters {

public static void main(String[] args) 
{
	System.out.println("Argument And Parameter");
		
		int a=250;                                //     (a,b) is a local variable of main method   
		int b=50;                                //     this is very important for parameter and argument
 //       Argument    //                        //     Type  of  Argument
		Argu(a,b);                             //     Number of Argument 	 
		Argu(100,200);                        //     Sequence of Argument   
		Argu(150,150);
		Argu(500,100);                  
      
		System.out.println();
Parameters(100,  500,  "Number");
Parameters(10,   50,  "Value");

	System.out.println();
	Return_Type_Consept(); 

}   
	
	                                // parameters //
public static void Parameters(int length,int width,String name) 
{
	
//  length , width, name is a parameters 
//  fix value makes useless of any method 
//	we should be change fix value into parameters
//	do not fix value of parameters variable
	
	int net=length*width;
	System.out.println(name+" = "+net);

}

public static void Argu(int x, int y) {
	
	int z=x+y;
	System.out.println(z);
	int cost=x*2000;
	System.out.println(cost);
	
}


public static void Return_Type_Consept() 
{
	
	System.out.println("Return Type");	

	int g=Take(10,20);	
	int v=g*50;
	System.out.println(v);	

	g=Take(2,6);
	v=g*7;
	System.out.println(v);	
	Take(100, 200);

	}

public static int Take(int z, int s) 
{		
		int d=z+s;
		System.out.println(d);
		return d;
	

}

public static void main()
{
	
//	a,b IS A LOCAL VARIABLE OF MAIN METHOD //	
	
int a=100;
int b=200;
System.out.println("PARAMETERS AND ARGUMENT");
System.out.println();

// ARGUMENT //
Hi(a,b," sum");
Hi(25,50," Num");
System.out.println();

Hello("java", "Hello",'A');

System.out.println();
int t=Return('a',true,200);
int g=t*2;
System.out.println("New Return = "+g);


}
    
                        // PARAMETERS //
public static void Hi(int a, int b , String c)
{
//	 a,b IS A PARAMETERS OF HI METHOD //
	
	String d=a+b+c;
	System.out.println(d);
   
}

public static int Return(char x, boolean c, int y)
{
	int z=x+y;
	System.out.println(c+" "+z);
	return z;
	
}

public static void Hello(String a, String b, char c)
{
	String d=a+b+c;
	System.out.println("String Length = "+d.length());
	
}
}

