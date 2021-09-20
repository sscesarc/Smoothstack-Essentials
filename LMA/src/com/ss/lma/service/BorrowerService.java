package com.ss.lma.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ss.lma.dao.AuthorDAO;
import com.ss.lma.dao.BookCopiesDAO;
import com.ss.lma.dao.BookDAO;
import com.ss.lma.dao.BookLoansDAO;
import com.ss.lma.dao.BorrowerDAO;
import com.ss.lma.dao.LibraryBranchDAO;
import com.ss.lma.domain.Author;
import com.ss.lma.domain.Book;
import com.ss.lma.domain.BookCopies;
import com.ss.lma.domain.BookLoans;
import com.ss.lma.domain.Borrower;
import com.ss.lma.domain.LibraryBranch;

public class BorrowerService {

	ConnectionUtil connUtil = new ConnectionUtil();

	public List<Borrower> readAllBorrowers() throws SQLException {
		Connection conn = null;
		List<Borrower> borrowers = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			BorrowerDAO bdao = new BorrowerDAO(conn);
			borrowers = bdao.readAllBorrowers();
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return borrowers;
	}

	public List<LibraryBranch> readAllBranches() throws SQLException {
		Connection conn = null;
		List<LibraryBranch> branches = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			LibraryBranchDAO lbdao = new LibraryBranchDAO(conn);
			branches = lbdao.readAllLibraryBranches();
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return branches;
	}

	public List<Book> readAllBooksWithCopies(Integer branchId) throws SQLException {
		Connection conn = null;
		List<Book> books = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			BookDAO bdao = new BookDAO(conn);
			books = bdao.readBooksWithCopy(branchId);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return books;
	}

	public Author readAuthorFromId(Integer authId) throws SQLException {
		Connection conn = null;
		Author author = new Author();
		try {
			conn = connUtil.getConnection();
			AuthorDAO adao = new AuthorDAO(conn);
			author = adao.readAuthorById(authId);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return author;
	}

	public void checkOut(Integer bookId, Integer branchId, Integer cardNo) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookLoansDAO bldao = new BookLoansDAO(conn);
			BookLoans loan = new BookLoans();
			loan.setBookId(bookId);
			loan.setBranchId(branchId);
			loan.setCardNo(cardNo);
			loan.setDateOut(Timestamp.valueOf(LocalDateTime.now()));
			loan.setDueDate(Timestamp.valueOf(LocalDateTime.now().plusWeeks(1)));
			bldao.addBookLoan(loan);
			BookCopiesDAO bcdao = new BookCopiesDAO(conn);
			BookCopies copy = bcdao.readBookCopyById(bookId, branchId);
			copy.setNoOfCopies(copy.getNoOfCopies() - 1);
			bcdao.updateBookCopy(copy);
			conn.commit();
			System.out.println("Successfully check out a book");
		} catch (Exception e) {
			conn.rollback();
			System.out.println("Failed to check out book.");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public List<BookLoans> readLoans(Integer branchId, Integer cardNo) throws SQLException {
		Connection conn = null;
		List<BookLoans> loans = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			BookLoansDAO bldao = new BookLoansDAO(conn);
			loans = bldao.readLoansByCardNoAndBranchId(cardNo, branchId);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return loans;
	}

	public Book readBookFromId(Integer bookId) throws SQLException {
		Connection conn = null;
		Book book = new Book();
		try {
			conn = connUtil.getConnection();
			BookDAO bdao = new BookDAO(conn);
			book = bdao.readBookById(bookId);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return book;
	}

	public void returnBook(Integer bookId, Integer branchId, Integer cardNo) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookCopiesDAO bcdao = new BookCopiesDAO(conn);
			BookCopies copy = bcdao.readBookCopyById(bookId, branchId);
			copy.setNoOfCopies(copy.getNoOfCopies() + 1);
			bcdao.updateBookCopy(copy);
			BookLoansDAO bldao = new BookLoansDAO(conn);
			BookLoans loan = new BookLoans();
			loan.setBookId(bookId);
			loan.setBranchId(branchId);
			loan.setCardNo(cardNo);
			bldao.deleteBookLoan(loan);
			conn.commit();
			System.out.println("Book has been returned");
		} catch (Exception e) {
			System.out.println("Failed to return book");
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
}
