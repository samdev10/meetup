package com.san.meetup.events.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.san.meetup.events.bo.Event;
import com.san.meetup.group.bo.Group;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
	List<Event> findByGroup(Group group);
}
