package home.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListInterfacePractice {

	public static void main(String[] args) {
		/*
		 * list is interface in java and it is implemeted by arraylist and linkedlist
		 * class it followes insertion order it allows to take duplicate value and 
		 * it also take adjecnt memory location
		 * it also support object and it does not support to data type
		 */
		
		ListInterfacePractice obj =new ListInterfacePractice (); 
		obj.arrayList();
		obj.linkedList();

	}


	public void arrayList() {

	// arrayList is  predefine class which has implemented set interface
	// 	
		
		
		List<String> list=new ArrayList<String>();
		list.add("Ravi");
		list.add("Ajay");
		list.add("Abhishek");
		list.add("Ravi");
		
		System.out.println(list.size());


	}


	public void linkedList() {

		List<String> list=new LinkedList<String>();
		list.add("Ravi");
		list.add("Ajay");
		list.add("Abhishek");
		list.add("Ravi");
		
		System.out.println(list.size());
		
		
	}


}
