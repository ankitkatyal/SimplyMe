package com.society.management.service;

import com.society.management.entity.User;

public interface UserServices {

	public boolean doLogin(User user);

	public boolean doRegistration(User user);
}
