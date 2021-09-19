package com.ss.lma.domain;

import java.io.Serializable;
import java.util.Objects;

public class BookGenres implements Serializable {

	private static final long serialVersionUID = -18627364619265242L;
	private int genre_id;
	private int bookId;
	private Book book;
	private Genre genre;
	
	public BookGenres() {
		super();
	}
	
	public BookGenres(int genre_id, int bookId, Book book, Genre genre) {
		super();
		this.genre_id = genre_id;
		this.bookId = bookId;
		this.book = book;
		this.genre = genre;
	}

	public int getGenre_id() {
		return genre_id;
	}

	public void setGenre_id(int genre_id) {
		this.genre_id = genre_id;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookId, genre_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookGenres other = (BookGenres) obj;
		return bookId == other.bookId && genre_id == other.genre_id;
	}

	@Override
	public String toString() {
		return "BookGenres [genre_id=" + genre_id + ", bookId=" + bookId + ", book=" + book + ", genre=" + genre + "]";
	}

}
