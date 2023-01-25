package com.example.apiblogapplication.security;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.apiblogapplication.entity.Role;
import com.example.apiblogapplication.entity.User;
import com.example.apiblogapplication.repository.UserRepository;

@Configuration

public class CustumUserDetailsService implements UserDetailsService   {
	
	@Autowired
	private UserRepository ur;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = ur.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("username not found"));
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword() , mapToAuthorities(user.getRoles()));

		
	}


	private Collection<? extends GrantedAuthority> mapToAuthorities(Set<Role> roles) {
		
		return 	roles.stream().map(x-> new SimpleGrantedAuthority(x.getRole())).collect(Collectors.toList());


	}

}
