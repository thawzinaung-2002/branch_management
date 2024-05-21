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

	public List<StudentResponseDTO> getAll() {
		
		Connection con = ConnectionClass.getConnection();
		List<StudentResponseDTO> ls = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from student");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				StudentResponseDTO res = new StudentResponseDTO();
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

}
