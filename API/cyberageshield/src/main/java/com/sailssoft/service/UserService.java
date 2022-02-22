package com.sailssoft.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sailssoft.model.User;



public interface UserService {

	public boolean isValidUser(String username, String password);

	public User findByEmail(String email);

	public ResponseEntity<User> saveUser(User user);

	public ResponseEntity<User> updateUser(Long userId, User user);

	public ResponseEntity<HttpStatus> deleteByUserId(Long userId);

	public ResponseEntity<User> getUserById(Long userId);

	public List<User> getAllUsers();

	
	
	
}