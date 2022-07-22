package collections;

import java.util.ArrayDeque;

public class Test {
	public static void main(String[] args) {
		ArrayDeque<Integer> test= new ArrayDeque<>();
        // Adding to front position
        test.addFirst(2);
        // adding to last
        test.addLast(3);
        //General add/offer
        test.offer(10);
        test.addLast(5);
        test.addFirst(0);
        test.add(20);
        System.out.println("ArrayDeque: " + test);
        int who = test.remove(); // Removes from the head
        System.out.println("Removed "+ who); //removed 0
        test.removeFirst(); //removes from head 2
        test.remove(20); //removes specific element 
        System.out.println("Peek " + test.peek());
        test.removeLast(); //removes from tail 5
        test.poll(); // removes 1
        System.out.println("ArrayDeque: " + test);

	}
}
