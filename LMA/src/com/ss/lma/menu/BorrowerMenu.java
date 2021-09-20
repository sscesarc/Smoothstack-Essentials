package com.ss.lma.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.lma.domain.Author;
import com.ss.lma.domain.Book;
import com.ss.lma.domain.BookLoans;
import com.ss.lma.domain.Borrower;
import com.ss.lma.domain.LibraryBranch;
import com.ss.lma.service.BorrowerService;

public class BorrowerMenu {

	private static BorrowerService service = new BorrowerService();
	
	public static void main() {
		System.out.println("Enter your card number: ");
		List<Borrower> borrowers;
		List<Integer> cardNos = new ArrayList<>();
		
		try {
			borrowers = service.readAllBorrowers();
			
			for (Borrower b : borrowers) {
				Integer cardNo = b.getCardNo();
				cardNos.add(cardNo);
			}
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			Integer cardNo = Integer.parseInt(in.readLine());
			
			for (Integer i : cardNos) {
				if (i == cardNo) {
					checkOutReturnMenu(cardNo);
				}
			}
			
			System.out.println("Card Number does not exist in the system. Please try again.");
			main();
			
		} catch (SQLException | NumberFormatException | IOException e) {
			System.out.println("An error has occured.");
			e.printStackTrace();
		}
		
	}
	
	private static void checkOutReturnMenu(int cardNo) {
        System.out.println("1) Check out a book");
        System.out.println("2) Return a book");
        System.out.println("3) Quit to previous");
        
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int choice;
		try {
			choice = Integer.parseInt(in.readLine());
			
			switch (choice) {
				case 1: checkOutBook(cardNo);
					break;
				
				case 2: returnBook(cardNo);
					break;
					
				case 3: MainMenu.menu();
					break;
			}
		} catch (NumberFormatException | IOException e1) {
			System.out.println("An error has occured.");
			e1.printStackTrace();
		}
	}
	
	private static void checkOutBook(int cardNo) {
		System.out.println("Pick the Branch you want to check out from: ");
		
		List<LibraryBranch> branches;
		try {
			branches = service.readAllBranches();
			
			int count = 1;
			for (LibraryBranch lb : branches) {
	            System.out.println(count + ") " + lb.getBranchName() + ", " + lb.getBranchAddress());
	            count++;
			}
			System.out.println(count + ") Quit to previous");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			int branchChoice = Integer.parseInt(in.readLine());
			
			if (branchChoice ==  count) {
				checkOutReturnMenu(cardNo);
			}
			
			System.out.println("Pick the Book you want to check out");
			
			List<Book> books = service.readAllBooksWithCopies(branches.get(branchChoice - 1).getBranchId());
			
			count = 1;
			
			for (Book b : books) {
				Author author = service.readAuthorFromId(b.getAuthId());
                System.out.println(count + ") " + b.getTitle() + " by " + author.getAuthorName());
                count++;
			}
			System.out.println(count + ") Quit to previous");
			
			int bookChoice = Integer.parseInt(in.readLine());
			
			if (bookChoice == count) {
				checkOutReturnMenu(cardNo);
			}
			
			service.checkOut(books.get(bookChoice - 1).getBookId(), branches.get(branchChoice - 1).getBranchId(), cardNo);
			
			checkOutReturnMenu(cardNo);
		} catch (SQLException | NumberFormatException | IOException e) {
			System.out.println("An error has occured.");
			e.printStackTrace();
		}
	}
	
	private static void returnBook(int cardNo) {
		System.out.println("Pick the Branch you want to check out from: ");
		List<LibraryBranch> branches;
		
		try {
			branches = service.readAllBranches();
			
			int count = 1;
			for (LibraryBranch lb : branches) {
	            System.out.println(count + ") " + lb.getBranchName() + ", " + lb.getBranchAddress());
	            count++;
			}
			System.out.println(count + ") Quit to previous");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			int branchChoice = Integer.parseInt(in.readLine());
			
			if (branchChoice ==  count) {
				checkOutReturnMenu(cardNo);
			}
			
			System.out.println("Pick the Book you want to return");
			
			List<BookLoans> loans = service.readLoans(branches.get(branchChoice - 1).getBranchId(), cardNo);
			
			count = 1;
			
			for (BookLoans bl : loans) {
				Book book = service.readBookFromId(bl.getBookId());
				Author author = service.readAuthorFromId(book.getAuthId());
				
                System.out.println(count + ") " + book.getTitle() + " by " + author.getAuthorName());
                count++;
			}
            System.out.println(count + ") Quit to previous");
			
            int bookChoice = Integer.parseInt(in.readLine());
            
            if (bookChoice == count) {
            	checkOutReturnMenu(cardNo);
            }
            
            service.returnBook(loans.get(bookChoice - 1).getBookId(), branches.get(branchChoice - 1).getBranchId(), cardNo);
            checkOutReturnMenu(cardNo);
		} catch (SQLException | NumberFormatException | IOException e) {
			System.out.println("An error has occured.");
			e.printStackTrace();
		}
		
		
	}

}
