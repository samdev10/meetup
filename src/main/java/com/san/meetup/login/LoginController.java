package com.san.meetup.login;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.san.meetup.security.jwt.JwtTokenUtil;
import com.san.meetup.user.bo.User;
import com.san.meetup.user.repo.UserRepository;

import org.springframework.security.authentication.AuthenticationManager;

@RestController
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
	private UserRepository userRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

	@PostMapping("/login")
    public ResponseEntity<AuthToken> loginEndpoint(@RequestBody LoginRequest request) throws AuthenticationException {

		try {
			Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
			Optional<User> user = null;
			String token = null;
			if(authenticate.isAuthenticated()) {				
				user = userRepository.findUserByEmail(authenticate.getName());
				token = jwtTokenUtil.generateToken(user.get());
			}

            return ResponseEntity.ok()
                .header(
                    HttpHeaders.AUTHORIZATION
                )
                .body(new AuthToken(token, user.get().getEmail()));
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
