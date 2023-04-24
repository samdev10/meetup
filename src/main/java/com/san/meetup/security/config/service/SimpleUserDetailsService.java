package com.san.meetup.security.config.service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.san.meetup.user.bo.User;
import com.san.meetup.user.repo.UserRepository;

@Service("userDetailsService")
public class SimpleUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String[] usernameAndDomain = StringUtils.split(
		          username, String.valueOf(Character.LINE_SEPARATOR));
		        if (username == null || usernameAndDomain.length != 2) {
		            throw new UsernameNotFoundException("Username and domain must be provided");
		        }
		        User user = userRepository.findUserByEmail(usernameAndDomain[0]).get();
		        if (user == null) {
		            throw new UsernameNotFoundException(
		              String.format("Username not found for domain, username=%s", 
		                usernameAndDomain[0]));
		        }
		        Collection<? extends GrantedAuthority> authorities = authorities();
				org.springframework.security.core.userdetails.User userD = new org.springframework.security.core.userdetails.User(user.getFirstname(), encoder.encode(""), authorities);
		        return userD;
	}

	private Collection<? extends GrantedAuthority> authorities() {
		GrantedAuthority auth = () -> "ROLE_USER";
		return Arrays.asList(auth);
	}

}
