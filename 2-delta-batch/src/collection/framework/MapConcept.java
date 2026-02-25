package collection.framework;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MapConcept {

	public static void main(String[] args) {


		mapPractice();

	}


	public static void mapPractice() {


		Map<String,String> map=new HashMap<String,String>();
		map.put("name", "Rahul");
		map.put("city", "varanasi");
		map.put("town", "Mondh");
		  
		  Collection<String> s=map.values(); 
		  for (String string : s) {
		  System.out.println(string); }
		 
		
	}


}
