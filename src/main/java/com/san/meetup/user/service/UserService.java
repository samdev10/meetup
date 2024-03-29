package com.san.meetup.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.san.meetup.user.bo.User;
import com.san.meetup.user.exception.UserNotFoundExpection;
import com.san.meetup.user.repo.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;

	public List<User> getAllUsers() {
		List<User> users = userRepo.findAll();
		return users;
	}

	public User findUser(final String email) {
		return userRepo.findUserByEmail(email)
				.orElseThrow(() -> new UserNotFoundExpection("user not found with email: " + email));
	}
}
