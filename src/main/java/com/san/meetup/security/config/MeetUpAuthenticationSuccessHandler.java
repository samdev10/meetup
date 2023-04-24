package com.san.meetup.security.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.san.meetup.user.bo.User;
import com.san.meetup.user.response.GetUserResponse;

public class MeetUpAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
 
    	UserDetails userDetails = (UserDetails) authentication.getPrincipal();
    	GetUserResponse user = GetUserResponse.builder().user(User.builder().email(userDetails.getUsername()).firstname(userDetails.getUsername()).build())
		.build();
    	
    	ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
    	String json = ow.writeValueAsString(user);
    	
    	PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(json);
        out.flush();
        
        response.encodeRedirectUrl("/login");
         
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
