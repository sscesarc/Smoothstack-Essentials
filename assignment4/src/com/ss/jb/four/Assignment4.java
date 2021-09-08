/**
 * 
 */
package com.ss.jb.four;

import java.util.Arrays;

/**
 * @author Cesar Camarena
 *
 */
public class Assignment4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Construct a 2D array and find the max number and show its position in the array.
		int matrix[][] = { { 1, 2 },
		                   { 3, 16 },
		                   { 25, 4 },
		                   { 13, 17 },
		                   { 9, 15 } };
		
		int maxNumber = matrix[0][0];
		int x = 0;
		int y = 0;
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] > maxNumber) {
					maxNumber = matrix[i][j];
					x = i;
					y = j;
				}
			}
		}
		
		System.out.println("For the 2D array: " + Arrays.deepToString(matrix));
		System.out.print("Max number: " + maxNumber);
		System.out.print("\nPosition in the array: " + x + ", " + y);
	}

}
