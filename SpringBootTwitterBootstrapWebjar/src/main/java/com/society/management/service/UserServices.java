package com.society.management.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.society.management.entity.UserInfo;

public interface UserServices extends UserDetailsService {

	public User doLogin(UserInfo user);

	public UserInfo doRegistration(UserInfo user);
	
	public UserInfo save(UserInfo userInfo);

	public UserInfo findByEmail(String email);

	public UserInfo findByConfirmationToken(String token);
}
