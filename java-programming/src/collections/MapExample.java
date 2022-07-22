package collections;

import java.util.LinkedHashMap;
import java.util.Map;

//Map - Collection? IS-A no. Map does not implement collection interface
// is a - yes , but it is still a collection
public class MapExample {
	
	public static void main(String[] args) {
		// HashMap - unsorted, unordered
		// TreeMap - sorted by "dan", "jeff", "fred"
		// LinkedHashMap - ordered (insertion order)
		Map<String, Employee> map = new LinkedHashMap<>();
		//Map<Employee, List<Employee>> accountMap;         This does work, but just an example
		map.put("dan", new Employee(100, "Dan", "Pickles"));
		map.put("jeff", new Employee(10, "Jeff", "Gold"));
		map.put("fred", new Employee(65, "Fred", "Flint"));

		
		//Employee value = map.get("Dan");
		for(Employee temp: map.values()) {
			System.out.println(temp);
		}
		
	}
}
