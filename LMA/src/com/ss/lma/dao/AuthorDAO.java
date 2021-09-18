package com.ss.lma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.lma.domain.Author;

public class AuthorDAO extends BaseDAO<Author> {

	public AuthorDAO(Connection conn) {
		super(conn);
	}

	public void addAuthor(Author author) throws ClassNotFoundException, SQLException {
		save("insert into tbl_author (authorName) values (?)", new Object[] {author.getAuthorId(), author.getAuthorName()});
	}
	
	public List<Author> readAllAuthors() throws ClassNotFoundException, SQLException {
		List<Author> authors = new ArrayList<>();
		
		PreparedStatement pstmt = conn.prepareStatement("select * from author");
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			System.out.println("Author ID: " + rs.getInt("authorId"));
			System.out.println("Author Name: " + rs.getString("authorName"));
			System.out.println();
		}
		
		return authors;
	}
	
	public void updateAuthor(Author author) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = conn.prepareStatement("update tbl_author set authorName where authorId = ?");
		pstmt.setInt(1, author.getAuthorId());
		pstmt.setString(2, author.getAuthorName());
		pstmt.executeUpdate();
	}
	
	public void deleteAuthor(Author author) throws ClassNotFoundException, SQLException {
		
	}
	
	public List<Author> extractData(ResultSet rs) {
		return null;
		
	}
}
