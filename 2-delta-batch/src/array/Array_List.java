package array;

import java.util.ArrayList;

public class Array_List {

	public static void main(String[] args) {

		//		arrayList();
		arrayList_1();

	}
	public static void arrayList() {

		ArrayList<String> obj=new ArrayList<String>();
		obj.add("Hii");
		obj.add("Hello");
		obj.add(2, "Best");
		for(int i=0; i<obj.size(); i++) {
			System.out.println(obj.get(0));
			System.out.println(obj.size());
			System.out.println(obj);
		}
	}

	Array_List(){

		System.out.println("Hello ArrayList Class");
	}

	public static void arrayList_1() {

		ArrayList<String> obj=new ArrayList<String>();
		System.out.println(obj); // print [] 
		obj.add("Hii");
		System.out.println(obj); // print [Hii]
		obj.add("Hello");
		System.out.println(obj);
		obj.add(2, "Best");
		System.out.println(obj);

		ArrayList<Array_List> ob=new ArrayList<Array_List>();
		obj.add(null);
		ob.add(new Array_List());
		System.out.println(ob);
	}
}
