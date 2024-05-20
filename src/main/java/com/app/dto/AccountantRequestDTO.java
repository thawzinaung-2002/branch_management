package com.app.dto;

import lombok.Data;

@Data
public class AccountantRequestDTO {
	private String username;
	private String password;
	private String dob;
	private String join_date;
	private double salary;
	private String branch;
}
