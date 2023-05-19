package com.san.meetup.usergroup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.san.meetup.user.bo.User;
import com.san.meetup.usergroup.bo.UserAndGroup;
import com.san.meetup.usergroup.bo.UserAndGroupKey;

@Repository
public interface UserAndGroupRepository extends JpaRepository<UserAndGroup, UserAndGroupKey> {
	List<UserAndGroup> findByUser(User user);
}