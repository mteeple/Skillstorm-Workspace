package demo;

import java.util.LinkedList;
import java.util.Queue;


public class ProducerConsumerExample {
	public static void main(String[] args) {
		ThreadsafeBuffer<String> buffer = new ThreadsafeBuffer();
		new Thread(()->{
			while(true) {
				try {
					buffer.add("Hello");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		new Thread(() ->{
			while(true) {
				try {
					System.out.println(buffer.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}).start();

	}
}

//data structure    --LinkedList <type>
//consumer -synchronizing on this
class ThreadsafeBuffer<E>{
	Queue<E> buffer =new LinkedList<>();
	int capacity = 4; //buffer cannot have infinite capacity and we can run out of memory
	//consumer syncrhonizing on this
	public synchronized E take() throws InterruptedException {
		//cant take when buffer is empty
		while(buffer.isEmpty()){
			wait(); //release the lock
		}
		E obj = buffer.poll();
		System.out.println("Removed object");
		notify(); // I took something so its not full anymore
		return obj;
		
	}
	public void add(E obj) throws InterruptedException {
		synchronized (this){
			while(buffer.size() >= capacity) {
				wait();
			}
			
			buffer.add(obj);
			System.out.println("Added object");
			notify();
		}
	}
}
