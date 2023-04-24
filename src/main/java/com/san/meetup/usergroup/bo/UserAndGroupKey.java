package com.san.meetup.usergroup.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class UserAndGroupKey implements Serializable {
    private static final long serialVersionUID = 1L;

		@Column(name = "user_id")
	    Long userId;
	
	    @Column(name = "group_id")
	    Long groupId;
}
