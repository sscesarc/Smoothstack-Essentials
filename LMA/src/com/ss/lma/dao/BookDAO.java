package com.ss.lma.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.lma.domain.Author;
import com.ss.lma.domain.Book;
import com.ss.lma.domain.Genre;

public class BookDAO extends BaseDAO<Book> {

	public BookDAO(Connection conn) {
		super(conn);
	}

	public Integer addBook(Book book) throws ClassNotFoundException, SQLException {
		return saveReturnPK("insert into tbl_book (bookId, title, authId, pubId) values (?, ?, ?, ?)", new Object[] {book.getBookId(), book.getTitle(), book.getAuthId(), book.getPubId()});
	}
	
	public List<Book> readAllBooks() throws ClassNotFoundException, SQLException {
		return read("select * from tbl_book", null);
	}
	
    public List<Book> readBooksByTitle(String title) throws SQLException, ClassNotFoundException {
        return read("select * from tbl_book where title = ?", new Object[] { title });
    }
    
    public Book readBookById(Integer id) throws SQLException, ClassNotFoundException {
        return readSingle("select * from tbl_book where bookId = ?", new Object[] { id });
    }
	
    public List<Book> readBooksWithCopy(Integer branchId) throws SQLException, ClassNotFoundException {
    	return read("select * tbl_book from ((tbl_book inner join tbl_author on authorId = authId) inner join tbl_book_copies on tbl_book.bookId = tbl_book_copies.bookId) where branchId = ? and noOfCopies > 0", new Object[] { branchId });
    	//return read("select tbl_book.* from ((tbl_book inner join tbl_author on authorId = authId) inner join tbl_book_copies on tbl_book.bookId = tbl_book_copies.bookId) where branchId = ? and noOfCopies > 0", new Object[] { branchId });
    }
    
	public void updateBook(Book book) throws ClassNotFoundException, SQLException {
		save("update tbl_book set title = ?, authId = ?, pubId = ? where bookId = ?", new Object[] {book.getTitle(), book.getAuthId(), book.getPubId(), book.getBookId()});
	}
	
	public void deleteBook(Book book) throws ClassNotFoundException, SQLException {
		save("delete from tbl_book where bookId = ?", new Object[] {book.getBookId()});
	}
	
    public void insertBookAuthor(Book book, Author author) throws SQLException, ClassNotFoundException {
        save("insert into tbl_book_authors (bookId, authorId) values(?, ?)", new Object[] { book.getBookId(), author.getAuthorId() });
    }
    
    public void insertBookGenre(Genre genre, Book book) throws SQLException, ClassNotFoundException {
        save("insert into tbl_book_genres (genreId, bookId) values(?, ?)", new Object[] { genre.getGenre_id(), book.getBookId() });
    }
	
	public List<Book> extractData(ResultSet rs) throws SQLException {
		List<Book> list = new ArrayList<>();
		while(rs.next()) {
			Book book = new Book();
			book.setBookId(rs.getInt("bookId"));
			book.setTitle(rs.getString("title"));
			book.setAuthId(rs.getInt("authId"));
			book.setPubId(rs.getInt("pubId"));
			list.add(book);
		}
		return list;
	}

	public Book extractSingleData(ResultSet rs) throws SQLException, ClassNotFoundException {
		if (rs.next()) {
			Book book = new Book();
			book.setBookId(rs.getInt("bookId"));
			book.setTitle(rs.getString("title"));
			book.setAuthId(rs.getInt("authId"));
			book.setPubId(rs.getInt("pubId"));
			return book;
		}
		return null;
	}
}