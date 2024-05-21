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
			PreparedStatement ps = con.prepareStatement("select a.id id,username,password,dob,join_date,salary,b.name branch from accountant a left join branch b on a.branch_id=b.id");
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
				acc.setId(rs.getInt("id"));
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

	public AccountantResponseDTO getOne(int id) {
		Connection con=ConnectionClass.getConnection();
		AccountantResponseDTO res = null;
		try {
			PreparedStatement ps = con.prepareStatement("select a.id,username,password,dob,join_date,salary,b.name branch from accountant a left join branch b on a.branch_id=b.id where a.id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				res = new AccountantResponseDTO();
				res.setId(rs.getInt("id"));
				res.setBranch(rs.getString("branch"));
				res.setDob(rs.getString("dob"));
				res.setJoin_date(rs.getString("join_date"));
				res.setPassword(rs.getString("password"));
				res.setSalary(rs.getDouble("salary"));
				res.setUsername(rs.getString("username"));
			}
		} catch (SQLException e) {
			System.out.println("get one : "+ e.getMessage());
		}
		return res;
	}

	public int addOne(AccountantRequestDTO req, int acc_id) {
		int result = 0;
		Connection con = ConnectionClass.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE accountant SET username=?,password=?,dob=?,join_date=?,salary=?,branch_id = (select id from branch WHERE name=?) where accountant.id=? ");
			ps.setString(1, req.getUsername());
			ps.setString(2, req.getPassword());
			ps.setString(3, req.getDob());
			ps.setString(4, req.getJoin_date());
			ps.setDouble(5, req.getSalary());
			ps.setString(6, req.getBranch());
			ps.setInt(7, acc_id);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Update : "+ e.getMessage());
		}
		
		return result;
		
	}

	public int deleteOne(int id) {
		
		Connection con = ConnectionClass.getConnection();
		int result = 0;
		try {
			PreparedStatement ps = con.prepareStatement("DELETE FROM accountant WHERE (id =?)");
			ps.setInt(1, id);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Delete : "+ e.getMessage());
		}
		
		return result;
	}

	public AccountantResponseDTO checkAccountant(AccountantRequestDTO req) {
		
		Connection con = ConnectionClass.getConnection();
		AccountantResponseDTO res = null;
		try {
			PreparedStatement ps = con.prepareStatement("select username, password, b.name branch from accountant a left join branch b on a.branch_id = b.id where username=? and password=? and b.name=?");
			ps.setString(1, req.getUsername());
			ps.setString(2, req.getPassword());
			ps.setString(3, req.getBranch());
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				res = new AccountantResponseDTO();
				res.setUsername(rs.getString("username"));
				res.setPassword(rs.getString("password"));
				res.setBranch(rs.getString("branch"));
			}
			
		} catch (SQLException e) {
			System.out.println("check : "+ e.getMessage());
		}
		return res;
		
	}
	
	

}
