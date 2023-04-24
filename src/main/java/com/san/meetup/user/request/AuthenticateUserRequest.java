package com.san.meetup.user.request;

import com.san.meetup.user.bo.User;
import com.san.meetup.user.response.GetUserResponse;

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
