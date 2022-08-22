package com.san.meetup.exception;

public class UserNotFoundExpection extends RuntimeException {
	
	public UserNotFoundExpection(String errorMessage) {
		super(errorMessage);
	}
}
