package com.san.meetup.group.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.san.meetup.group.bo.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}
