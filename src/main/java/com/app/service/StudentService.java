package com.app.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.dto.StudentRequestDTO;
import com.app.dto.StudentResponseDTO;

public class StudentService {

	public List<StudentResponseDTO> getAll(String branch) {
		
		Connection con = ConnectionClass.getConnection();
		List<StudentResponseDTO> ls = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from student where branch_id = (select id from branch where name=?)");
			ps.setString(1, branch);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				StudentResponseDTO res = new StudentResponseDTO();
				res.setId(rs.getInt("id"));
				res.setCourse(rs.getString("course"));
				res.setDob(rs.getString("dob"));
				res.setFather(rs.getString("father"));
				res.setMobile(rs.getString("mobile"));
				res.setMother(rs.getString("mother"));
				res.setName(rs.getString("name"));
				res.setQualification(rs.getString("qualification"));
				ls.add(res);
			}
		} catch (SQLException e) {
			System.out.println("get students : "+ e.getMessage());
		}
		
		return ls;
	}

	public int addStudent(StudentRequestDTO req) {
		
		Connection con = ConnectionClass.getConnection();
		int result = 0;
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO student (name,course,mobile,father,mother,qualification,dob,branch_id) VALUES (?,?,?,?,?,?,?,(select id from branch where name=?))");
			ps.setString(1, req.getName());
			ps.setString(2, req.getCourse());
			ps.setString(3, req.getMobile());
			ps.setString(4, req.getFather());
			ps.setString(5, req.getMother());
			ps.setString(6, req.getQualification());
			ps.setString(7, req.getDob());
			ps.setString(8, req.getBranch());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("add student : "+ e.getMessage());
		}
		
		return result;
	}

	public StudentResponseDTO getOne(int id) {
		
		Connection con = ConnectionClass.getConnection();
		StudentResponseDTO res = null;
		try {
			PreparedStatement ps = con.prepareStatement("select s.id id,s.name,course,mobile,father,mother,qualification,dob,b.name branch from student s left join branch b on s.branch_id=b.id where s.id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				res = new StudentResponseDTO();
				res.setCourse(rs.getString("course"));
				res.setDob(rs.getString("dob"));
				res.setFather(rs.getString("father"));
				res.setId(rs.getInt("id"));
				res.setMobile(rs.getString("mobile"));
				res.setMother(rs.getString("mother"));
				res.setName(rs.getString("name"));
				res.setQualification(rs.getString("qualification"));
			}
		} catch (SQLException e) {
			System.out.println("get one student : "+ e.getMessage());
		}
		
		return res;
	}

	public int addStudent(StudentRequestDTO req, int id) {
		
		Connection con = ConnectionClass.getConnection();
		int result = 0;
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE student SET name=?,course=?,mobile=?,father=?,mother=?,qualification=?,dob=?,branch_id=(select id from branch where name=?) WHERE id =?");
			ps.setString(1, req.getName());
			ps.setString(2, req.getCourse());
			ps.setString(3, req.getMobile());
			ps.setString(4, req.getFather());
			ps.setString(5, req.getMother());
			ps.setString(6, req.getQualification());
			ps.setString(7, req.getDob());
			ps.setString(8, req.getBranch());
			ps.setInt(9, id);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Update student : "+ e.getMessage());
		}
		
		return result;
	}

	public int deleteOne(int id) {
		
		Connection con=ConnectionClass.getConnection();
		int result = 0;
		try {
			PreparedStatement ps = con.prepareStatement("delete from student where id=?");
			ps.setInt(1, id);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("delete student : "+ e.getMessage());
		}
		
		return result;
	}

	public List<StudentResponseDTO> getAll() {
		Connection con = ConnectionClass.getConnection();
		List<StudentResponseDTO> ls = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement("select s.id,course,dob,father,mother,mobile,s.name name,qualification,b.name branch from student s left join branch b on s.branch_id=b.id");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				StudentResponseDTO res = new StudentResponseDTO();
				res.setId(rs.getInt("id"));
				res.setCourse(rs.getString("course"));
				res.setDob(rs.getString("dob"));
				res.setFather(rs.getString("father"));
				res.setMobile(rs.getString("mobile"));
				res.setMother(rs.getString("mother"));
				res.setName(rs.getString("name"));
				res.setQualification(rs.getString("qualification"));
				res.setBranch(rs.getString("branch"));
				ls.add(res);
			}
		} catch (SQLException e) {
			System.out.println("get students : "+ e.getMessage());
		}
		
		return ls;
	}

}
