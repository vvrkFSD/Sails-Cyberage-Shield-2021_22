package com.sailssoft.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sailssoft.dao.UserRepository;
import com.sailssoft.model.User;
import com.sailssoft.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public boolean isValidUser(String email, String password) {	
		User user = findByEmail(email);
		if(user == null){
			return false;	
		}
		String valid_password = user.getPassword();
		return (password.equals(valid_password));
	}
	
	
	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmailId(email);
	}

	
	@Override
	public ResponseEntity<User> saveUser(User user) {
		String pwd=user.getPassword();
		
		String epwd=passwordEncoder.encode(pwd);
		user.setPassword(epwd);
		try {
			User _user=userRepository
	.save(new User(null, user.getUsername(),user.getPassword(),user.getRole(),user.getEmailId(),user.getGender(),user.getDob(), null));
			return new ResponseEntity<>(_user,HttpStatus.CREATED);
		}
		catch(Exception e){
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<User> updateUser(Long userId,User user) {
		Optional<User> userData= userRepository.findById(userId);
	    if(userData.isPresent()) {
		    User _user=userData.get();
		    _user.setUsername(user.getUsername());
		    _user.setEmailId(user.getEmailId());
		    _user.setDob(user.getDob());
		    _user.setGender(user.getGender());
		    _user.setPassword(user.getPassword());	
		    return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
	    }
	    else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
	}

	@Override
	public ResponseEntity<HttpStatus> deleteByUserId(Long userId) {
		try {
	    	userRepository.deleteById(userId);
	    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    catch(Exception e) {
	    	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	@Override
	public ResponseEntity<User> getUserById(Long userId) {
		Optional<User> userData = userRepository.findById(userId);
		if(userData.isPresent()) {
			return new ResponseEntity<>(userData.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}




	
	
	
}
