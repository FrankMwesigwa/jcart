package com.jcart.modules.security.service;

import com.jcart.modules.security.entities.User;
import com.jcart.modules.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class SecurityService
{
	@Autowired
	UserRepository userRepository;
	
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

    public User findUserById(Long userId) {
        return userRepository.findById(userId);
    }
	

}
