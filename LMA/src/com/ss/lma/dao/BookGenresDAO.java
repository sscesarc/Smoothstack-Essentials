package com.ss.lma.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.lma.domain.BookGenres;

public class BookGenresDAO extends BaseDAO<BookGenres> {

	public BookGenresDAO(Connection conn) {
		super(conn);
	}

	public Integer addBookGenre(BookGenres bookGenre) throws ClassNotFoundException, SQLException {
		return saveReturnPK("insert into tbl_book_genres (genre_id, bookId) values (?, ?)", new Object[] {bookGenre.getGenre_id(), bookGenre.getBookId()});
	}
	
	public List<BookGenres> readAllBookGenres() throws ClassNotFoundException, SQLException {
		return read("select * from tbl_book_genres", null);
	}
	
	public void updateBookGenre(BookGenres bookGenre) throws ClassNotFoundException, SQLException {
		save("update tbl_book_genres set genre_id = ? where bookId = ?", new Object[] {bookGenre.getGenre_id(), bookGenre.getBookId()});
	}
	
	public void deleteBookGenre(BookGenres bookGenre) throws ClassNotFoundException, SQLException {
		save("delete from tbl_book_genres where genre_id = ?", new Object[] {bookGenre.getGenre_id()});
	}
	
	public List<BookGenres> extractData(ResultSet rs) throws SQLException {
		List<BookGenres> list = new ArrayList<>();
		while(rs.next()) {
			BookGenres bookGenre = new BookGenres();
			bookGenre.setGenre_id(rs.getInt("genre_id"));
			bookGenre.setBookId(rs.getInt("bookId"));
			list.add(bookGenre);
		}
		return list;
	}

	
	public BookGenres extractSingleData(ResultSet rs) throws SQLException, ClassNotFoundException {
		if (rs.next()) {
			BookGenres bookGenre = new BookGenres();
			bookGenre.setGenre_id(rs.getInt("genre_id"));
			bookGenre.setBookId(rs.getInt("bookId"));
			return bookGenre;
		}
		return null;
	}
}