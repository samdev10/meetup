package com.san.meetup.group.bo;

import java.io.Serializable;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.san.meetup.events.bo.Event;
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
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "MU_GROUP")
@Builder
@EqualsAndHashCode
public class Group implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;
    
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
    
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    @Default
    @JsonBackReference
	private Set<UserAndGroup> userGroupMappings = new HashSet<>();
    
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    @Default
    @JsonBackReference
	private Set<Event> events = new HashSet<>();
}
