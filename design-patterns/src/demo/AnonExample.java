package demo;

public class AnonExample {
	public static void main(String[] args) {
		//right here - not reusable - only the one usage
		//anonymous inner class -- Multiple methods in the interface
		// Java 8+ Lambda expression - Functional interfaces
		Thread thread = new Thread(() -> {	
			
		});
		
		thread.start();
		System.out.println("Main");}
		
	
	//1 method only
	interface Functional{
		public void go();
	}
}
