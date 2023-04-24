package com.san.meetup.events.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.san.meetup.group.bo.Group;
import com.san.meetup.usergroup.bo.UserAndGroup;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "MU_EVENTS")
@Builder
@EqualsAndHashCode
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Exclude
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "date_from")
	private Date dateFrom;

	@Column(name = "date_to")
	private Date dateTo;

	@Column(name = "time_from")
	private String timeFrom;

	@Column(name = "time_to")
	private String timeTo;

	@Column(name = "group_id", insertable = false, updatable = false)
	private Long groupId;

	@ManyToOne
	@JoinColumn(name = "group_id", nullable = false)
	@JsonManagedReference
	private Group group;

}
