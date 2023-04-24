package com.san.meetup.events.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.san.meetup.events.bo.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
	List<Event> findByGroupId(Long groupId);
}
