package com.jcart.modules.security.service;

import com.jcart.modules.security.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService
{

	@Autowired
	private SecurityService securityService;
	
	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		User user = securityService.findUserByEmail(email);
		if(user == null){
			throw new UsernameNotFoundException("Email "+email+" not found");
		}
		return AuthenticatedUser.create(user);
	}

	@Transactional
	public UserDetails loadUserById(Long id) {
		User user = securityService.findUserById(id);

		if(user == null){
			throw new UsernameNotFoundException("Id "+id+" not found");
		}
		return AuthenticatedUser.create(user);
	}

}
