/**
 * 
 */
package com.ss.jb.one;

import java.lang.StringBuilder;
/**
 * @author Cesar Camarena
 *
 */
public class Assignment1 {

	public static void main(String[] args) {
//		1)
//		*
//		**
//		***
//		****
//		.........
		
		System.out.println("1)");
		String string = "";
		for(int i = 0; i < 4; i++) {
			string = string + "*";
			System.out.println(string);
		} string = "";
		
		for(int i = 0; i < 9; i++) {
			string = string + ".";
		} System.out.println(string);
		string = "";
		
//		2)
//		..........
//		****
//		***
//		**
//		*
		System.out.println("2)");
		for(int i = 0; i < 10; i++) {
			string = string + ".";
		} System.out.println(string);
		string = "";
		
		for (int i = 4; i > 0; i--) {
			string = new String(new char[i]).replace("\0", "*");
			System.out.println(string);
		} string = "";
		
//		3)
//		     *
//		    ***
//		   *****
//		  *******
//		...........
		
		System.out.println("3)");
		String firstAsterisk = "*";
		String asterisks = "";
		String space = "     ";

		for (int i = 0; i < 4; i++) {
			System.out.println(space + asterisks + firstAsterisk + asterisks + space);
			space = space.substring(0, space.length() - 1);
			asterisks = asterisks + "*";
		} string = "";
		
		for(int i = 0; i < 11; i++) {
			string = string + ".";
		} System.out.println(string);
		string = "";
		
//		4)
//		............
//		  *******
//		   *****
//		    ***
//		     *
		
		System.out.println("4)");
		for(int i = 0; i < 11; i++) {
			string = string + ".";
		} System.out.println(string);
		string = "";
		
		firstAsterisk = "*";
		asterisks = "***";
		space = "  ";
		
		System.out.println(space + asterisks + firstAsterisk + asterisks + space);
		for (int i = 0; i < 3; i++) {
			space = space + " ";
			asterisks = asterisks.substring(0, asterisks.length() - 1);
			System.out.println(space + asterisks + firstAsterisk + asterisks + space);
		}
	}

}
