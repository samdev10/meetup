package com.san.meetup.group.service.api;

import java.util.List;

import com.san.meetup.group.bo.Group;

public interface GroupApi {

	Group saveGroup(Group group, Long userId);

	List<Group> getGroups(Long userId);

}
