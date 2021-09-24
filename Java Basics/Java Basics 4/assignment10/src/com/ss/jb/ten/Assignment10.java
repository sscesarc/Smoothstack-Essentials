package com.ss.jb.ten;


/**
 * @author Cesar Camarena
 *
 */
public class Assignment10 {

	public static String s1 = "string1";
	public static String s2 = "string2";
	
	public static void main(String[] args) {
		//Write a program to create a deadlock between two threads.
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		
		t1.start();
		t2.start();
	}
	
	private static class Thread1 extends Thread{
		public void run() {
			try {
				synchronized (s1) {
					Thread.sleep(100);
					synchronized (s2) {
						System.out.println("Thread one is running");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private static class Thread2 extends Thread{
		public void run() {
			try {
				synchronized (s2) {
					Thread.sleep(100);
					synchronized (s1) {
						System.out.println("Thread two is running");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}