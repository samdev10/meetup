package com.san.meetup.group.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateGroupRequest {
	private Long userId;
	private String email;
	private String name;
	private String description;
}
