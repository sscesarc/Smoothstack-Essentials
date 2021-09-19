package com.ss.lma.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Book implements Serializable {
	
	private static final long serialVersionUID = -1993541049317852727L;
	private int bookId;
	private String title;
	private int authId;
	private int pubId;
	private Publisher publisher;
	private List<BookAuthors> bookAuthors;
	private List<BookGenres> bookGenres;
	private List<BookLoans> bookLoans;
	private List<BookCopies> bookCopies;
	
	public Book() {
		super();
	}

	public Book(int bookId, String title, int authId, int pubId, Publisher publisher, List<BookAuthors> bookAuthors,
			List<BookGenres> bookGenres, List<BookLoans> bookLoans, List<BookCopies> bookCopies) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.authId = authId;
		this.pubId = pubId;
		this.publisher = publisher;
		this.bookAuthors = bookAuthors;
		this.bookGenres = bookGenres;
		this.bookLoans = bookLoans;
		this.bookCopies = bookCopies;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAuthId() {
		return authId;
	}

	public void setAuthId(int authId) {
		this.authId = authId;
	}

	public int getPubId() {
		return pubId;
	}

	public void setPubId(int pubId) {
		this.pubId = pubId;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public List<BookAuthors> getBookAuthors() {
		return bookAuthors;
	}

	public void setBookAuthors(List<BookAuthors> bookAuthors) {
		this.bookAuthors = bookAuthors;
	}

	public List<BookGenres> getBookGenres() {
		return bookGenres;
	}

	public void setBookGenres(List<BookGenres> bookGenres) {
		this.bookGenres = bookGenres;
	}

	public List<BookLoans> getBookLoans() {
		return bookLoans;
	}

	public void setBookLoans(List<BookLoans> bookLoans) {
		this.bookLoans = bookLoans;
	}

	public List<BookCopies> getBookCopies() {
		return bookCopies;
	}

	public void setBookCopies(List<BookCopies> bookCopies) {
		this.bookCopies = bookCopies;
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
		Book other = (Book) obj;
		return bookId == other.bookId;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", authId=" + authId + ", pubId=" + pubId
				+ ", publisher=" + publisher + ", bookAuthors=" + bookAuthors + ", bookGenres=" + bookGenres
				+ ", bookLoans=" + bookLoans + ", bookCopies=" + bookCopies + "]";
	}

	
}
