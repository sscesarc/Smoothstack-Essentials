package com.ss.lma.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ss.lma.dao.LibraryBranchDAO;
import com.ss.lma.domain.LibraryBranch;

public class LibraryBranchAdminService {

	ConnectionUtil connUtil = new ConnectionUtil();
	
	public void addBranch() throws SQLException {
		Connection conn = null;
		LibraryBranch branch = new LibraryBranch();
		
		try {
			conn = connUtil.getConnection();
			LibraryBranchDAO lbdao = new LibraryBranchDAO(conn);
			
			System.out.print("Enter Name (or 'quit' to cancel): ");
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String name = in.readLine();
			if ("quit".equals(name)) {
				return;
			}
			branch.setBranchName(name);
			
			System.out.print("Enter Address (or 'quit' to cancel): ");
			String address = in.readLine();
			if ("quit".equals(address)) {
				return;
			}
			branch.setBranchAddress(address);
			
			lbdao.addLibraryBranch(branch);
			conn.commit();
			System.out.println("Branch has been added.");
		} catch (Exception e) {
			conn.rollback();
			System.out.println("Failed to add Branch");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public void updateBranch() throws SQLException {
		Connection conn = null;
		LibraryBranch branch = new LibraryBranch();
		
		try {
			conn = connUtil.getConnection();
			LibraryBranchDAO lbdao = new LibraryBranchDAO(conn);
			
			System.out.println("Pick the branch you want to update: ");
			List<LibraryBranch> branches = lbdao.readAllLibraryBranches();

			int count = 1;

			for (LibraryBranch lb : branches) {
				System.out.println(count + ") " + lb.getBranchName() + ", " + lb.getBranchAddress());
				count++;
			}
			System.out.println(count + ") Cancel");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int choice = Integer.parseInt(in.readLine());
			if (choice == count) {
				return;
			}
			branch.setBranchId(branches.get(choice - 1).getBranchId());
			
			System.out.print("Enter Name (or 'quit' to cancel): ");
			String name = in.readLine();
			if ("quit".equals(name)) {
				return;
			}
			branch.setBranchName(name);
			
			System.out.print("Enter Address (or 'quit' to cancel): ");
			String address = in.readLine();
			if ("quit".equals(address)) {
				return;
			}
			branch.setBranchAddress(address);
			
			lbdao.updateLibraryBranch(branch);
			conn.commit();
			System.out.println("Branch has been updated.");
		} catch (Exception e) {
			conn.rollback();
			System.out.println("Failed to update Branch");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public void deleteBranch() throws SQLException {
		Connection conn = null;
		LibraryBranch branch = new LibraryBranch();
		
		try {
			conn = connUtil.getConnection();
			LibraryBranchDAO lbdao = new LibraryBranchDAO(conn);
			
			System.out.println("Pick the branch you want to delete: ");
			List<LibraryBranch> branches = lbdao.readAllLibraryBranches();

			int count = 1;
			for (LibraryBranch lb : branches) {
				System.out.println(count + ") " + lb.getBranchName() + ", " + lb.getBranchAddress());
				count++;
			}
			System.out.println(count + ") Cancel");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int choice = Integer.parseInt(in.readLine());
			if (choice == count) {
				return;
			}
			branch.setBranchId(branches.get(choice - 1).getBranchId());
			
			lbdao.deleteLibraryBranch(branch);
			conn.commit();
			System.out.println("Branch has been deleted.");
		} catch (Exception e) {
			conn.rollback();
			System.out.println("Failed to delete Branch");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public void readAllBranches() throws SQLException {
		Connection conn = null;
		
		try {
			conn = connUtil.getConnection();
			LibraryBranchDAO lbdao = new LibraryBranchDAO(conn);
			
			System.out.println("List of branches: ");
			List<LibraryBranch> branches = lbdao.readAllLibraryBranches();

			int count = 1;
			for (LibraryBranch lb : branches) {
				System.out.println(count + ") " + lb.getBranchName() + ", " + lb.getBranchAddress());
				count++;
			}

			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			System.out.println("Failed to read branches");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
}
