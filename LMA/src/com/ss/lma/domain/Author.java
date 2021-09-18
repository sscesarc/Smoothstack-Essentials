package com.ss.lma.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Author implements Serializable {
	
	private static final long serialVersionUID = -7790772516821620171L;
	private int authorId;
	private String authorName;
	private List<BookAuthors> bookAuthors;

	public Author(int authorId, String authorName, List<BookAuthors> bookAuthors) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.bookAuthors = bookAuthors;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public List<BookAuthors> getBookAuthors() {
		return bookAuthors;
	}

	public void setBookAuthors(List<BookAuthors> bookAuthors) {
		this.bookAuthors = bookAuthors;
	}

	@Override
	public int hashCode() {
		return Objects.hash(authorId, authorName, bookAuthors);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		return authorId == other.authorId && Objects.equals(authorName, other.authorName)
				&& Objects.equals(bookAuthors, other.bookAuthors);
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName + ", bookAuthors=" + bookAuthors + "]";
	}
	
}
