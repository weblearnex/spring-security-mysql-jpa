package com.springsecuritymysqljpa.springsecuritymysqljpa.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.springsecuritymysqljpa.springsecuritymysqljpa.model.entity.User;

public interface SecurityServiceInf extends UserDetailsService {
	User save(User user);

}
