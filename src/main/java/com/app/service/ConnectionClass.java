package com.app.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
	
	public static Connection getConnection()
	{
		Connection con = null;
		try {
			Class.forName("com.jdbc.mysql.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payment_billing", "root", "admin");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver loading: "+ e.getMessage());
		} catch (SQLException e) {
			System.out.println("Connecting : "+ e.getMessage());
		}
		
		return con;
	}
	
}
