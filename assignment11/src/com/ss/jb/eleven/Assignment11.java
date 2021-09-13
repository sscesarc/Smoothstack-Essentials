/**
 * 
 */
package com.ss.jb.eleven;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cesar Camarena
 *
 */
public class Assignment11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Write a program with one thread (the producer) that produces items (in this case, simple ints). 
		// Another thread (the consumer) consumes items. For communication purposes, both threads have access
		// to a bounded buffer which is basically an array.
		List<Integer> buffer = new ArrayList<>(10);
		
		Thread t1 = new Thread(new Producer(buffer));
		Thread t2 = new Thread(new Consumer(buffer));
		
		t1.start();
		t2.start();
	}

	private static class Producer implements Runnable {
		private List<Integer> buffer;
		Producer(List<Integer> buffer) {
			this.buffer = buffer;
		}
		
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					synchronized (buffer) {
						buffer.add(i);
						System.out.println("Produced: " + i);
						try {
							buffer.notify();
							buffer.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private static class Consumer implements Runnable {
		private List<Integer> buffer;
		Consumer (List<Integer> buffer) {
			this.buffer = buffer;
		}
		
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					synchronized (buffer) {
						while(buffer.size() == 0) {
							try {
								buffer.notify();
								buffer.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						
						Integer value = buffer.remove(0);
						System.out.println("Consumed: " + value);
						
						try {
							buffer.notify();
							buffer.wait();
						} catch(InterruptedException e) {
							e.printStackTrace();
						}
					}
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
