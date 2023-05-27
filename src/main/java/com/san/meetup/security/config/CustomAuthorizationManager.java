//package com.san.meetup.security.config;
//
//import java.util.function.Supplier;
//
//import org.aopalliance.intercept.MethodInvocation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationTrustResolver;
//import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
//import org.springframework.security.authorization.AuthorizationDecision;
//import org.springframework.security.authorization.AuthorizationManager;
//import org.springframework.security.core.Authentication;
//
//import com.san.meetup.user.bo.User;
//
//public class CustomAuthorizationManager<T> implements AuthorizationManager<MethodInvocation> {
//	private final AuthenticationTrustResolver trustResolver = new AuthenticationTrustResolverImpl();
//
//	@Autowired
//	private AuthenticationManager authenticationManager;
//	
//	@Override
//	public AuthorizationDecision check(Supplier<Authentication> authentication, MethodInvocation methodInvocation) {
//		Authentication authenticate = authenticationManager.authenticate(authentication.get());
//
//		if (hasAuthentication(authenticate)) {
//
//			User user = (User) authenticate.getPrincipal();
//
//			return new AuthorizationDecision(true);
//
//		}
//
//		return new AuthorizationDecision(false);
//	}
//
//	private boolean hasAuthentication(Authentication authentication) {
//		boolean notAnonymous = isNotAnonymous(authentication);
//		boolean authenticated = authentication.isAuthenticated();
//		return authentication != null && notAnonymous && authenticated;
//	}
//
//	private boolean isNotAnonymous(Authentication authentication) {
//		return !this.trustResolver.isAnonymous(authentication);
//	}
//}
