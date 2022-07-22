package collections;

import java.util.Deque;
import java.util.LinkedList;

public class DequeExample {
	public static void main(String[] args) {
		Deque<Employee> queue = new LinkedList<>(); //LIFO, but technically it's a double linked list so you can do both
		queue.add(new Employee(4, "Dan", "Pickles"));
		queue.add(new Employee(1, "Breanna", "Taylor"));
		queue.add(new Employee(3, "Daniel", "Taylor"));
		queue.add(new Employee(2, "Jeff", "Gold"));
		System.out.println(queue.peekFirst());
		System.out.println(queue.size());
		System.out.println(queue.pollFirst());
		System.out.println(queue.size());
		System.out.println(queue.pollFirst());
		System.out.println(queue.pollLast()); 
	}
}
