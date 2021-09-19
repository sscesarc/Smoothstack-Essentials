package com.ss.lma.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Genre implements Serializable {

	private static final long serialVersionUID = 5104155470411987053L;
	private int genre_id;
	private String genre_name;
	private List<BookGenres> bookGenres;
	
	public Genre() {
		super();
	}
	
	public Genre(int genre_id, String genre_name, List<BookGenres> bookGenres) {
		super();
		this.genre_id = genre_id;
		this.genre_name = genre_name;
		this.bookGenres = bookGenres;
	}

	public int getGenre_id() {
		return genre_id;
	}

	public void setGenre_id(int genre_id) {
		this.genre_id = genre_id;
	}

	public String getGenre_name() {
		return genre_name;
	}

	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
	}

	public List<BookGenres> getBookGenres() {
		return bookGenres;
	}

	public void setBookGenres(List<BookGenres> bookGenres) {
		this.bookGenres = bookGenres;
	}

	@Override
	public int hashCode() {
		return Objects.hash(genre_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genre other = (Genre) obj;
		return genre_id == other.genre_id;
	}

	@Override
	public String toString() {
		return "Genre [genre_id=" + genre_id + ", genre_name=" + genre_name + ", bookGenres=" + bookGenres + "]";
	}
	
}
