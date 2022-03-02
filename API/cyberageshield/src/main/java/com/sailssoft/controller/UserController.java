package com.sailssoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sailssoft.dto.UserDTO;
import com.sailssoft.model.User;
import com.sailssoft.service.UserService;

@RestController
@RequestMapping("api/admin")

public class UserController {
	
	@Autowired
	private UserService userService; 
	
	
	@PostMapping("/users")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<UserDTO> saveUser(@Validated @RequestBody User user) {
		return userService.saveUser(user);	
	}
	
	
	@PutMapping("/users/{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<User> updateUser(@PathVariable("id") Long userId,@Validated @RequestBody User user) {
		return userService.updateUser(userId,user);	
	}
	
	
	@DeleteMapping("/users/{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<HttpStatus> deleteUserById(@PathVariable("id") Long userId) {
		return userService.deleteByUserId(userId);    
	}
	
	
	@GetMapping("/users/{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) {	
		return userService.getUserById(userId);
	}
	
	
	@GetMapping("/users")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public List<UserDTO> getAllUsers(){
		return userService.getAllUsers();
	}
	
	
	
	
}
