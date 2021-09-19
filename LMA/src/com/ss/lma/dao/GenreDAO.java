package com.ss.lma.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.lma.domain.Genre;

public class GenreDAO extends BaseDAO<Genre> {

	public GenreDAO(Connection conn) {
		super(conn);
	}

	public Integer addGenre(Genre genre) throws ClassNotFoundException, SQLException {
		return saveReturnPK("insert into tbl_genre (genre_id, genre_name) values (?, ?)", new Object[] {genre.getGenre_id(), genre.getGenre_name()});
	}
	
	public List<Genre> readAllGenres() throws ClassNotFoundException, SQLException {
		return read("select * from tbl_genre", null);
	}
	
	public void updateGenre(Genre genre) throws ClassNotFoundException, SQLException {
		save("update tbl_genre set genre_name = ? where genre_id = ?", new Object[] {genre.getGenre_name(), genre.getGenre_id()});
	}
	
	public void deleteGenre(Genre genre) throws ClassNotFoundException, SQLException {
		save("delete from tbl_genre where genre_id = ?", new Object[] {genre.getGenre_id()});
	}
	
	public List<Genre> extractData(ResultSet rs) throws SQLException {
		List<Genre> list = new ArrayList<>();
		while(rs.next()) {
			Genre genre = new Genre();
			genre.setGenre_id(rs.getInt("genre_id"));
			genre.setGenre_name(rs.getString("genre_name"));
			list.add(genre);
		}
		return list;
	}
}