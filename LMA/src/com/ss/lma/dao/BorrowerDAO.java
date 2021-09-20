package com.ss.lma.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.lma.domain.Borrower;

public class BorrowerDAO extends BaseDAO<Borrower> {

	public BorrowerDAO(Connection conn) {
		super(conn);
	}

	public Integer addBorrower(Borrower borrower) throws ClassNotFoundException, SQLException {
		return saveReturnPK("insert into tbl_book_loans (cardNo, name, address, phone) values (?, ?, ?, ?)", new Object[] {borrower.getCardNo(), borrower.getName(), borrower.getAddress(), borrower.getPhone()});
	}
	
	public List<Borrower> readAllBorrowers() throws ClassNotFoundException, SQLException {
		return read("select * from tbl_borrower", null);
	}
	
	public void updateBorrower(Borrower borrower) throws ClassNotFoundException, SQLException {
		save("update tbl_borrower set name = ?, address = ?, phone = ? where cardNo = ?", new Object[] {borrower.getName(), borrower.getAddress(), borrower.getPhone()});
	}
	
	public void deleteBorrower(Borrower borrower) throws ClassNotFoundException, SQLException {
		save("delete from tbl_borrower where cardNo = ?", new Object[] {borrower.getCardNo()});
	}
	
	public List<Borrower> extractData(ResultSet rs) throws SQLException {
		List<Borrower> list = new ArrayList<>();
		while(rs.next()) {
			Borrower borrower = new Borrower();
			borrower.setCardNo(rs.getInt("cardNo"));
			borrower.setName(rs.getString("name"));
			borrower.setAddress(rs.getString("address"));
			borrower.setPhone(rs.getString("phone"));
			list.add(borrower);
		}
		return list;
	}

	
	public Borrower extractSingleData(ResultSet rs) throws SQLException, ClassNotFoundException {
		if (rs.next()) {
			Borrower borrower = new Borrower();
			borrower.setCardNo(rs.getInt("cardNo"));
			borrower.setName(rs.getString("name"));
			borrower.setAddress(rs.getString("address"));
			borrower.setPhone(rs.getString("phone"));
			return borrower;
		}
		return null;
	}
}