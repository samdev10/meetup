package com.san.meetup.usergroup.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAndGroupKey implements Serializable {
    private static final long serialVersionUID = 1L;

		@Column(name = "user_id")
	    Long userId;
	
	    @Column(name = "group_id")
	    Long groupId;
}
