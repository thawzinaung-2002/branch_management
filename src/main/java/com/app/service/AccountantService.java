package com.app.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.dto.AccountantRequestDTO;
import com.app.dto.AccountantResponseDTO;

public class AccountantService {

	public List<AccountantResponseDTO> getAll() {
		List<AccountantResponseDTO> ls = new ArrayList<>();
		Connection con = ConnectionClass.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select username,password,dob,join_date,salary,b.name branch from accountant a left join branch b on a.branch_id=b.id");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				AccountantResponseDTO acc = new AccountantResponseDTO();
				acc.setUsername(rs.getString("username"));
				acc.setPassword(rs.getString("password"));
				acc.setDob(rs.getString("dob"));
				acc.setJoin_date(rs.getString("join_date"));
				acc.setSalary(rs.getDouble("salary"));
				acc.setBranch(rs.getString("branch"));
				ls.add(acc);
			}
		} catch (SQLException e) {
			System.out.println("All select : "+ e.getMessage());
		}
		return ls;
	}

	public int addOne(AccountantRequestDTO req) {
		
		int result = 0;
		Connection con = ConnectionClass.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO accountant (username,password,dob,join_date,salary,branch_id) VALUES (?,?,?,?,?,(select id from branch where name=?))");
			ps.setString(1, req.getUsername());
			ps.setString(2, req.getPassword());
			ps.setString(3, req.getDob());
			ps.setString(4, req.getJoin_date());
			ps.setDouble(5, req.getSalary());
			ps.setString(6, req.getBranch());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Inserting accountant : " + e.getMessage());
		}
		
		return result;
	}
	
	

}
