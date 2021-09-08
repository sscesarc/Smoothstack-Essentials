/**
 * 
 */
package com.ss.jb.five;

/**
 * @author Cesar Camarena
 *
 */
public class Rectangle implements Shape {
	int area;
	int length = 2;
	int width = 5;
	
	public void calculateArea() {
		area = length * width;
	}

	public void display() {
		calculateArea();
		System.out.println("The area of the Rectangle is: " + area);
	}	
}