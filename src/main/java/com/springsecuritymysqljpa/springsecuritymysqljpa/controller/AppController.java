package com.springsecuritymysqljpa.springsecuritymysqljpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springsecuritymysqljpa.springsecuritymysqljpa.model.entity.User;
import com.springsecuritymysqljpa.springsecuritymysqljpa.service.SecurityServiceInf;

@RestController
public class AppController {
	
	@Autowired
	private SecurityServiceInf securityServiceInf;
	
	@GetMapping("/")
	public String getWelcome(){
		return "<h1>Welcome for All</h1>";
	}
	
	@GetMapping("/admin")
	public String getAdmin(){
		return "<h1>Welcome admin Api</h1>";
	}
	
	@GetMapping("/user")
	public String getUser(){
		return "<h1>Welcome user Api</h1>";
	}
	
	@PostMapping("/save/data")
	public User save(@RequestBody User user){
		return securityServiceInf.save(user);
	}
	
	

}
