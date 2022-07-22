//real world entity
public class House {
	//properties, fields, states, variables, etc.
	String address;
	double value;
	int rooms;
	boolean listed;
	String paint;
	
	//instantiate - new/create
	public House() {
		
	}
	
	//methods, functions, behavior
	public void listForSale() {
		listed = true;
	}
}
