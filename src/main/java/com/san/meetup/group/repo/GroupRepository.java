package com.san.meetup.group.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.san.meetup.group.bo.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
	List<Group> findByUserGroupMappingsUserId(Long userId);
}
