package com.ss.lma.menu;

import java.util.Scanner;

public class MainMenu {

	public static void main(String[] args) {
		menu();
	}
	
	public static void menu() {
		System.out.println("Welcome to the SS Library Management System. Which category of a user are you?: ");
		System.out.println("1) Librarian");
		System.out.println("2) Administrator");
		System.out.println("3) Borrower");
		System.out.println("4) exit");
		
		try (Scanner in = new Scanner(System.in)) {
			
			String input = in.next();
			
			Integer choice = Integer.parseInt(input);
				
			switch (choice) {
				case 1: LibrarianMenu.main();
					break;
					
				case 2: AdminMenu.main();
					break;
					
				case 3: BorrowerMenu.main();
					break;
			}
				
		}
	}

}
