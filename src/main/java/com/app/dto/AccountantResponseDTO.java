package com.app.dto;

import lombok.Data;

@Data
public class AccountantResponseDTO {

	private int id;
	private String username;
	private String password;
	private String dob;
	private String join_date;
	private double salary;
	private String branch;
}
