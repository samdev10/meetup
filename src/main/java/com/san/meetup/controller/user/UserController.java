package com.san.meetup.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.san.meetup.request.AuthenticateUserRequest;
import com.san.meetup.response.GetUserResponse;
import com.san.meetup.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping(value = "/api/auth/user", produces = "application/json")
	ResponseEntity<GetUserResponse> getUsers(@RequestBody AuthenticateUserRequest request) {
		GetUserResponse getUserResponse = GetUserResponse.builder().user(userService.findUser(request.getEmail()))
				.build();
		return new ResponseEntity<GetUserResponse>(getUserResponse, HttpStatus.OK);
	}
}
