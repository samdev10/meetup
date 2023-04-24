package com.san.meetup.events.response;

import java.util.ArrayList;
import java.util.List;

import com.san.meetup.events.bo.Event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class GetEventsResponse {
	private List<Event> events = new ArrayList<>();
}
