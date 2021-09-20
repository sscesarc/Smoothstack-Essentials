package com.ss.lma.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.lma.dao.AuthorDAO;
import com.ss.lma.dao.BookCopiesDAO;
import com.ss.lma.dao.BookDAO;
import com.ss.lma.dao.LibraryBranchDAO;
import com.ss.lma.domain.Author;
import com.ss.lma.domain.Book;
import com.ss.lma.domain.BookCopies;
import com.ss.lma.domain.LibraryBranch;

public class LibrarianService {
	
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public List<LibraryBranch> readAllBranches() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		List<LibraryBranch> branches = new ArrayList<>();
		
		try {
			conn = connUtil.getConnection();
			LibraryBranchDAO lbdao = new LibraryBranchDAO(conn);
			branches = lbdao.readAllLibraryBranches();
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return branches;
	}
	
	public void updateBranchName(Integer branchId, String name) throws SQLException {
		Connection conn = null;		
		try {
			conn = connUtil.getConnection();
			LibraryBranchDAO ldao = new LibraryBranchDAO(conn);
			LibraryBranch branch = ldao.readBranchFromId(branchId);
			branch.setBranchName(name);
			ldao.updateLibraryBranch(branch);
			conn.commit();
			System.out.println("Successfully updated name");
		} catch (Exception e) {
			conn.rollback();
			System.out.println("Failed to update name");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public void updateBranchAddress(Integer branchId, String address) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			LibraryBranchDAO ldao = new LibraryBranchDAO(conn);
			LibraryBranch branch = ldao.readBranchFromId(branchId);
			branch.setBranchAddress(address);
			ldao.updateLibraryBranch(branch);
			conn.commit();
			System.out.println("Successfully updated address");
		} catch (Exception e) {
			conn.rollback();
			System.out.println("Failed to update address");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public List<Book> readAllBooks() throws SQLException {
		Connection conn = null;
		List<Book> books = new ArrayList<>();
		try {
			conn = connUtil.getConnection();
			BookDAO bdao = new BookDAO(conn);
			books = bdao.readAllBooks();
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return books;
	}
	
	public Author readAuthorFromId(Integer authorId) throws SQLException {
		Connection conn = null;
		Author author = new Author();
		try {
			conn = connUtil.getConnection();
			AuthorDAO adao = new AuthorDAO(conn);
			author = adao.readAuthorById(authorId);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return author;
	}
	
	public BookCopies getBookCopy(Integer bookId, Integer branchId) throws SQLException {
		Connection conn = null;
		BookCopies copy = null;
		try {
			conn = connUtil.getConnection();
			BookCopiesDAO bcdao = new BookCopiesDAO(conn);
			copy = bcdao.readBookCopyById(bookId, branchId);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
        if (copy == null) {
            try {
                conn = connUtil.getConnection();
                BookCopiesDAO bcdao = new BookCopiesDAO(conn);
                copy = new BookCopies();
                copy.setBookId(bookId);
                copy.setBranchId(branchId);
                bcdao.addBookCopy(copy);
                System.out.println("Created data row");
            } catch (Exception e) {
                //System.out.println("Failed to create data");
                conn.rollback();
            } finally {
                if (conn != null) {
                    conn.close();
                }
            }
        }
        return copy;
	}
	
	public void updateCopies(BookCopies copy, Integer num) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookCopiesDAO bcdao = new BookCopiesDAO(conn);
			copy.setNoOfCopies(num);
			bcdao.updateBookCopy(copy);
			conn.commit();
			System.out.println("Update copies");
		} catch (Exception e) {
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
}