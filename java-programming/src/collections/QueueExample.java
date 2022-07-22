package collections;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExample {
	public static void main(String[] args) {
		//Queue <Employee> queue = new LinkedList<>(); //FIFO
		Queue <Employee> queue = new PriorityQueue<>(); //This is like a sorted queue, will pop the first ID, default has 11 spots
		queue.add(new Employee(4, "Dan", "Pickles"));
		queue.add(new Employee(1, "Breanna", "Taylor"));
		queue.add(new Employee(3, "Daniel", "Taylor"));
		queue.add(new Employee(2, "Jeff", "Gold"));
		System.out.println(queue.poll());
		System.out.println(queue.size());
		System.out.println(queue.poll());
		System.out.println(queue.size());
	}
}
