package com.san.meetup.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.san.meetup.security.config.service.SimpleUserDetailsService;
import com.san.meetup.user.service.UserService;

@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	SimpleUserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
	      .addFilterBefore(authenticationFilter(), 
	    	        UsernamePasswordAuthenticationFilter.class)
	    	      .authorizeRequests()
	    	        .antMatchers("/bundle.js","/css/**", "/index").permitAll()
	    	        .anyRequest().hasAnyAuthority("ROLE_ANONYMOUS", "ROLE_USER")
	    	        .and().formLogin()
	    	        .loginPage("/login")
	    	        .and()
	    	        .logout()
	    	        .logoutUrl("/logout")
	    	        .invalidateHttpSession(true)
	    	        .deleteCookies("JSESSIONID")
	    	        .and().csrf().disable();
	}
	

	public MeetUpAuthenticationFilter authenticationFilter() throws Exception {
    	MeetUpAuthenticationFilter filter = new MeetUpAuthenticationFilter();
        filter.setAuthenticationManager(authenticationManagerBean());
        filter.setAuthenticationFailureHandler(failureHandler());
        return filter;
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
    }

    public AuthenticationProvider authProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }

    public SimpleUrlAuthenticationFailureHandler failureHandler() {
        return new SimpleUrlAuthenticationFailureHandler("/login?error=true");
    }
}
