package com.example.java_demo_test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.java_demo_test.entity.Users;
import com.example.java_demo_test.repository.UserDao;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users item = userDao.findByUserName(username);
		UserDetails userDetails = User.builder() //
				.username(item.getUserName()) //
				.password(item.getPassword()) //
				.roles(item.getRole())//
				.build();
		return userDetails;
	}

}
