package com.san.meetup.usergroup.bo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.san.meetup.group.bo.Group;
import com.san.meetup.user.bo.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Entity(name = "MU_USER_GROUP")
@Builder
public class UserAndGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    private UserAndGroupKey id;

    // bi-directional many-to-one association to user
    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private User user;
    
    // bi-directional many-to-one association to group
    @ManyToOne
    @MapsId("groupId")
    @JoinColumn(name = "group_id")
    @JsonManagedReference
    // bidirectional-relationships-and-infinite-recursion
    private Group group;
}
