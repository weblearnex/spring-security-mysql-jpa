package com.springsecuritymysqljpa.springsecuritymysqljpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.springsecuritymysqljpa.springsecuritymysqljpa.reposatory.UserRepository;

@SpringBootApplication
//@EnableJpaRepositories(basePackageClasses =UserRepository.class)
public class SpringSecurityMysqlJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityMysqlJpaApplication.class, args);
	}

}
