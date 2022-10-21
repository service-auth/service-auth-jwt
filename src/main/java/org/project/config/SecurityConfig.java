package org.project.config;

import java.util.ArrayList;
import java.util.Collection;

import org.project.models.User;
import org.project.filter.JwtAuthFilter;

import org.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserService service;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	  auth.userDetailsService(new UserDetailsService() {
		
		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			User  user = service.getUser(username);
			Collection<GrantedAuthority>  authorities = new ArrayList<GrantedAuthority>();
			user.getRoles().forEach(r->{
				authorities.add(new SimpleGrantedAuthority(r.getName()));
			});
			return new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities);
		}
	});
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		//statelles
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.headers().frameOptions().disable();
		//http.formLogin();
		http.authorizeHttpRequests().anyRequest().authenticated();
	    http.addFilter(new JwtAuthFilter(authenticationManagerBean()));
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
}
