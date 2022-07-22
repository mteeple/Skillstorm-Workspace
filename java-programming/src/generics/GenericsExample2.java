package generics;

public class GenericsExample2 {
	
	static int classScope =1; //shared by all instances of this object
	int instanceScope=2; //only that object
	public static void main(String[] args) {
		int primitive = 10;
		//wrapping - boxing
		Integer wrapper = new Integer(100);
		//unwrapping - unboxing
		primitive = wrapper.intValue();
		
		//auto-boxing
		Integer x =10;
		int prim=x;
		
		GenericsExample2 obj = new GenericsExample2();
		obj.instanceScope=100;
		
		GenericsExample2 obj2 = new GenericsExample2();
		obj2.instanceScope=200;
		
		String str = "Hello";
		String str2 = new String("Hello");
		System.out.println(str ==str2); //primitives - because its a new object it doesn't share location -> false
		System.out.println(str.equals(str2)); //equivalent in value -> true
	}
}
