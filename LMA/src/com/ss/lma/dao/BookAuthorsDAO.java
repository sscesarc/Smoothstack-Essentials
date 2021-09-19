package com.ss.lma.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.lma.domain.BookAuthors;

public class BookAuthorsDAO extends BaseDAO<BookAuthors> {

	public BookAuthorsDAO(Connection conn) {
		super(conn);
	}

	public Integer addBookAuthor(BookAuthors bookAuthor) throws ClassNotFoundException, SQLException {
		return saveReturnPK("insert into tbl_book_authors (bookId, authorId) values (?, ?)", new Object[] {bookAuthor.getBookId(), bookAuthor.getAuthorId()});
	}
	
	public List<BookAuthors> readAllBookAuthors() throws ClassNotFoundException, SQLException {
		return read("select * from tbl_book_authors", null);
	}
	
	public void updateBookAuthorByAuthorId(BookAuthors bookAuthor) throws ClassNotFoundException, SQLException {
		save("update tbl_book_authors set authorId = ? where bookId = ?", new Object[] {bookAuthor.getAuthorId(), bookAuthor.getBookId()});
	}
	
	public void updateBookAuthorByBookId(BookAuthors bookAuthor) throws ClassNotFoundException, SQLException {
		save("update tbl_book_authors set bookId = ? where authorId = ?", new Object[] {bookAuthor.getBookId(), bookAuthor.getAuthorId()});
	}
	
	public void deleteBookAuthor(BookAuthors bookAuthor) throws ClassNotFoundException, SQLException {
		save("delete from tbl_book_authors where bookId = ? and authorId = ?", new Object[] {bookAuthor.getBookId(), bookAuthor.getAuthorId()});
	}
	
	public List<BookAuthors> extractData(ResultSet rs) throws SQLException {
		List<BookAuthors> list = new ArrayList<>();
		while(rs.next()) {
			BookAuthors bookAuthor = new BookAuthors();
			bookAuthor.setBookId(rs.getInt("bookId"));
			bookAuthor.setAuthorId(rs.getInt("authorId"));
			list.add(bookAuthor);
		}
		return list;
	}
}
