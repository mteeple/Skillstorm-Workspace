package demo;
/*
 * ONLY 1 instance of this bean ever
 * 
 * Stateless - doesn't store any of the application states, usually just does processing
 * 
 * 
 */
public class Singleton {
	private static Singleton INSTANCE;
	private static Object lock = new Object();
	
	//static { //static initializer /block
	//	INSTANCE = new Singleton(); // Eagerly loaded - Load when the ClassLoader starts (pre-main)
	//}
	
	//no one can call the constructor directly
	private Singleton() {
		
	} //Big difference between the two is that too many eagerly loading slows start up App time
	//Eagerly loaded singleton
	//It needs to jump in and load components stuff quickly/right away
	
	//Lazy loaded singleton
	//Can wait until the user requests, and not initialized in JVM until asked
	public static Singleton getInstance() { //Loads for the LazySingleton
		//if instance is null, create it
		// if not null, return it
		synchronized (lock) {
			if(INSTANCE == null) {
				INSTANCE = new Singleton();
			}
		}
//		if(INSTANCE == null) {
//			INSTANCE = new Singleton();
//		}
		return INSTANCE;
	}
}
