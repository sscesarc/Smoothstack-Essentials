package com.ss.lma.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class LibraryBranch implements Serializable {
	
	private static final long serialVersionUID = 3649602099351579648L;
	private int branchId;
	private String branchName;
	private String branchAddress;
	private List<BookLoans> loans;
	private List<BookCopies> copies;
	
	public LibraryBranch(int branchId, String branchName, String branchAddress, List<BookLoans> loans,
			List<BookCopies> copies) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
		this.branchAddress = branchAddress;
		this.loans = loans;
		this.copies = copies;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	public List<BookLoans> getLoans() {
		return loans;
	}

	public void setLoans(List<BookLoans> loans) {
		this.loans = loans;
	}

	public List<BookCopies> getCopies() {
		return copies;
	}

	public void setCopies(List<BookCopies> copies) {
		this.copies = copies;
	}

	@Override
	public int hashCode() {
		return Objects.hash(branchAddress, branchId, branchName, copies, loans);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LibraryBranch other = (LibraryBranch) obj;
		return Objects.equals(branchAddress, other.branchAddress) && branchId == other.branchId
				&& Objects.equals(branchName, other.branchName) && Objects.equals(copies, other.copies)
				&& Objects.equals(loans, other.loans);
	}

	@Override
	public String toString() {
		return "LibraryBranch [branchId=" + branchId + ", branchName=" + branchName + ", branchAddress=" + branchAddress
				+ ", loans=" + loans + ", copies=" + copies + "]";
	}
	
}
