package com.ss.lma.domain;

import java.io.Serializable;
import java.util.Objects;

public class BookAuthors implements Serializable {

	private static final long serialVersionUID = -4649294979329281079L;
	private int bookId;
	private int authorId;
	private Author author;
	private Book book;
	
	public BookAuthors() {
		super();
	}

	public BookAuthors(int bookId, int authorId, Author author, Book book) {
		super();
		this.bookId = bookId;
		this.authorId = authorId;
		this.author = author;
		this.book = book;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public int hashCode() {
		return Objects.hash(authorId, bookId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookAuthors other = (BookAuthors) obj;
		return authorId == other.authorId && bookId == other.bookId;
	}

	@Override
	public String toString() {
		return "BookAuthors [bookId=" + bookId + ", authorId=" + authorId + ", author=" + author + ", book=" + book
				+ "]";
	}
	
}
