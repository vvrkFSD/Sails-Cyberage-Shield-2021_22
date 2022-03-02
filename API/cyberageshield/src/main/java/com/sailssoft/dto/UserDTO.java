package com.sailssoft.dto;

import java.sql.Date;

import com.sailssoft.model.User;

import lombok.Data;

@Data
public class UserDTO {
	
	private Long userId;
	private String username;
    private String emailId;	
	private String gender;
	private Date dob;

	
	
}
