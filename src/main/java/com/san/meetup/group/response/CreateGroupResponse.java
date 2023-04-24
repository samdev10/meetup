package com.san.meetup.group.response;

import com.san.meetup.group.bo.Group;
import com.san.meetup.user.bo.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CreateGroupResponse {
	private Group group;
}
