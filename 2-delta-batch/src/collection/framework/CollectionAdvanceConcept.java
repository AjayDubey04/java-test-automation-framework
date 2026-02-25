package collection.framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CollectionAdvanceConcept {

	
	public static void main(String[] args) {
		mapPractice();
	}
	

	public static void main() {



		Set<List<List<Map<Integer,String>>>> get1=createAndGetAllPersonInfoByNumber(); 
		for (List<List<Map<Integer, String>>> list : get1) { 
			List<Map<Integer, String>> hs=list.get(0); 
			Map<Integer, String> map2=hs.get(0); String
			getCity=map2.get(1); 
			System.out.println(getCity); }

		System.out.println("=============================");

		HashSet<List<List<Map<String,String>>>> get=createAndGetAllPersonInfoByName();
		for (List<List<Map<String, String>>> hashSet1 : get) {
			List<Map<String, String>> list1=hashSet1.get(0);
			Map<String, String> getMap=list1.get(0);
			String getName=getMap.get("name");
			System.out.println(getName);
			String getCity=getMap.get("city");
			System.out.println(getCity);
			String getTown=getMap.get("town");
			System.out.println(getTown);
		}
	}




	public static Set<List<List<Map<Integer,String>>>> createAndGetAllPersonInfoByNumber() {

		Map<Integer,String> map1=new HashMap<Integer,String>();
		map1.put(1, "Rahul");
		map1.put(2, "varanasi");
		map1.put(3, "mondh");

		Map<Integer,String> map2=new HashMap<Integer,String>();
		map2.put(1, "Rakesh");
		map2.put(2, "Jainpur");
		map2.put(3, "Market"); 
		List<Map<Integer,String>> list=new ArrayList<Map<Integer,String>>();
		list.add(map1);
		list.add(map2);
		
		List<List<Map<Integer,String>>> linkedList=new LinkedList<List<Map<Integer,String>>>();
		linkedList.add(list);
		
		Set<List<List<Map<Integer,String>>>> set1=new HashSet<List<List<Map<Integer,String>>>>();
		set1.add(linkedList);

		return  set1;


	}




	public static HashSet<List<List<Map<String,String>>>> createAndGetAllPersonInfoByName() {

		Map<String,String> map1=new HashMap<String,String>();
		map1.put("name", "Rahul");
		map1.put("city", "varanasi");
		map1.put("town", "mondh");

		Map<String,String> map2=new HashMap<String,String>();
		map2.put("name", "Rakesh");
		map2.put("city", "Jainpur");
		map2.put("town", "Market");

		Map<String,String> map3=new HashMap<String,String>();
		map3.put("name", "Ramesh");
		map3.put("city", "Pryagraj");
		map3.put("town", "TiklNager");

		// hashMap to Linked HashMap \\
		Map<String,String> linkedMap1=new LinkedHashMap<String,String>();
		linkedMap1.putAll(map1);

		Map<String,String> linkedMap2=new LinkedHashMap<String,String>();
		linkedMap2.putAll(map2);

		Map<String,String> linkedMap3=new LinkedHashMap<String,String>();
		linkedMap3.putAll(map3);


		//  Linked HashMap  to TreeMap \\
		Map<String,String> treeMap1=new TreeMap<String,String>();
		treeMap1.putAll(linkedMap1);

		Map<String,String> treeMap2=new TreeMap<String,String>();
		treeMap2.putAll(linkedMap2);

		Map<String,String> treeMap3=new TreeMap<String,String>();
		treeMap3.putAll(linkedMap3);

		// TreeMap to ArrayList  \\ 
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		list.add(treeMap1);
		list.add(treeMap2);
		list.add(treeMap3);

		// ArrayList To Linked List \\
		List<List<Map<String,String>>> linkedList=new LinkedList<List<Map<String,String>>>();
		linkedList.add(list);

		// Linked list to hash Set \\
		HashSet<List<List<Map<String,String>>>> set1=new HashSet<List<List<Map<String,String>>>>();
		set1.add(linkedList);

		// hash Set to LinkedHashSet \\
		//		HashSet<TreeSet<List<List<Map<String,String>>>>> set2=new HashSet<TreeSet<List<List<Map<String,String>>>>>();
		//		set2.add(set1);

		// LinkedHashSet TreeHashSet \\
		//		LinkedHashSet<HashSet<TreeSet<List<List<Map<String,String>>>>>> set3=new LinkedHashSet<HashSet<TreeSet<List<List<Map<String,String>>>>>>();
		//		set3.add(set2);

		return  set1;


	}

	
	public static void mapPractice() {
		
		Map<String, Integer> hashMap = new HashMap<>();
		hashMap.put("Alice", 75);
		hashMap.put("Bob", 76);
		hashMap.put("Charlie", 77);
		// Order of elements is not guaranteed
		int age = hashMap.get("Alice"); 
		System.out.println(age);
		

		Map<String, Integer> treeMap = new TreeMap<>();
		treeMap.put("Alice", 65);
		treeMap.put("Bob", 66);
		treeMap.put("Charlie", 67);
		// Keys will be sorted in ascending order:
		int age2=treeMap.get("Alice"); 
		System.out.println(age2);
	
		
		LinkedHashMap<Integer, String> studentLinkedHashMap = new LinkedHashMap<>();
		studentLinkedHashMap.put(101, "Alice");
		studentLinkedHashMap.put(102, "Bob");
		studentLinkedHashMap.put(103, "Charlie");
		// Order of elements is based on insertion order
		String name= studentLinkedHashMap.get(101); 
		System.out.println(name);

		
		
	}
	
	
	




}
