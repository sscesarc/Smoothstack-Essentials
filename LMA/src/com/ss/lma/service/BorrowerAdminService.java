package com.ss.lma.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ss.lma.dao.BorrowerDAO;
import com.ss.lma.domain.Borrower;

public class BorrowerAdminService {

	ConnectionUtil connUtil = new ConnectionUtil();
	
	public void addBorrower() throws SQLException {
		Connection conn = null;
		Borrower borrower = new Borrower();
		
		try {
			conn = connUtil.getConnection();
			BorrowerDAO bdao = new BorrowerDAO(conn);
			
			System.out.print("Enter Name (or 'quit' to cancel): ");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String name = in.readLine();
			
			if ("quit".equals(name)) {
				return;
			}
			
			borrower.setName(name);
			
			
			System.out.print("Enter Address (or 'quit' to cancel): ");
			
			String address = in.readLine();
			
			if ("quit".equals(address)) {
				return;
			}
			
			borrower.setAddress(address);
			
			System.out.print("Enter Phone xxx-xxx-xxxx (or 'quit' to cancel): ");
			
			String phone = in.readLine();
			
			if ("quit".equals(phone)) {
				return;
			}
			
			borrower.setPhone(phone);
			
			bdao.addBorrower(borrower);
			conn.commit();
			System.out.println("Borrower has been added.");
		} catch (Exception e) {
			conn.rollback();
			System.out.println("Failed to add Borrower");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public void updateBorrower() throws SQLException {
		Connection conn = null;
		Borrower borrower = new Borrower();
		
		try {
			conn = connUtil.getConnection();
			BorrowerDAO bdao = new BorrowerDAO(conn);
			
			System.out.println("Pick the Borrower you want to update: ");

			List<Borrower> Borrowers = bdao.readAllBorrowers();

			int count = 1;

			for (Borrower b : Borrowers) {
				System.out.println(count + ") " + b.getName() + ", " + b.getAddress());
				count++;
			}
			System.out.println(count + ") Cancel");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int choice = Integer.parseInt(in.readLine());
			if (choice == count) {
				return;
			}
			borrower.setCardNo(Borrowers.get(choice - 1).getCardNo());
			
			System.out.print("Enter Name or ('quit' to cancel): ");
			String name = in.readLine();
			if ("quit".equals(name)) {
				return;
			}
			borrower.setName(name);
			
			System.out.print("Enter Address or ('quit' to cancel): ");
			String address = in.readLine();
			if ("quit".equals(address)) {
				return;
			}
			borrower.setAddress(address);
			
			System.out.print("Enter Phone xxx-xxx-xxxx or ('quit' to cancel): ");
			String phone = in.readLine();
			if ("quit".equals(phone)) {
				return;
			}
			borrower.setPhone(phone);
			
			bdao.updateBorrower(borrower);
			conn.commit();
			System.out.println("Borrower has been updated.");
		} catch (Exception e) {
			conn.rollback();
			System.out.println("Failed to update Borrower");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public void deleteBorrower() throws SQLException {
		Connection conn = null;
		Borrower borrower = new Borrower();
		
		try {
			conn = connUtil.getConnection();
			BorrowerDAO bdao = new BorrowerDAO(conn);
			
			System.out.println("Pick the Borrower you want to delete: ");

			List<Borrower> borrowers = bdao.readAllBorrowers();

			int count = 1;

			for (Borrower b : borrowers) {
				System.out.println(count + ") " + b.getName() + ", " + b.getAddress());
				count++;
			}
			System.out.println(count + ") Cancel");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int choice = Integer.parseInt(in.readLine());
			if (choice == count) {
				return;
			}
			borrower.setCardNo(borrowers.get(choice - 1).getCardNo());
			
			bdao.deleteBorrower(borrower);
			conn.commit();
			System.out.println("Borrower has been deleted.");
		} catch (Exception e) {
			conn.rollback();
			System.out.println("Failed to delete Borrower");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public void readAllBorrowers() throws SQLException {
		Connection conn = null;
		
		try {
			conn = connUtil.getConnection();
			BorrowerDAO bdao = new BorrowerDAO(conn);
			
			System.out.println("List of Borrowers: ");

			List<Borrower> borrowers = bdao.readAllBorrowers();

			int count = 1;

			for (Borrower b : borrowers) {
				System.out.println(count + ") " + b.getName() + ", " + b.getAddress());
				count++;
			}
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			System.out.println("Failed to read Borrowers");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
}
