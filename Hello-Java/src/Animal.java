//only 1 public class per final. name of file==classname
public abstract class Animal { //parent/super
	int lifespan;
	public abstract void speak();
	public void hello() {
		System.out.println("Hello");
	}
}

class Dog extends Animal implements Hunter{ //child/sub
	public void birth() {
		lifespan=15;
	}
	public void speak() {//overriding the other speak
		System.out.println("Bark");
	}
	@Override
	public void hunt() {
		// TODO Auto-generated method stub
		
	}
}

