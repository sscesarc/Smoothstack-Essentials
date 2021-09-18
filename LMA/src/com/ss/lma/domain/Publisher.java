package com.ss.lma.domain;

import java.io.Serializable;
import java.util.Objects;

public class Publisher implements Serializable {

	private static final long serialVersionUID = -3295937168871753799L;
	private int publisherId;
	private String publisherName;
	private String publisherAddress;
	private Book book;
	
	public Publisher(int publisherId, String publisherName, String publisherAddress, Book book) {
		super();
		this.publisherId = publisherId;
		this.publisherName = publisherName;
		this.publisherAddress = publisherAddress;
		this.book = book;
	}

	public int getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getPublisherAddress() {
		return publisherAddress;
	}

	public void setPublisherAddress(String publisherAddress) {
		this.publisherAddress = publisherAddress;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public int hashCode() {
		return Objects.hash(book, publisherAddress, publisherId, publisherName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publisher other = (Publisher) obj;
		return Objects.equals(book, other.book) && Objects.equals(publisherAddress, other.publisherAddress)
				&& publisherId == other.publisherId && Objects.equals(publisherName, other.publisherName);
	}

	@Override
	public String toString() {
		return "Publisher [publisherId=" + publisherId + ", publisherName=" + publisherName + ", publisherAddress="
				+ publisherAddress + ", book=" + book + "]";
	}
	
}
