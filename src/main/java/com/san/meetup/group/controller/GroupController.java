package com.san.meetup.group.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.san.meetup.group.bo.Group;
import com.san.meetup.group.request.CreateGroupRequest;
import com.san.meetup.group.request.GetUserGroupRequest;
import com.san.meetup.group.response.CreateGroupResponse;
import com.san.meetup.group.response.GetUserGroupsResponse;
import com.san.meetup.group.service.GroupService;

import liquibase.repackaged.org.apache.commons.lang3.ObjectUtils;

@RestController
public class GroupController {
	@Autowired
	private GroupService groupService;

	@PostMapping(value = "/api/group/create", produces = "application/json")
	ResponseEntity<CreateGroupResponse> create(@RequestBody CreateGroupRequest request) {
		final Group group = Group.builder().name(request.getName()).description(request.getDescription()).build();
		CreateGroupResponse response = CreateGroupResponse.builder()
				.group(groupService.saveGroup(group, request.getEmail())).build();
		return new ResponseEntity<CreateGroupResponse>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/api/group/userGroups")
	ResponseEntity<GetUserGroupsResponse> userGroups(@RequestParam("userId") Long userId) {
		GetUserGroupsResponse response = GetUserGroupsResponse.builder().groups(groupService.getGroups(userId)).build();
		return new ResponseEntity<GetUserGroupsResponse>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/api/group/groups")
	ResponseEntity<GetUserGroupsResponse> getGroups(@RequestBody GetUserGroupRequest userGroupRequest) {
		GetUserGroupsResponse response = null;
		if (ObjectUtils.isNotEmpty(userGroupRequest.getUserId())) {
			response = GetUserGroupsResponse.builder().groups(groupService.getGroups(userGroupRequest.getUserId()))
					.build();
		} else if (StringUtils.hasText(userGroupRequest.getEmail())) {
			response = GetUserGroupsResponse.builder().groups(groupService.getGroups(userGroupRequest.getEmail()))
					.build();
		}

		return new ResponseEntity<GetUserGroupsResponse>(response, HttpStatus.OK);
	}
}
