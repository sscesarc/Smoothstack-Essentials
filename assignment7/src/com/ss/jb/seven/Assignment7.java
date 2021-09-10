/**
 * 
 */
package com.ss.jb.seven;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Cesar Camarena
 *
 */
public class Assignment7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Write a Java program to append text to an existing file.
		System.out.println("Enter a File directory to append: ");
		try (Scanner in = new Scanner(System.in)) {
			String appendFile = in.nextLine();
			File file = new File (appendFile);
			
			if (file.exists()) {
				displayFile(file);
				
				System.out.println("Enter text to append to file: ");
				String text = in.nextLine();
				
				appendFile(file, text);
				
				System.out.println("File with appended text.");
				
				displayFile(file);
			}
			else {
				System.out.println("Cannot find the file.");
			}
		}
	}
	
	//Parameters: File for the text to be read and printed onto the screen
	public static void displayFile(File file) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Exception Occured" + e);
		} catch (IOException e) {
			System.out.println("Exception Occured" + e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					System.out.println("Exception Occured" + e);
				}
			}
		}
	}
	
	//Parameters: File containing only text, and the text to append to the file
	public static void appendFile(File file, String text) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(file, true));
			writer.write(text);
		} catch (IOException e) {
			System.out.println("Exception Occured" + e);
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					System.out.println("Exception Occured" + e);
				}
			}
		}
	}

}
