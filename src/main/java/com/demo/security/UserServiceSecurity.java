package com.demo.security;

import java.util.List;
import java.util.stream.Collectors;

//
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.entity.Role;
import com.demo.entity.UserEntity;
import com.demo.repositry.UserRepo;

@Service
public class UserServiceSecurity implements UserDetailsService {
	@Autowired
	UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserEntity user = userRepo.findByUserName(userName);

		if (user == null)
			throw new UsernameNotFoundException("User or password Invaild");
		else
			return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getUserPassword(),
					mapToGrantedAuthority(user.getRole()));

	}

	private List<GrantedAuthority> mapToGrantedAuthority(List<Role> roles) {

		return roles.stream().map(authority -> new SimpleGrantedAuthority(authority.getRoleName().name()))
				.collect(Collectors.toList());

	}
}
