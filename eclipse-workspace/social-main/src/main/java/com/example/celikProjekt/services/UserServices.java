package com.example.celikProjekt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.celikProjekt.entities.User;
import com.example.celikProjekt.repos.UserRepository;

@Service
public class UserServices {

	UserRepository userRepository;

	public UserServices(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User saveOneUser(User newUser) {
		return userRepository.save(null);
	}

	public User getOneUser(Long userId) {
		return userRepository.findById(userId).orElse(null);
	}

	public User updateOneUser(Long userId, User newUser) {
		  Optional<User> user = userRepository.findById(userId);
	        if (user.isPresent()) {
	            User foundUser = user.get();
	            foundUser.setUserName(newUser.getUserName());
	            foundUser.setPassword(newUser.getPassword());
	            userRepository.save(foundUser);
	            return foundUser;
	        } else {
	        	return null;
	        }
		
	}

	public void deleteByID(Long userId) {
		userRepository.deleteById(userId);
		
	}
}
