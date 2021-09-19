package com.ss.lma.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.lma.domain.Publisher;

public class PublisherDAO extends BaseDAO<Publisher> {

	public PublisherDAO(Connection conn) {
		super(conn);
	}

	public Integer addPublisher(Publisher publisher) throws ClassNotFoundException, SQLException {
		return saveReturnPK("insert into tbl_publisher (publisherId, publisherName, publisherAddress, publisherPhone) values (?, ?, ?, ?)", new Object[] {publisher.getPublisherId(), publisher.getPublisherName(), publisher.getPublisherAddress(), publisher.getPublisherPhone()});
	}
	
	public List<Publisher> readAllPublishers() throws ClassNotFoundException, SQLException {
		return read("select * from tbl_publisher", null);
	}
	
	public void updatePublisher(Publisher publisher) throws ClassNotFoundException, SQLException {
		save("update tbl_publisher set publisherName = ?, publisherAddress = ?, publisherPhone = ? where publisherId = ?", new Object[] {publisher.getPublisherName(), publisher.getPublisherAddress(), publisher.getPublisherPhone(), publisher.getPublisherId()});
	}
	
	public void deletePublisher(Publisher publisher) throws ClassNotFoundException, SQLException {
		save("delete from tbl_publisher where publisherId = ?", new Object[] {publisher.getPublisherId()});
	}
	
	public List<Publisher> extractData(ResultSet rs) throws SQLException {
		List<Publisher> list = new ArrayList<>();
		while(rs.next()) {
			Publisher publisher = new Publisher();
			publisher.setPublisherId(rs.getInt("publisherId"));
			publisher.setPublisherName(rs.getString("publisherName"));
			publisher.setPublisherAddress(rs.getString("publisherAddress"));
			publisher.setPublisherPhone(rs.getString("publisherPhone"));
			list.add(publisher);
		}
		return list;
	}
}