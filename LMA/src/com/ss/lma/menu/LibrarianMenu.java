package com.ss.lma.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ss.lma.domain.Author;
import com.ss.lma.domain.Book;
import com.ss.lma.domain.BookCopies;
import com.ss.lma.domain.LibraryBranch;
import com.ss.lma.service.LibrarianService;

public class LibrarianMenu {

	private static LibrarianService service = new LibrarianService();
	
	public static void main() {
		System.out.println("1) Enter Branch you manage");
		System.out.println("2) Quit to previous");
		System.out.println();
		
		try (Scanner in = new Scanner(System.in)) {
			
			Integer choice = in.nextInt();
			
			switch (choice) {
				case 1: branches();
					break;
					
				case 2: MainMenu.menu();
					break;
				}
			}
		
	}
	
	private static void branches() {
		List<LibraryBranch> branches = new ArrayList<>();
		
		try {
			branches = service.readAllBranches();
		} catch (ClassNotFoundException | SQLException e1) {
			System.out.println("An error has occured.");
			e1.printStackTrace();
		}
		
		int count = 1;
		
		for (LibraryBranch lb : branches) {
			System.out.println(count + ") " + lb.getBranchName() + ", " + lb.getBranchAddress());
			count++;
		}
		
		System.out.println(count + ") Quit to previous");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int choice;
		try {
			choice = Integer.parseInt(in.readLine());
			
			if (choice == count) {
				main();
			}
			
			services(branches.get(choice - 1));
			
		} catch (NumberFormatException | IOException e1) {
			System.out.println("An error has occured.");
			e1.printStackTrace();
		}
		
	}
	
	private static void services(LibraryBranch branch) {
        System.out.println("1) Update the details of the library");
        System.out.println("2) Add copies of Book to the Branch");
        System.out.println("3) Quit to previous");
        
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int choice;
		try {
			choice = Integer.parseInt(in.readLine());
			
			switch (choice) {
				case 1: updateBranch(branch);
					break;
				
				case 2: updateBooks(branch);
					break;
					
				case 3: branches();
					break;
			}
		} catch (NumberFormatException | IOException e1) {
			System.out.println("An error has occured.");
			e1.printStackTrace();
		}
	}
	
	private static void updateBranch(LibraryBranch lb) {
        System.out.println("You have chosen to update the Branch with Branch Id: " + lb.getBranchId() + " and Branch Name: " + lb.getBranchName());
        System.out.println("Enter 'quit' at any prompt to cancel operation.\n");
        
        System.out.println("Please enter new branch name or enter N/A for no change:");
        
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String name;
		String address;
		try {
			name = in.readLine();
			
			if ("quit".equals(name)) {
				services(lb);
			} else if ("N/A".equals(name)){
				service.updateBranchName(lb.getBranchId(), lb.getBranchName());
			} else {
				service.updateBranchName(lb.getBranchId(), name);
			}
			
			System.out.println("Please enter new branch address or enter N/A for no change:");
			address = in.readLine();
			
			if ("quit".equals(address)) {
				services(lb);
			} else if ("N/A".equals(name)) {
				service.updateBranchAddress(lb.getBranchId(), lb.getBranchAddress());
			} else {
				service.updateBranchAddress(lb.getBranchId(), address);
			}
			
			System.out.println("Branch has been updated.");
			
			updateBooks(lb);
		} catch (SQLException | NumberFormatException | IOException e1) {
			System.out.println("An error has occured.");
			e1.printStackTrace();
		}
	}
	
	private static void updateBooks(LibraryBranch lb) {
		List<Book> books = new ArrayList<>();
		BookCopies copy = new BookCopies();
		
		try {
			books = service.readAllBooks();
			System.out.println("Pick the book you want to add copies of to your branch");
			
			Integer count = 1;
			for (Book b : books) {
				Author author = service.readAuthorFromId(b.getAuthId());
				
				System.out.println(count + ") " + b.getTitle() + " by " + author.getAuthorName());
				
				count++;
			}
			
			System.out.println(count + ") Quit to previous\n");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			Integer choice = Integer.parseInt(in.readLine());
			
			if (choice == count) {
				services(lb);
			}
			
			copy = service.getBookCopy(books.get(choice - 1).getBookId(), lb.getBranchId());
			
			System.out.println("Existing number of copies: " + copy.getNoOfCopies());
			
			System.out.println("Enter new number of copies: \n");
			
			Integer num = Integer.parseInt(in.readLine());
			
			service.updateCopies(copy, num);
			
			services(lb);
			
		} catch (SQLException | NumberFormatException | IOException e) {
			System.out.println("An error has occured.");
			e.printStackTrace();
		}
		
	}

}
