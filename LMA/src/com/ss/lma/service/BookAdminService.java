package com.ss.lma.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ss.lma.dao.AuthorDAO;
import com.ss.lma.dao.BookDAO;
import com.ss.lma.dao.PublisherDAO;
import com.ss.lma.domain.Author;
import com.ss.lma.domain.Book;
import com.ss.lma.domain.Publisher;

public class BookAdminService {

	ConnectionUtil connUtil = new ConnectionUtil();

	public void addBook() throws SQLException {
		Connection conn = null;

		Book book = new Book();

		try {
			conn = connUtil.getConnection();
			BookDAO bdao = new BookDAO(conn);
			AuthorDAO adao = new AuthorDAO(conn);
			PublisherDAO pdao = new PublisherDAO(conn);

			System.out.print("Enter title (or 'quit' to cancel): ");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String title = in.readLine();
			
			if ("quit".equals(title)) {
				return;
			}
			book.setTitle(title);
			
			System.out.print("Enter author's name (or 'quit to cancel): ");
			String authorName = in.readLine();
			
			if ("quit".equals(authorName)) {
				return;
			}
			
			book.setAuthId(adao.readAuthorsByName(authorName).getAuthorId());
			
			System.out.print("Enter publisher's name (or 'quit to cancel): ");
			String publisherName = in.readLine();
			
			if ("quit".equals(publisherName)) {
				return;
			}
			
			book.setPubId(pdao.readPublishersByName(publisherName).getPublisherId());
				
			bdao.addBook(book);

			conn.commit();

			System.out.println("Book added: " + title);
		} catch (Exception e) {
			conn.rollback();
			System.out.println("Failed to add Book");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void updateBook() throws SQLException {
		Connection conn = null;

		Book book = new Book();

		try {
			conn = connUtil.getConnection();
			BookDAO bdao = new BookDAO(conn);
			AuthorDAO adao = new AuthorDAO(conn);
			PublisherDAO pdao = new PublisherDAO(conn);

			System.out.println("Pick the book you want to update: ");

			List<Book> books = bdao.readAllBooks();

			int count = 1;

			for (Book b : books) {
				System.out.println(count + ") " + b.getTitle());
				count++;
			}

			System.out.println(count + ") Cancel");

			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int choice = Integer.parseInt(in.readLine());

			if (choice == count) {
				return;
			}
			
			book.setBookId(books.get(choice - 1).getBookId());

			System.out.print("Enter new title for Book (or 'quit' to cancel): ");
			String name = in.readLine();

			if ("quit".equals(name)) {
				return;
			}
			
			book.setTitle(name);
			
			System.out.println("List of Authors: ");
			List<Author> authors = adao.readAllAuthors();
			count = 1;
			for (Author a : authors) {
				System.out.println(count + ") " + a.getAuthorName());
				count++;
			}
			System.out.println(count + ") Cancel");
			
			if (choice == count) {
				return;
			}
			
			book.setAuthId(authors.get(choice - 1).getAuthorId());
			
			System.out.println("List of Genres: ");
			List<Publisher> publishers = pdao.readAllPublishers();
			count = 1;
			for (Publisher p : publishers) {
				System.out.println(count + ") " + p.getPublisherName());
				count++;
			}
			System.out.println(count + ") Cancel");
			
			if (choice == count) {
				return;
			}
			book.setPubId(publishers.get(choice - 1).getPublisherId());

			
			bdao.updateBook(book);
			
			conn.commit();
			
			System.out.println("Book has been updated.");
		} catch (Exception e) {
			conn.rollback();
			System.out.println("Failed to update.");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void deleteBook() throws SQLException {
		Connection conn = null;

		Book book = new Book();

		try {
			conn = connUtil.getConnection();
			BookDAO bdao = new BookDAO(conn);

			System.out.println("Select Book you want to delete: ");
			List<Book> books = bdao.readAllBooks();
			int count = 1;
			for (Book b : books) {
				System.out.println(count + ") " + b.getTitle());
				count++;
			}

			System.out.println(count + ") Cancel");

			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int choice = Integer.parseInt(in.readLine());

			if (choice == count) {
				return;
			}

			book.setBookId(books.get(choice - 1).getBookId());
			bdao.deleteBook(book);

			conn.commit();
			System.out.println("Book deleted.");
		} catch (Exception e) {
			conn.rollback();
			System.out.println("Failed to delete Book");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public void readAllBooks() throws SQLException {
		Connection conn = null;

		try {
			conn = connUtil.getConnection();
			BookDAO bdao = new BookDAO(conn);
			System.out.println("List of Books: ");
			List<Book> books = bdao.readAllBooks();
			int count = 1;
			for (Book b : books) {
				System.out.println(count + ") " + b.getTitle());
				count++;
			}
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			System.out.println("Failed to display books");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
}
