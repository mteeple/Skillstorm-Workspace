package loops;

public class NestedLoop {
	public static void main(String[] args) {
		int counter = 0;
		for (int hour = 0; hour < 24; hour++) {
			for (int minute = 0; minute < 60; minute++) {
				System.out.println(hour + ":" + minute);
				counter++;
			}
		}
		System.out.println(counter);
	}
}
