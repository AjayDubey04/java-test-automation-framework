package collection.framework;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionMethods {



	public static void main(String[] args) {


		CollectionMethods obj=new CollectionMethods();
		obj.addMethod();

	}


	public void addMethod() {

		// add method is used to insert single object value 
		Collection c=new	ArrayList();
		System.out.println(c.add("hello"));
		System.out.println(c.add(100));
		System.out.println(c.add('A'));
		System.out.println(c.add("hello"));
		System.out.println(c);

		System.out.println("===============================");

		// addAll method is used to insert All collection object value 
		Collection c1=new	ArrayList();
		c1.add("shyam");
		c1.add("Ram");
		c1.add("Radha");
		//		System.out.println(c1.addAll(c));
		System.out.println(c1);

		// it will check value is present or not
		System.out.println(c.contains("hello"));


		// it will check all collection value is present or not
		System.out.println(c1.containsAll(c));

		System.out.println(c1.equals(c));

		System.out.println(c.hashCode());
		
		// it will remove all value form collection
				//	c.clear();
		System.out.println(c.isEmpty());
		
		c.removeIf(null);

	}


}
