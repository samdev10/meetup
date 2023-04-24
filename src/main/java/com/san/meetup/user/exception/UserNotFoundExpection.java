package com.san.meetup.user.exception;

public class UserNotFoundExpection extends RuntimeException {
	
	public UserNotFoundExpection(String errorMessage) {
		super(errorMessage);
	}
}
