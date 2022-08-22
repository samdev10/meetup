package com.san.meetup.response;

import com.san.meetup.bo.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class GetUserResponse {
	private User user;
}
