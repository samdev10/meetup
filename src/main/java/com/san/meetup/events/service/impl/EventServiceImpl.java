package com.san.meetup.events.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.san.meetup.events.bo.Event;
import com.san.meetup.events.repo.EventRepository;
import com.san.meetup.events.service.api.EventApi;
import com.san.meetup.group.bo.Group;
import com.san.meetup.group.repo.GroupRepository;

@Service
public class EventServiceImpl implements EventApi {
	@Autowired
	private EventRepository eventRepo;

	@Autowired
	private GroupRepository groupRepo;

	@Override
	public Event saveEvent(Event event, Long groupId) {
		Group group = groupRepo.findById(groupId).get();
		event.setGroup(group);
		event.setDateFrom(new Date());
		event.setDateTo(new Date());
		event.setTimeFrom("timeFrom");
		event.setTimeTo("timeTo");

		Event persistedEvent = eventRepo.saveAndFlush(event);

		return persistedEvent;
	}
	
	public List<Event> getEvents(Long groupId) {
		Group group = groupRepo.findById(groupId).get();
		return eventRepo.findByGroup(group);
	}
}
