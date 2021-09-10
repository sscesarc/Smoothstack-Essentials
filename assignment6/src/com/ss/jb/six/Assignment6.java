/**
 * 
 */
package com.ss.jb.six;

import java.io.File;
import java.util.Scanner;

/**
 * @author Cesar Camarena
 *
 */
public class Assignment6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Write a Java program to get a list of all file/directory names (including in subdirectories) under a given directory.
		System.out.println("Type in a directory to search: ");
		try (Scanner in = new Scanner(System.in)) {
			String directory = in.nextLine();
			File folder = new File (directory);
			
			if (folder.exists()) {
				System.out.println("Listing out directory given: " + directory);
			}
			
			listDirectory(folder);
		}
	}
	
	public static void listDirectory(File folder) {
		try {
			for (File file : folder.listFiles()) {
				if (file.isDirectory()) {
					System.out.println("SubDirectory: " + file);
					listDirectory(file);
				}
				else {
					System.out.println(file.getName());
				}
			}
		} catch (Exception e) {
			System.out.println("No directory found.");
		}
	}

}
