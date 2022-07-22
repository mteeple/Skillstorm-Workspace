package collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetExample {

	public static void main(String[] args) {
		Employee e = new Employee();
		
		//Employee.FirstNameComparator comparator = new Employee().FirstNameComparator;
		
		
		Employee employee = new Employee(3, "Jeff", "Goldbloom");
		SortedSet<Employee> hashSet = new TreeSet<>(); //linkedhashset is ordered unlike normal hashset
		hashSet.add(new Employee(1, "Breanna", "Taylor"));
		hashSet.add(new Employee(2, "Daniel", "Taylor"));
		hashSet.add(employee);

		
		System.out.println(hashSet.size());
		//Alt-Shift-R ---- Refactor
		for (Employee temp: hashSet) {
			System.out.println(temp);
		}

	}

}
