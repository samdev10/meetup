package com.san.meetup.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.san.meetup.user.bo.User;
import com.san.meetup.user.request.AuthenticateUserRequest;
import com.san.meetup.user.response.GetUserResponse;
import com.san.meetup.user.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping(value = "/api/auth/user", produces = "application/json")
	ResponseEntity<GetUserResponse> getUsers(@RequestBody AuthenticateUserRequest request) {
		User user = userService.findUser(request.getEmail());
		GetUserResponse getUserResponse = GetUserResponse.builder().user(user)
				.build();
		return new ResponseEntity<GetUserResponse>(getUserResponse, HttpStatus.OK);
	}
}
