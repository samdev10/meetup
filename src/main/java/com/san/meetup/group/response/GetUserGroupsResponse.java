package com.san.meetup.group.response;

import java.util.ArrayList;
import java.util.List;

import com.san.meetup.group.bo.Group;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class GetUserGroupsResponse {
	@Builder.Default
	private List<Group> groups = new ArrayList<>();
}
