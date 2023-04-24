package com.san.meetup.usergroup.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.san.meetup.usergroup.bo.UserAndGroup;

@Repository
public interface  UserAndGroupRepository extends JpaRepository<UserAndGroup, Long> {
}