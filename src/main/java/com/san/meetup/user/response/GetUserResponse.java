package com.san.meetup.user.response;

import com.san.meetup.user.bo.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class GetUserResponse {
	private User user;
}
