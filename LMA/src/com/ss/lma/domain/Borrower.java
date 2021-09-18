package com.ss.lma.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Borrower implements Serializable {

	private static final long serialVersionUID = -3306464576354454101L;
	private int cardNo;
	private String name;
	private String address;
	private String phone;
	private List<BookLoans> loans;
	
	public Borrower(int cardNo, String name, String address, String phone, List<BookLoans> loans) {
		super();
		this.cardNo = cardNo;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.loans = loans;
	}

	public int getCardNo() {
		return cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<BookLoans> getLoans() {
		return loans;
	}

	public void setLoans(List<BookLoans> loans) {
		this.loans = loans;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, cardNo, loans, name, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Borrower other = (Borrower) obj;
		return Objects.equals(address, other.address) && cardNo == other.cardNo && Objects.equals(loans, other.loans)
				&& Objects.equals(name, other.name) && Objects.equals(phone, other.phone);
	}

	@Override
	public String toString() {
		return "Borrower [cardNo=" + cardNo + ", name=" + name + ", address=" + address + ", phone=" + phone
				+ ", loans=" + loans + "]";
	}
	
}
