package object;


public class Hey_Object {

	Hey_Object(String name)
	{
		System.out.println(name);
		System.out.println(i);
	}
	
	Hey_Object()
	{
		System.out.println("Dekho mai default hu");
		System.out.println(name);
	}
	
	{
		non();
		 i=5;
	}
	public void non()
	{
		non_2();
		System.out.println(a);
	}
	
	int a=5;
	int i;
    public static void non_2()
    {
		System.out.println(j);
		System.out.println(name);
	
    }
 
   static {
	non_2(); 
	new Hey_Object("hey mai parameterize hu");
   }

 static int j=10;
 static String name;
 
	public  void  m1() 
	{
		System.out.println("hii");
		System.out.println(i);
		System.out.println(name);
      }
	
	{
		m1();
		System.out.println("i am non satic block");
		System.out.println("Dekho run hota hai");
		System.out.println(i);
	}
	
	
	public static void main(String[] args) 
	{
		
		new Hey_Object();
		non_2();
		System.out.println(new Hey_Object().j);
		new Hey_Object("ky tumne suna");
	}
	}

