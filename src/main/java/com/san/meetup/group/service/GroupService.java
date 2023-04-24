package com.san.meetup.group.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.san.meetup.group.bo.Group;
import com.san.meetup.group.repo.GroupRepository;
import com.san.meetup.group.service.api.GroupApi;
import com.san.meetup.user.bo.User;
import com.san.meetup.user.repo.UserRepository;
import com.san.meetup.usergroup.bo.UserAndGroup;
import com.san.meetup.usergroup.bo.UserAndGroupKey;
import com.san.meetup.usergroup.repo.UserAndGroupRepository;

@Service
public class GroupService implements GroupApi {
	@Autowired
	private GroupRepository groupRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private UserAndGroupRepository userAndGroupRepo;

	@Override
	public Group saveGroup(Group group, Long userId) {
		User user = userRepo.findById(userId).get();
		Group persistedGroup = groupRepo.saveAndFlush(group);

		UserAndGroup userAndGroup = UserAndGroup.builder()
				.id(UserAndGroupKey.builder().userId(user.getId()).groupId(persistedGroup.getId()).build()).user(user)
				.group(persistedGroup).build();
		userAndGroupRepo.save(userAndGroup);

		return persistedGroup;
	}
	
	public List<Group> getGroups(Long userId) {
		return groupRepo.findByUserGroupMappingsUserId(userId);
	}
}
