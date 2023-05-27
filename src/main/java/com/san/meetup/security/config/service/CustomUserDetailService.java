package com.san.meetup.security.config.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;

import com.san.meetup.user.bo.User;
import com.san.meetup.user.repo.UserRepository;

public class CustomUserDetailService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public CustomUserDetailService(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (username == null) {
			throw new UsernameNotFoundException("Username and domain must be provided");
		}
		User user = userRepository.findUserByEmail(username).get();
		Collection<? extends GrantedAuthority> authorities = authorities();
		org.springframework.security.core.userdetails.User userD = new org.springframework.security.core.userdetails.User(
				user.getEmail(), bCryptPasswordEncoder.encode(""), authorities);
		
		return Optional.ofNullable(userD)
		          .orElseThrow(() -> new UsernameNotFoundException("User " + username + " does not exists"));
	}

	private Collection<? extends GrantedAuthority> authorities() {
		GrantedAuthority auth = () -> "ROLE_USER";
		return Arrays.asList(auth);
	}

}
