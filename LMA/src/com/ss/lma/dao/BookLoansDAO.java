package com.ss.lma.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.lma.domain.BookLoans;

public class BookLoansDAO extends BaseDAO<BookLoans> {

	public BookLoansDAO(Connection conn) {
		super(conn);
	}

	public Integer addBookLoan(BookLoans bookLoan) throws ClassNotFoundException, SQLException {
		return saveReturnPK("insert into tbl_book_loans (bookId, branchId, cardNo, dateOut, dueDate) values (?, ?, ?, ?, ?)", new Object[] {bookLoan.getBookId(), bookLoan.getBranchId(), bookLoan.getCardNo(), bookLoan.getDateOut(), bookLoan.getDueDate()});
	}
	
	public List<BookLoans> readAllBookLoans() throws ClassNotFoundException, SQLException {
		return read("select * from tbl_book_loans", null);
	}
	
	public void updateBookLoan(BookLoans bookLoan) throws ClassNotFoundException, SQLException {
		save("update tbl_book_loans set dateOut = ?, dueDate = ? where bookId = ? and branchId = ? and cardNo = ?", new Object[] {bookLoan.getDateOut(), bookLoan.getDueDate(), bookLoan.getBookId(), bookLoan.getBranchId(), bookLoan.getCardNo()});
	}
	
	public void deleteBookLoan(BookLoans bookLoan) throws ClassNotFoundException, SQLException {
		save("delete from tbl_book_loans where bookId = ? and branchId = ? and cardNo = ?", new Object[] {bookLoan.getBookId(), bookLoan.getBranchId(), bookLoan.getCardNo()});
	}
	
	public List<BookLoans> extractData(ResultSet rs) throws SQLException {
		List<BookLoans> list = new ArrayList<>();
		while(rs.next()) {
			BookLoans bookLoan = new BookLoans();
			bookLoan.setBookId(rs.getInt("bookId"));
			bookLoan.setBranchId(rs.getInt("branchId"));
			bookLoan.setCardNo(rs.getInt("cardNo"));
			bookLoan.setDateOut(rs.getTimestamp("dateOut"));
			bookLoan.setDueDate(rs.getTimestamp("dueDate"));
			list.add(bookLoan);
		}
		return list;
	}
}