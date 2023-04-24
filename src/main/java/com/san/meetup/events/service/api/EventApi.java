package com.san.meetup.events.service.api;

import java.util.List;

import com.san.meetup.events.bo.Event;

public interface EventApi {

	Event saveEvent(Event event, Long groupId);

	List<Event> getEvents(Long groupId);

}
