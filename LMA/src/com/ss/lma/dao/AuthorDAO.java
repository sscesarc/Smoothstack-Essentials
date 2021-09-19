package com.ss.lma.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.lma.domain.Author;

public class AuthorDAO extends BaseDAO<Author> {

	public AuthorDAO(Connection conn) {
		super(conn);
	}

	public Integer addAuthor(Author author) throws ClassNotFoundException, SQLException {
		return saveReturnPK("insert into tbl_author (authorName) values (?)", new Object[] {author.getAuthorName()});
	}
	
	public List<Author> readAllAuthors() throws ClassNotFoundException, SQLException {
		return read("select * from tbl_author", null);
	}
	
	public void updateAuthor(Author author) throws ClassNotFoundException, SQLException {
		save("update tbl_author set authorName = ? where authorId = ?", new Object[] {author.getAuthorName(), author.getAuthorId()});
	}
	
	public void deleteAuthor(Author author) throws ClassNotFoundException, SQLException {
		save("delete from tbl_author where authorId = ?", new Object[] {author.getAuthorId()});
	}
	
	public List<Author> extractData(ResultSet rs) throws SQLException {
		List<Author> list = new ArrayList<>();
		while(rs.next()) {
			Author author = new Author();
			author.setAuthorId(rs.getInt("authorId"));
			author.setAuthorName(rs.getString("authorName"));
			list.add(author);
		}
		return list;
	}
}
