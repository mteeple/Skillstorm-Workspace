package collections;

//two classes in the same file - only ONE class can be public though
public class Outer{
	int prop;
	
	//HAS-A
	class Inner{ //nested class
		int x;
		
		public void go() {
			//this.prop =10;   //This doesn't work as prop will not be passed into this inner class
		}
		
	}
} //end of the class body

class Animal{
	
}