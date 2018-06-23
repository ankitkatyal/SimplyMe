package com.society.management.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.society.management.entity.UserInfo;
import com.society.management.repository.UserRepository;
import com.society.management.service.UserServices;

@Service
public class UserServiceImpl implements UserServices {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	@Transactional(readOnly = true)
	public User doLogin(UserInfo userInfo) {
		UserInfo userInfoDB = userRepo.findByEmail(userInfo.getEmail());
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		// grantedAuthorities.add(new SimpleGrantedAuthori));
		return new User(userInfoDB.getEmail(), userInfoDB.getPassword(), grantedAuthorities);
	}

	@Override
	public UserInfo doRegistration(UserInfo userInfo) {
		userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
		return userRepo.save(userInfo);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserInfo userInfo = userRepo.findByEmail(email);
		UserDetails userDetails = null;
		if (userInfo == null)
			throw new UsernameNotFoundException("User not found by email: " + email);
		return userDetails;
	}

	@Override
	public UserInfo save(UserInfo userInfo) {
		return userRepo.save(userInfo);
	}

}
