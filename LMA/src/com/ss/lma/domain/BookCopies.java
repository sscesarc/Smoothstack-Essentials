package com.ss.lma.domain;

import java.io.Serializable;
import java.util.Objects;

public class BookCopies implements Serializable {

	private static final long serialVersionUID = 5430669710947366787L;
	private int bookId;
	private int branchId;
	private int noOfCopies;
	private Book book;
	private LibraryBranch branch;
	
	public BookCopies() {
		super();
	}
	
	public BookCopies(int bookId, int branchId, int noOfCopies, Book book, LibraryBranch branch) {
		super();
		this.bookId = bookId;
		this.branchId = branchId;
		this.noOfCopies = noOfCopies;
		this.book = book;
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

	public int getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public LibraryBranch getBranch() {
		return branch;
	}

	public void setBranch(LibraryBranch branch) {
		this.branch = branch;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookId, noOfCopies);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookCopies other = (BookCopies) obj;
		return bookId == other.bookId && noOfCopies == other.noOfCopies;
	}

	@Override
	public String toString() {
		return "BookCopies [bookId=" + bookId + ", branchId=" + branchId + ", noOfCopies=" + noOfCopies + ", book="
				+ book + ", branch=" + branch + "]";
	}

}
