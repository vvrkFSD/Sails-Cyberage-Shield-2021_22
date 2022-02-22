package com.sailssoft.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sailssoft.dao.UserRepository;
import com.sailssoft.model.User;
import com.sailssoft.service.UserService;

@RestController
@RequestMapping("/all")
public class AllUserController {

	@Autowired
	private UserService userService; 
	
	@Autowired
	private UserRepository userRepository;
	
	
	@PostMapping("/users/login")
	public ResponseEntity<User> loginUser(@RequestBody User user,HttpSession session) {
		
		String email = user.getEmailId();
		String password = user.getPassword();
		boolean isValid = userService.isValidUser(email, password);
		if(isValid){
			session.setAttribute("email", email);
			return new ResponseEntity<>(userService.findByEmail(email),HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	
	@GetMapping("/users/logout")
	public ResponseEntity<User> logoutUser(HttpSession session) {
		session.removeAttribute("email");
		session.invalidate();
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
	
	
	
}
