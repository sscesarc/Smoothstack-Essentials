package com.ss.lma.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ss.lma.dao.PublisherDAO;
import com.ss.lma.domain.Publisher;

public class PublisherAdminService {

	ConnectionUtil connUtil = new ConnectionUtil();
	
	public void addPublisher() throws SQLException {
		Connection conn = null;
		Publisher publisher = new Publisher();
		
		try {
			conn = connUtil.getConnection();
			PublisherDAO pdao = new PublisherDAO(conn);
			
			System.out.print("Enter Name (or 'quit' to cancel): ");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String name = in.readLine();
			
			if ("quit".equals(name)) {
				return;
			}
			
			publisher.setPublisherName(name);
			
			
			System.out.print("Enter Address (or 'quit' to cancel): ");
			
			String address = in.readLine();
			
			if ("quit".equals(address)) {
				return;
			}
			
			publisher.setPublisherAddress(address);
			
			System.out.print("Enter Phone xxx-xxx-xxxx (or 'quit' to cancel): ");
			
			String phone = in.readLine();
			
			if ("quit".equals(phone)) {
				return;
			}
			
			publisher.setPublisherPhone(phone);
			
			pdao.addPublisher(publisher);
			conn.commit();
			System.out.println("Publisher has been added.");
		} catch (Exception e) {
			conn.rollback();
			System.out.println("Failed to add Publisher");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public void updatePublisher() throws SQLException {
		Connection conn = null;
		Publisher publisher = new Publisher();
		
		try {
			conn = connUtil.getConnection();
			PublisherDAO pdao = new PublisherDAO(conn);
			
			System.out.println("Pick the publisher you want to update: ");

			List<Publisher> publishers = pdao.readAllPublishers();

			int count = 1;

			for (Publisher p : publishers) {
				System.out.println(count + ") " + p.getPublisherName() + ", " + p.getPublisherAddress());
				count++;
			}
			System.out.println(count + ") Cancel");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int choice = Integer.parseInt(in.readLine());
			if (choice == count) {
				return;
			}
			publisher.setPublisherId(publishers.get(choice - 1).getPublisherId());
			
			System.out.print("Enter Name or ('quit' to cancel): ");
			String name = in.readLine();
			if ("quit".equals(name)) {
				return;
			}
			publisher.setPublisherName(name);
			
			System.out.print("Enter Address or ('quit' to cancel): ");
			String address = in.readLine();
			if ("quit".equals(address)) {
				return;
			}
			publisher.setPublisherAddress(address);
			
			System.out.print("Enter Phone xxx-xxx-xxxx or ('quit' to cancel): ");
			String phone = in.readLine();
			if ("quit".equals(phone)) {
				return;
			}
			publisher.setPublisherPhone(phone);
			
			pdao.updatePublisher(publisher);
			conn.commit();
			System.out.println("Publisher has been updated.");
		} catch (Exception e) {
			conn.rollback();
			System.out.println("Failed to update Publisher");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public void deletePublisher() throws SQLException {
		Connection conn = null;
		Publisher publisher = new Publisher();
		
		try {
			conn = connUtil.getConnection();
			PublisherDAO pdao = new PublisherDAO(conn);
			
			System.out.println("Pick the publisher you want to delete: ");

			List<Publisher> publishers = pdao.readAllPublishers();

			int count = 1;

			for (Publisher p : publishers) {
				System.out.println(count + ") " + p.getPublisherName() + ", " + p.getPublisherAddress());
				count++;
			}
			System.out.println(count + ") Cancel");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			int choice = Integer.parseInt(in.readLine());
			if (choice == count) {
				return;
			}
			publisher.setPublisherId(publishers.get(choice - 1).getPublisherId());
			
			pdao.deletePublisher(publisher);
			conn.commit();
			System.out.println("Publisher has been deleted.");
		} catch (Exception e) {
			conn.rollback();
			System.out.println("Failed to delete Publisher");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	public void readAllPublishers() throws SQLException {
		Connection conn = null;
		
		try {
			conn = connUtil.getConnection();
			PublisherDAO pdao = new PublisherDAO(conn);
			
			System.out.println("List of publishers: ");

			List<Publisher> publishers = pdao.readAllPublishers();

			int count = 1;

			for (Publisher p : publishers) {
				System.out.println(count + ") " + p.getPublisherName() + ", " + p.getPublisherAddress());
				count++;
			}
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			System.out.println("Failed to read Publishers");
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}
}
