package home.practice;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetInterfacePractice {


	public static void main(String[] args) {

		/* set is a interface which has extednted collection interface in java 
		 * it has implemented by treeSet and hashSet and linkedHashSet class
		 * it does not follow insertion order
		 * and it does not allow to take duplicate value
		 * it does not have get method to fetch the value one by one 
		 * it has add method to add the value 
		 * it supports only object it does not support data type
		 */

		SetInterfacePractice obj=new SetInterfacePractice();
		obj.hashSet();
		System.out.println();
		obj.treeSet();
		System.out.println();
		obj.linkedHashSet();



	}


	public void hashSet() {	
		/*
		 * hashSet is predefine class in java it has implemented set interface
		 * it does not follow insertion order and adjectent memory allocation
		 * and it does not allow to take duplicate value
		 * it has add method to add the new value but it does not has get method to fetch the value
		 */
		Set<String> set= new HashSet<String>();
		set.add("Ravi");
		set.add("Ajay");
		set.add("Abhishek");
		set.add("Ravi");
		System.out.println(set);

		/* it has size method by which we can get the size of hashSet calss value in
		 * form of int dataType
		 */
		System.out.println(set.size());

		for (String hashSetValue : set) {
			System.out.println(hashSetValue);
		}
	}
	
	

	public void treeSet() {
		/*
		 * treeSet is predefine class in java it has implemented set interface
		 * it does not follow insertion order but it follows accending order 
		 * and it does not allow to take duplicate value
		 * it has add method to add the new value but 
		 * it does not has get method to fetch the value
		 */
		Set<String> set= new TreeSet<String>();
		set.add("Ravi");
		set.add("Ajay");
		set.add("Abhishek");
		set.add("Ravi");
		System.out.println(set);

		/* it has size method by which we can get the size of hashSet calss value in
		 * form of int dataType
		 */
		System.out.println(set.size());

		for (String hashSetValue : set) {
			System.out.println(hashSetValue);
		}

	}
	

	public void linkedHashSet() {
		/*
		 * linkedHashSet is predefine class in java it has extended of hashSet class
		 * it follows insertion order but it does not take adjecent memory allocation 
		 * and it does not allow to take duplicate value
		 * it has add method to add the new value but 
		 * it does not has get method to fetch the value
		 */
		Set<String> set= new LinkedHashSet<String>();
		set.add("Ravi");
		set.add("Ajay");
		set.add("Abhishek");
		set.add("Ravi");
		System.out.println(set);

		/* it has size method by which we can get the size of hashSet calss value in
		 * form of int dataType
		 */
		System.out.println(set.size());

		for (String hashSetValue : set) {
			System.out.println(hashSetValue);
		}

	} 

}

