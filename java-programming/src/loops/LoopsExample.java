package loops;

import java.util.Random;

public class LoopsExample {
	public static void main(String[] args) {
		int[] a = { 5, 80, 2, 35 };
		int[] array = new int[5];

		array[0] = 100;
		array[1] = 101;
		Fish[] bucket = new Fish[5];

		for (int x : a) { // iterable loop
			System.out.println(x);
		}

		while (doCheck()) {
			System.out.println("while...");
		}
		do {
			System.out.println("do while");
		} while (doCheck());

		maths();
	}

	static void maths() {
		System.out.println(Math.random());
	}

	static boolean doCheck() {
		Random random = new Random();
		// ternary operator
		return random.nextInt() > 0 ? true : false; // Random is higher than 0 ? if yes = true else false

	}
}

class Fish {}
