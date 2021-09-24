/**
 * 
 */
package com.ss.jb.five;

/**
 * @author Cesar Camarena
 *
 */
public class Circle implements Shape{
	int area;
	int radius = 5;

	public void calculateArea() {
		area = (int) Math.PI * (radius * radius);
	}

	public void display() {
		calculateArea();
		System.out.println("The area of the Circle is: " + area);
	}
}
