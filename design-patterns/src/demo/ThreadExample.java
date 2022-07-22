package demo;

public class ThreadExample {
	public static void main(String[] args) throws InterruptedException {
		// System.out.println(Singleton.getInstance()); //eager
		int number = 100;
		SeparateTask task = new SeparateTask(number);
		Thread thread = new Thread(task);
		thread.start();
		thread.join();

		System.out.println(task.value);

	}
}

//Functional Interface (defines 1 method only) - using it below
// Marker interface (Defines no methods)
class SeparateTask implements Runnable{
	public int value;
	public SeparateTask(int value) {
		this.value = value;
	}
	public void run() {
		System.out.println(this.value/2);
		//for (int i = 0; i < 10; i++) {
		//	System.out.println("Running...");
		//}
	}
}