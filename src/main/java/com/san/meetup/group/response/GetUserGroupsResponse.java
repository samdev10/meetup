package com.san.meetup.group.response;

import java.util.ArrayList;
import java.util.List;

import com.san.meetup.group.bo.Group;
import com.san.meetup.user.bo.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class GetUserGroupsResponse {
	private List<Group> groups = new ArrayList<>();
}
