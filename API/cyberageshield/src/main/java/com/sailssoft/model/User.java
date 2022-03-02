package com.sailssoft.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@DynamicInsert
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long userId;
	
	private String username;
	
	
	private String password="Password@123";
	
	
	private String role;
	 @Column(name = "reset_password_token")
	 private String resetPasswordToken;
	
	@Column(name="email_id")
	private String emailId;
	
	private String gender;
	
	private Date dob;
	
	
	




	@OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private UserTransaction userTransaction;







	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}





	
	
	
	
	
}
