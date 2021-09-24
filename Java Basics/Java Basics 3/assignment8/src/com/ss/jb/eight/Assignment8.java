/**
 * 
 */
package com.ss.jb.eight;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Cesar Camarena
 *
 */
public class Assignment8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Write a Java program that counts the number of times a particular character, such as 'e', appears in a file. The character can be specified at the command line.
		if (args.length == 0) {
			System.out.println("Please enter a letter to search for in the file.");
			return;
		}
		
		Integer count = 0;
		char letter = args[0].charAt(0);
		try (Scanner in = new Scanner(System.in)) {
			System.out.println("Enter the directory of the file: ");
			String filePath = in.nextLine();
			File file = new File(filePath);
			if (file.exists()) {
				try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
					String line = null;
					while ((line = reader.readLine()) != null) {
						for (int i = 0; i < line.length(); i++) {
							if (line.charAt(i) == letter) {
								count++;
							}
						}
					}
				} catch (FileNotFoundException e) {
					System.out.println("Exception Occured" + e);
				} catch (IOException e) {
					System.out.println("Exception Occured" + e);
				}
				
				System.out.println("There are " + count + " " + letter + "'s in the file.");
			}
			else {
				System.out.println("File does not exist.");
			}
		}
		

	}

}
