package com.ss.lma.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ss.lma.dao.AuthorDAO;
import com.ss.lma.domain.Author;

public class AdminService {

	ConnectionUtil connUtil = new ConnectionUtil();
	
	public void addAuthor(Author author) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AuthorDAO adao = new AuthorDAO(conn);
			//origin irata code, desti iatacode, city for btoh
			//airportdao.save(originalairpot)
			//airportdao.save(destinationairport)
			//Failed
			//routdao.save(route)
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
	}
	
	public List<Author> readAuthors(Author author) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AuthorDAO adao = new AuthorDAO(conn);
			List<Author> authors = adao.readAllAuthors();
			//populate the child elements here
			return authors;
		} catch (Exception e) {
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return null;
	}
}
