package com.san.meetup.request;

import com.san.meetup.bo.User;
import com.san.meetup.response.GetUserResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthenticateUserRequest {
	private String email;
}
