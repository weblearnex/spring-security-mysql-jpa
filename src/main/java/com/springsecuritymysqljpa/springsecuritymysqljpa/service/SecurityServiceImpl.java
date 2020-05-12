package com.springsecuritymysqljpa.springsecuritymysqljpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecuritymysqljpa.springsecuritymysqljpa.model.entity.User;
import com.springsecuritymysqljpa.springsecuritymysqljpa.reposatory.UserRepository;
import com.springsecuritymysqljpa.springsecuritymysqljpa.utiles.LoginUtils;

@Service
public class SecurityServiceImpl implements SecurityServiceInf {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//return new LoginUtils(username);
		Optional<User> user = userRepository.findByName(username);
		user.orElseThrow(()->new UsernameNotFoundException("User not match in Database::"+username));
		return user.map(LoginUtils::new ).get();
		
	}

	@Override
	public User save(User user) {
		System.out.println(user.getName());
		return userRepository.save(user);
	}
	
	

}
