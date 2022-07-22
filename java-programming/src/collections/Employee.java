package collections;

import java.util.Comparator;
import java.util.Objects;

/*
 * Comparable - used by sorting collections to maintain the sort order (default/natural order)
 * Comparator - used for sorting in collections (not the natural order)
 * FirstNameComparator
 * Comparable(Natural order) -- N-number of comparators
 */
public class Employee implements Comparable<Employee>{
	//POJO - Plain Old Java Object
	// JavaBean = POJO
	// #1	Encapsulated
	// #2	No-Argument Constructor
	// #3	Setters/getters naming convention
	
	private int id;
	private String firstName;
	private String lastName;
	//generate constructors, getters and setters, equals/hashCode
	public Employee() {
		super();
	}

	public Employee(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(firstName, other.firstName) && id == other.id && Objects.equals(lastName, other.lastName);
	}
			
	@Override
	public String toString() {
		return id + "," + firstName + "," + lastName;
	}

	// 0 - dont switch
	// + - greater than goes later
	// - - less than goes earlier
	// -45 -31 -22 -1 0 5 11 99
	public int compareTo(Employee other) {
		return this.id -other.id;
		//1    5
	}
	
	//doesn't make sense to have EmployeeFirstNameComparator if Employees don't exist
	class FirstNameComparator implements Comparator <Employee>{
		public int compare (Employee one, Employee another) {
			return one.firstName.compareTo(another.firstName);
		}
		
	}

}
