package com.society.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.society.management.entity.User;
import com.society.management.repository.UserRepository;
import com.society.management.service.UserServices;

public class UserServiceImpl implements UserServices {

	@Autowired
	private UserRepository userRepo;

	@Override
	public boolean doLogin(User user) {
		User userinfo = userRepo.findByEmail(user.getEmail());

		return false;
	}

	@Override
	public boolean doRegistration(User user) {
		return userRepo.persist(user);
	}

}
