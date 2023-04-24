package com.san.meetup.user.response;

import java.util.ArrayList;
import java.util.List;

import com.san.meetup.user.bo.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class GetUsersResponse {
	private List<User> users = new ArrayList<>();
}
