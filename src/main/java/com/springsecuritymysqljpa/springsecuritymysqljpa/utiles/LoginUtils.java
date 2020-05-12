package com.springsecuritymysqljpa.springsecuritymysqljpa.utiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.springsecuritymysqljpa.springsecuritymysqljpa.model.entity.Role;
import com.springsecuritymysqljpa.springsecuritymysqljpa.model.entity.User;

public class LoginUtils implements UserDetails {
	
	
	
	/*public LoginUtils(String userName){
		this.username = userName;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
		return "user";
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}*/
	private String username;
	private String password;
	private Boolean isActive;
	private List<GrantedAuthority> authority;
	
	public LoginUtils(User user){
			this.username =user.getName();
			this.password =user.getPassword();
			this.isActive =user.getIsActive();
			List<String> strlist = user.getRole().stream().map(p ->p.getUserRole()).collect(Collectors.toList());
			System.out.println(strlist);
			this.authority =  strlist.stream().map(SimpleGrantedAuthority ::new).collect(Collectors.toList());
	}
	
	
	public LoginUtils(){

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authority ;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.isActive;
	}

}
