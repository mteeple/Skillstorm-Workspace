/**
 * SOLID - 
 * 	- Single responsibility principle -cohesive
 *	- Open for Extension(Inheritance)/closed for modification
 *
 */
public class HelloWorld {

	public static void main(String[] args) {
		//System.out.println("Hello World"); 
		Dog one= new Dog();
		Dog two= new Dog();
		int oneLife=one.lifespan=20;
		int twoLife=two.lifespan=11;
		System.out.println(oneLife);
		System.out.println(twoLife);
		one.hunt();
		Hunter hunter = new Dog();

	}
	//polymorphism 
	//dog,cat,wolf, etc as long as it implements hunter interface
	public void startHunt(Hunter hunter) {
		
	}

}
