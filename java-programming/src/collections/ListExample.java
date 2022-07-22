package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListExample {

	public static void main(String[] args) {
		//generic(Employee) --enforce the type at compile time, cannot add something like linkedList.add(100)
		Employee employee = new Employee(3,"Random", "Best");
		java.util.List<Employee> linkedList = new LinkedList<>();
		linkedList.add(new Employee(1, "Alina", "Korsunska"));
		linkedList.add(new Employee(2, "Kevin", "Rickenbauch"));
		linkedList.add(new Employee(3, "Jeff", "Dominic"));
		linkedList.add(employee);
		linkedList.add(employee); // You can add the same/duplicate thing as much as you want 
		linkedList.add(employee);

		
		System.out.println(linkedList.get(2));
		System.out.println(linkedList.size());
		
		//raw
		List list = new ArrayList();
		list.add("String");
		list.add(100);
		list.add(new Employee(1,"best", "result"));

	}

}
