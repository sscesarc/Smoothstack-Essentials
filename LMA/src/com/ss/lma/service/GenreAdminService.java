package com.ss.lma.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ss.lma.dao.GenreDAO;
import com.ss.lma.domain.Genre;

public class GenreAdminService {

	ConnectionUtil connUtil = new ConnectionUtil();
	
	public void addGenre() throws SQLException {
		Connection conn = null;
		Genre genre = new Genre();
		
		try {
			conn = connUtil.getConnection();
			GenreDAO gdao = new GenreDAO(conn);
			
			System.out.print("Enter Genre (or 'quit' to cancel): ");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String name = in.readLine();
			
			if ("quit".equals(name)) {
				return;
			}
			
			genre.setGenre_name(name);
			
			gdao.addGenre(genre);
			conn.commit();
			System.out.println("Genre has been added.");
		} catch (Exception e) {
			conn.rollback();
			System.out.println("Failed to add Genre");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public void updateGenre() throws SQLException {
		Connection conn = null;
		Genre genre = new Genre();
		
		try {
			conn = connUtil.getConnection();
			GenreDAO gdao = new GenreDAO(conn);
			
			System.out.println("Pick the genre you want to update: ");

			List<Genre> genres = gdao.readAllGenres();

			int count = 1;

			for (Genre g : genres) {
				System.out.println(count + ") " + g.getGenre_name());
				count++;
			}

			System.out.println(count + ") Cancel");

			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int choice = Integer.parseInt(in.readLine());

			if (choice == count) {
				return;
			}
			
			genre.setGenre_id(genres.get(choice - 1).getGenre_id());
			
			System.out.print("Enter new name for Genre (or 'quit' to cancel): ");
			String name = in.readLine();

			if ("quit".equals(name)) {
				return;
			}
			
			genre.setGenre_name(name);
			
			gdao.updateGenre(genre);
			conn.commit();
			System.out.println("Genre has been updated.");
		} catch (Exception e) {
			conn.rollback();
			System.out.println("Failed to update Genre");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public void deleteGenre() throws SQLException {
		Connection conn = null;
		Genre genre = new Genre();
		
		try {
			conn = connUtil.getConnection();
			GenreDAO gdao = new GenreDAO(conn);
			
			System.out.println("Select Genre you want to delete: ");
			List<Genre> genres = gdao.readAllGenres();
			int count = 1;
			for (Genre g : genres) {
				System.out.println(count + ") " + g.getGenre_name());
				count++;
			}

			System.out.println(count + ") Cancel");

			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int choice = Integer.parseInt(in.readLine());

			if (choice == count) {
				return;
			}

			genre.setGenre_id(genres.get(choice - 1).getGenre_id());
			gdao.deleteGenre(genre);
			conn.commit();
			System.out.println("Genre has been deleted.");
		} catch (Exception e) {
			conn.rollback();
			System.out.println("Failed to delete Genre");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public void readAllGenres() throws SQLException {
		Connection conn = null;
		
		try {
			conn = connUtil.getConnection();
			GenreDAO gdao = new GenreDAO(conn);
			
			System.out.println("List of Genres: ");
			List<Genre> genres = gdao.readAllGenres();
			int count = 1;
			for (Genre g : genres) {
				System.out.println(count + ") " + g.getGenre_name());
				count++;
			}
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			System.out.println("Failed to read Genres");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
}
