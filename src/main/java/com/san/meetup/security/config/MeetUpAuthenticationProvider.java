package com.san.meetup.security.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

//public class MeetUpAuthenticationProvider implements AuthenticationProvider {
//    
//	Authentication authenticate(Authentication authentication)  // (1)
//            throws AuthenticationException {
//        String username = authentication.getPrincipal().toString(); // (1)
//        String password = authentication.getCredentials().toString(); // (1)
//
//        User user = callAtlassianCrowdRestService(username, password); // (2)
//        if (user == null) {                                     // (3)
//            throw new AuthenticationException("could not login");
//        }
//        return new UserNamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities()); // (4)
//    }
//}
