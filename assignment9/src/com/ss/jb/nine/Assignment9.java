/**
 * 
 */
package com.ss.jb.nine;

/**
 * @author Cesar Camarena
 *
 */
public class Assignment9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Implement a Singleton with double checked locking.
		SingletonClass singleton = SingletonClass.getInstance();
		singleton.printMessage();
	}

}
