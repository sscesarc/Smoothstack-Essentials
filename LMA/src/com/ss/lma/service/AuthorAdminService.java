package com.ss.lma.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ss.lma.dao.AuthorDAO;
import com.ss.lma.domain.Author;

public class AuthorAdminService {

	ConnectionUtil connUtil = new ConnectionUtil();

	public void addAuthor() throws SQLException {
		Connection conn = null;

		Author author = new Author();

		try {
			conn = connUtil.getConnection();
			AuthorDAO adao = new AuthorDAO(conn);

			System.out.print("Enter name: ");

			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String name = in.readLine();

			author.setAuthorName(name);

			adao.addAuthor(author);

			conn.commit();

			System.out.println("Author added: " + name);
		} catch (Exception e) {
			conn.rollback();
			System.out.println("Failed to add author");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void updateAuthor() throws SQLException {
		Connection conn = null;

		Author author = new Author();

		try {
			conn = connUtil.getConnection();
			AuthorDAO adao = new AuthorDAO(conn);

			System.out.println("Pick the Author you want to update: ");

			List<Author> authors = adao.readAllAuthors();

			int count = 1;

			for (Author a : authors) {
				System.out.println(count + ") " + a.getAuthorName());
				count++;
			}

			System.out.println(count + ") Cancel");

			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int choice = Integer.parseInt(in.readLine());

			if (choice == count) {
				return;
			}

			System.out.print("Enter new name for Author (or 'quit' to cancel): ");
			String name = in.readLine();

			if ("quit".equals(name)) {
				return;
			}

			author.setAuthorId(authors.get(choice - 1).getAuthorId());
			author.setAuthorName(name);
			adao.updateAuthor(author);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			System.out.println("Failed to update.");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void deleteAuthor() throws SQLException {
		Connection conn = null;

		Author author = new Author();

		try {
			conn = connUtil.getConnection();
			AuthorDAO adao = new AuthorDAO(conn);

			System.out.println("Select Author you want to delete: ");
			List<Author> authors = adao.readAllAuthors();
			int count = 1;
			for (Author a : authors) {
				System.out.println(count + ") " + a.getAuthorName());
				count++;
			}

			System.out.println(count + ") Cancel");

			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int choice = Integer.parseInt(in.readLine());

			if (choice == count) {
				return;
			}

			author.setAuthorId(authors.get(choice - 1).getAuthorId());
			adao.deleteAuthor(author);

			conn.commit();
			System.out.println("Author deleted.");
		} catch (Exception e) {
			conn.rollback();
			System.out.println("Failed to delete Author");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void readAllAuthors() throws SQLException {
		Connection conn = null;

		try {
			conn = connUtil.getConnection();
			AuthorDAO adao = new AuthorDAO(conn);
			System.out.println("List of Authors: ");
			List<Author> authors = adao.readAllAuthors();
			int count = 1;
			for (Author a : authors) {
				System.out.println(count + ") " + a.getAuthorName());
				count++;
			}
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			System.out.println("Failed to display authors");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
}
