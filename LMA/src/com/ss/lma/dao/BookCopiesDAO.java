package com.ss.lma.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.lma.domain.BookCopies;

public class BookCopiesDAO extends BaseDAO<BookCopies> {

	public BookCopiesDAO(Connection conn) {
		super(conn);
	}

	public Integer addBookCopy(BookCopies bookCopies) throws ClassNotFoundException, SQLException {
		return saveReturnPK("insert into tbl_book_copies (bookId, branchId, noOfCopies) values (?, ?, ?)", new Object[] {bookCopies.getBookId(), bookCopies.getBranchId(), bookCopies.getNoOfCopies()});
	}
	
	public List<BookCopies> readAllBookCopies() throws ClassNotFoundException, SQLException {
		return read("select * from tbl_book_copies", null);
	}
	
	public void updateBookCopy(BookCopies bookCopies) throws ClassNotFoundException, SQLException {
		save("update tbl_book_copies set noOfCopies = ? where bookId = ? and brandId = ?", new Object[] {bookCopies.getNoOfCopies(), bookCopies.getBookId(), bookCopies.getBranchId()});
	}
	
	public void deleteBookCopy(BookCopies bookCopies) throws ClassNotFoundException, SQLException {
		save("delete from tbl_book_copies where bookId = ? and branchId = ?", new Object[] {bookCopies.getBookId(), bookCopies.getBranchId()});
	}
	
	public BookCopies readBookCopyById(Integer bookId, Integer branchId) throws ClassNotFoundException, SQLException {
		return readSingle("SELECT * FROM tbl_book_copies WHERE bookId = ? AND branchId = ?", new Object[] { bookId, branchId });
	}
	
	public List<BookCopies> extractData(ResultSet rs) throws SQLException {
		List<BookCopies> list = new ArrayList<>();
		while(rs.next()) {
			BookCopies bookCopy = new BookCopies();
			bookCopy.setBookId(rs.getInt("bookId"));
			bookCopy.setBranchId(rs.getInt("branchId"));
			bookCopy.setNoOfCopies(rs.getInt("noOfCopies"));
			list.add(bookCopy);
		}
		return list;
	}

	public BookCopies extractSingleData(ResultSet rs) throws SQLException, ClassNotFoundException {
		if (rs.next()) {
			BookCopies bookCopy = new BookCopies();
			bookCopy.setBookId(rs.getInt("bookId"));
			bookCopy.setBranchId(rs.getInt("branchId"));
			bookCopy.setNoOfCopies(rs.getInt("noOfCopies"));
			return bookCopy;
		}
		return null;
	}

}
