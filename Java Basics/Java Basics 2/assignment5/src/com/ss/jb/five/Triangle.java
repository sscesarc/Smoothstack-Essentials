/**
 * 
 */
package com.ss.jb.five;

/**
 * @author Cesar Camarena
 *
 */
public class Triangle implements Shape {
	int area;
	int base = 2;
	int height = 5;

	public void calculateArea() {
		area = (int) (base * height) / 2;
	}

	public void display() {
		calculateArea();
		System.out.println("The area of the Triangle is: " + area);
	}
}
