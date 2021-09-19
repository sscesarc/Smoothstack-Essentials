package com.ss.lma.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class BookLoans implements Serializable {

	private static final long serialVersionUID = -4494359592817000067L;
	private int bookId;
	private int branchId;
	private int cardNo;
	private Timestamp dateOut;
	private Timestamp dueDate;
	private Timestamp dateIn;
	private Book book;
	private Borrower borrower;
	private LibraryBranch branch;
	
	public BookLoans() {
		super();
	}
	
	public BookLoans(int bookId, int branchId, int cardNo, Timestamp dateOut, Timestamp dueDate, Timestamp dateIn,
			Book book, Borrower borrower, LibraryBranch branch) {
		super();
		this.bookId = bookId;
		this.branchId = branchId;
		this.cardNo = cardNo;
		this.dateOut = dateOut;
		this.dueDate = dueDate;
		this.dateIn = dateIn;
		this.book = book;
		this.borrower = borrower;
		this.branch = branch;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public int getCardNo() {
		return cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}

	public Timestamp getDateOut() {
		return dateOut;
	}

	public void setDateOut(Timestamp dateOut) {
		this.dateOut = dateOut;
	}

	public Timestamp getDueDate() {
		return dueDate;
	}

	public void setDueDate(Timestamp dueDate) {
		this.dueDate = dueDate;
	}

	public Timestamp getDateIn() {
		return dateIn;
	}

	public void setDateIn(Timestamp dateIn) {
		this.dateIn = dateIn;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Borrower getBorrower() {
		return borrower;
	}

	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}

	public LibraryBranch getBranch() {
		return branch;
	}

	public void setBranch(LibraryBranch branch) {
		this.branch = branch;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookLoans other = (BookLoans) obj;
		return bookId == other.bookId;
	}

	@Override
	public String toString() {
		return "BookLoans [bookId=" + bookId + ", branchId=" + branchId + ", cardNo=" + cardNo + ", dateOut=" + dateOut
				+ ", dueDate=" + dueDate + ", dateIn=" + dateIn + ", book=" + book + ", borrower=" + borrower
				+ ", branch=" + branch + "]";
	}

}
