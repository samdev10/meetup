package com.san.meetup.events.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateEventRequest {
	private Long groupId;
	private String name;
	private String description;
}
