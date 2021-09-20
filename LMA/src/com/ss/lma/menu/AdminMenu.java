package com.ss.lma.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

import com.ss.lma.service.AuthorAdminService;
import com.ss.lma.service.BookAdminService;
import com.ss.lma.service.BookLoansAdminService;
import com.ss.lma.service.BorrowerAdminService;
import com.ss.lma.service.LibraryBranchAdminService;
import com.ss.lma.service.PublisherAdminService;

public class AdminMenu {

	public static void main() {
        System.out.println("1) Add/Update/Delete/Read Books");
        System.out.println("2) Add/Update/Delete/Read Authors");
        System.out.println("3) Add/Update/Delete/Read Publishers");
        System.out.println("4) Add/Update/Delete/Read Library Branches");
        System.out.println("5) Add/Update/Delete/Read Borrowers");
        System.out.println("6) Over-ride Due Date for a Book Loan");

        System.out.println();
        
		try (Scanner in = new Scanner(System.in)) {
			
			String input = in.next();
			
			Integer choice = Integer.parseInt(input);
				
			switch (choice) {
				case 1: BooksMenu();
					break;
					
				case 2: AuthorsMenu();
					break;
					
				case 3: PublishersMenu();
					break;
					
				case 4: BranchesMenu();
					break;
					
				case 5: BorrowersMenu();
					break;
					
				case 6: BookLoansMenu();
			}
				
		}
	}

	private static void BooksMenu() {
        BookAdminService service = new BookAdminService();
        
        System.out.println("1) Add Book");
        System.out.println("2) Update Book");
        System.out.println("3) Delete Book");
        System.out.println("4) Read all Books");

        System.out.println();

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int choice;
		try {
			choice = Integer.parseInt(in.readLine());
			
			switch (choice) {
			case 1: service.addBook();
				break;
				
			case 2: service.updateBook();
				break;
				
			case 3: service.deleteBook();
				break;
				
			case 4: service.readAllBooks();
				break;
			}
		} catch (SQLException | NumberFormatException | IOException e) {
			System.out.println("Error.");
			e.printStackTrace();
		}
	}

	private static void AuthorsMenu() {
        AuthorAdminService service = new AuthorAdminService();
        
        System.out.println("1) Add Author");
        System.out.println("2) Update Author");
        System.out.println("3) Delete Author");
        System.out.println("4) Read all Authors");

        System.out.println();

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int choice;
		try {
			choice = Integer.parseInt(in.readLine());
			
			switch (choice) {
			case 1: service.addAuthor();
				break;
				
			case 2: service.updateAuthor();
				break;
				
			case 3: service.deleteAuthor();
				break;
				
			case 4: service.readAllAuthors();
				break;
			}
		} catch (SQLException | NumberFormatException | IOException e) {
			System.out.println("Error.");
			e.printStackTrace();
		}
		
	}

	private static void PublishersMenu() {
        PublisherAdminService service = new PublisherAdminService();
        
        System.out.println("1) Add Publisher");
        System.out.println("2) Update Publisher");
        System.out.println("3) Delete Publisher");
        System.out.println("4) Read all Publishers");

        System.out.println();

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int choice;
		try {
			choice = Integer.parseInt(in.readLine());
			
			switch (choice) {
			case 1: service.addPublisher();
				break;
				
			case 2: service.updatePublisher();
				break;
				
			case 3: service.deletePublisher();
				break;
				
			case 4: service.readAllPublishers();
				break;
			}
		} catch (SQLException | NumberFormatException | IOException e) {
			System.out.println("Error.");
			e.printStackTrace();
		}
		
	}

	private static void BranchesMenu() {
        LibraryBranchAdminService service = new LibraryBranchAdminService();
        
        System.out.println("1) Add Branch");
        System.out.println("2) Update Branch");
        System.out.println("3) Delete Branch");
        System.out.println("4) Read all Branches");

        System.out.println();

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int choice;
		try {
			choice = Integer.parseInt(in.readLine());
			
			switch (choice) {
			case 1: service.addBranch();
				break;
				
			case 2: service.updateBranch();
				break;
				
			case 3: service.deleteBranch();
				break;
				
			case 4: service.readAllBranches();
				break;
			}
		} catch (SQLException | NumberFormatException | IOException e) {
			System.out.println("Error.");
			e.printStackTrace();
		}
		
	}

	private static void BorrowersMenu() {
        BorrowerAdminService service = new BorrowerAdminService();
        
        System.out.println("1) Add Borrower");
        System.out.println("2) Update Borrower");
        System.out.println("3) Delete Borrower");
        System.out.println("4) Read all Borrowers");

        System.out.println();

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int choice;
		try {
			choice = Integer.parseInt(in.readLine());
			
			switch (choice) {
			case 1: service.addBorrower();
				break;
				
			case 2: service.updateBorrower();
				break;
				
			case 3: service.deleteBorrower();
				break;
				
			case 4: service.readAllBorrowers();
				break;
			}
		} catch (SQLException | NumberFormatException | IOException e) {
			System.out.println("Error.");
			e.printStackTrace();
		}
		
	}

	private static void BookLoansMenu() {
		BookLoansAdminService service = new BookLoansAdminService();
		
		try {
			service.overrideBookLoan();
		} catch (SQLException e) {
			System.out.println("Error.");
			e.printStackTrace();
		}
	}

}
