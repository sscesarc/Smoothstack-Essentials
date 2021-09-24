/**
 * 
 */
package com.ss.jb.nine;

/**
 * @author Cesar Camarena
 *
 */
public class SingletonClass {

		private static volatile SingletonClass instance;
		
		private SingletonClass() {
			//Empty constructor
		}
		
		public static SingletonClass getInstance() {
			if (instance == null) {
				synchronized (SingletonClass.class) {
					if (instance == null) {
						instance = new SingletonClass();
					}
				}
			}
			return instance;
		}
		
		public void printMessage() {
			System.out.println("Singleton Class");
		}
}
