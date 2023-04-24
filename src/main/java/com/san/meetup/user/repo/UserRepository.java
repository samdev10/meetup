package com.san.meetup.user.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.san.meetup.user.bo.User;

@Repository
public interface  UserRepository extends JpaRepository<User, Long> {
	List<User> findAll();
	
	Optional<User> findUserByEmail(final String email);

	Optional<User> findById(String userId);
}
