package com.san.meetup.events.request;

import java.time.LocalDateTime;

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
	private String eventStartTime;
	private String eventEndTime;
	private String description;
}
