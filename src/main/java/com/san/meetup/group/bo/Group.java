package com.san.meetup.group.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.san.meetup.events.bo.Event;
import com.san.meetup.usergroup.bo.UserAndGroup;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "MU_GROUP")
@Builder
public class Group {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Exclude
	private Long id;

	@Column(name = "name")
	@NotBlank
	private String name;

	@Column(name = "description")
	@NotBlank
	private String description;

	@OneToMany(mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Builder.Default
	@JsonBackReference
	private Set<UserAndGroup> userGroupMappings = new HashSet<>();

	@OneToMany(mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Builder.Default
	@JsonBackReference
	private Set<Event> event = new HashSet<>();
}
