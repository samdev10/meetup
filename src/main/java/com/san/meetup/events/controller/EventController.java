package com.san.meetup.events.controller;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.san.meetup.events.bo.Event;
import com.san.meetup.events.request.CreateEventRequest;
import com.san.meetup.events.response.CreateEventResponse;
import com.san.meetup.events.response.GetEventsResponse;
import com.san.meetup.events.service.impl.EventServiceImpl;

@RestController
public class EventController {
	@Autowired
	private EventServiceImpl eventService;

	@PostMapping(value = "/api/event/create", produces = "application/json")
	ResponseEntity<CreateEventResponse> create(@RequestBody CreateEventRequest request) {
		final Event event = Event.builder().name(request.getName()).description(request.getDescription())
				.eventStartTime(toUtc(request.getEventStartTime())).eventEndTime(toUtc(request.getEventEndTime()))
				.build();
		CreateEventResponse response = CreateEventResponse.builder()
				.event(eventService.saveEvent(event, (Long) request.getGroupId())).build();
		return new ResponseEntity<CreateEventResponse>(response, HttpStatus.OK);
	}

	private LocalDateTime toUtc(String time) {
		return LocalDateTime.parse(time).atOffset(ZoneOffset.UTC).toLocalDateTime();
	}

	@GetMapping(value = "/api/events")
	ResponseEntity<GetEventsResponse> getEvents(@RequestParam("groupId") Long groupId) {
		GetEventsResponse response = GetEventsResponse.builder().events(eventService.getEvents(groupId)).build();
		return new ResponseEntity<GetEventsResponse>(response, HttpStatus.OK);
	}
}
