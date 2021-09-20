package com.ss.lma.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.lma.domain.LibraryBranch;

public class LibraryBranchDAO extends BaseDAO<LibraryBranch> {

	public LibraryBranchDAO(Connection conn) {
		super(conn);
	}

	public Integer addLibraryBranch(LibraryBranch branch) throws ClassNotFoundException, SQLException {
		return saveReturnPK("insert into tbl_library_branch (branchId, branchName, branchAddress) values (?, ?, ?)", new Object[] {branch.getBranchId(), branch.getBranchName(), branch.getBranchAddress()});
	}
	
	public List<LibraryBranch> readAllLibraryBranches() throws ClassNotFoundException, SQLException {
		return read("select * from tbl_library_branch", null);
	}
	
	public void updateLibraryBranch(LibraryBranch branch) throws ClassNotFoundException, SQLException {
		save("update tbl_library_branch set branchName = ?, branchAddress = ? where branchId = ?", new Object[] {branch.getBranchName(), branch.getBranchAddress(), branch.getBranchId()});
	}
	
	public void deleteLibraryBranch(LibraryBranch branch) throws ClassNotFoundException, SQLException {
		save("delete from tbl_library_branch where branchId = ?", new Object[] {branch.getBranchId()});
	}
	
    public LibraryBranch readBranchFromId(Integer id) throws SQLException, ClassNotFoundException {
        return readSingle("SELECT * FROM tbl_library_branch WHERE branchId = ?", new Object[] { id });
    }
	
	public List<LibraryBranch> extractData(ResultSet rs) throws SQLException {
		List<LibraryBranch> list = new ArrayList<>();
		while(rs.next()) {
			LibraryBranch branch = new LibraryBranch();
			branch.setBranchId(rs.getInt("branchId"));
			branch.setBranchName(rs.getString("branchName"));
			branch.setBranchAddress(rs.getString("branchAddress"));
			list.add(branch);
		}
		return list;
	}
	
    public LibraryBranch extractSingleData(ResultSet rs) throws SQLException, ClassNotFoundException {
        if (rs.next()) {
            LibraryBranch branch = new LibraryBranch();
            branch.setBranchId(rs.getInt("branchId"));
            branch.setBranchName(rs.getString("branchName"));
            branch.setBranchAddress(rs.getString("branchAddress"));
            return branch;
        }
        return null;
    }
}