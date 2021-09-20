package com.ss.lma.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.ss.lma.dao.BookDAO;
import com.ss.lma.dao.BookLoansDAO;
import com.ss.lma.dao.BorrowerDAO;
import com.ss.lma.domain.Book;
import com.ss.lma.domain.BookLoans;

public class BookLoansAdminService {
	
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public void overrideBookLoan() throws SQLException {
		Connection conn = null;
		BookLoans loan = new BookLoans();
		
		try {
			conn = connUtil.getConnection();
			BookLoansDAO bldao = new BookLoansDAO(conn);
			BookDAO bdao = new BookDAO(conn);
			BorrowerDAO brdao = new BorrowerDAO(conn);
			
			System.out.print("Enter Branch ID (or 'quit' to cancel: ");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			Integer branchId = Integer.parseInt(in.readLine());

			if ("quit".equals(branchId.toString())) {
				return;
			}
			
			System.out.print("Enter card number (or 'quit to cancel): ");
			
			Integer cardNo = Integer.parseInt(in.readLine());
			
			if ("quit".equals(cardNo.toString())) {
				return;
			}
			
			List<BookLoans> loans = bldao.readLoansByCardNoAndBranchId(cardNo, branchId);
			List<Book> books = bdao.readAllBooks();
			
			System.out.println(brdao.readAllBorrowers().get(cardNo - 1).getName());
			int count = 1;
			for (BookLoans bl : loans) {
				System.out.println(count + ") " + books.get(bl.getBookId() - 1).getTitle() + ", " + loans.get(bl.getBookId() - 1).getDueDate());
				count++;
			}
			
			System.out.print("Select book loan to override: ");
			
			int choice = Integer.parseInt(in.readLine());
			
			if (choice == count) {
				return;
			}
			
			loan = loans.get(choice - 1);
			
			loan.setDueDate(Timestamp.valueOf(LocalDateTime.now().plusWeeks(1)));
			
			bldao.updateBookLoan(loan);
			conn.commit();
			System.out.println("Loan has been overrided.");
		} catch (Exception e) {
			conn.rollback();
			System.out.println("Failed to override loan");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
}
