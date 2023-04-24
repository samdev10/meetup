package com.san.meetup.events.response;

import com.san.meetup.events.bo.Event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CreateEventResponse {
	private Event event;

}
