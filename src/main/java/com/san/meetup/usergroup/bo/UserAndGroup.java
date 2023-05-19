package com.san.meetup.usergroup.bo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.san.meetup.group.bo.Group;
import com.san.meetup.user.bo.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "MU_USER_GROUP")
@Builder
public class UserAndGroup {
	@EmbeddedId
	private UserAndGroupKey id;

	// bi-directional many-to-one association to user
	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;

	// bi-directional many-to-one association to group
	@ManyToOne
	@MapsId("groupId")
	@JoinColumn(name = "group_id")
	@JsonIgnore
	private Group group;
}
