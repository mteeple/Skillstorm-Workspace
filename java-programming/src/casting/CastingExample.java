package casting;

public class CastingExample {
	public static void main(String[] args) {
		// Dog d=new Dog();
		new Dog("index");
	}
}

class Animal extends java.lang.Object {
	private double mass;
	String name;

	// constructor-initialized the object
	public Animal() {
		System.out.println("super");
	} // our no arg constructor

	public Animal(int i) {
		super();
	}

	public void speak() {
		System.out.println("Animal");
	}
}

class Dog extends Animal {
	public Dog() {
		super();
		System.out.println("This");
	}

	public Dog(String name) {
		this();
		this.name = name;
		System.out.println("Dog " + name);
	}

	public void speak() {
		System.out.println("Dog");
	}
}