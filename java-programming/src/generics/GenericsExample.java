package generics;

import java.util.ArrayList;

public class GenericsExample {
	public static void main(String[] args) {
		//boolean, int, short, long, float, double, char ,byte
		//String = class
		//Wrapper classes
		Boolean bool;
		Integer i;
		Short s;
		Character c;
		
		//arraylist mutable in size( default 16 spaces, grows by 50% when maxed
		int[] array = new int[5];
		//By giving it string we give it a generic compile type safety
		ArrayList<String> arraylist = new ArrayList<>(); // if you say ArrayList(50) instead of 16 space it's now 50, so when maxed goes to 75
		arraylist.add("String");
		//arraylist.add(100); // no longer allowed in due to it being String generic
	}
}
