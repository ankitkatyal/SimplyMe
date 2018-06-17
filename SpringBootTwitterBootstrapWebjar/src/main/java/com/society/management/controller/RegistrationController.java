package com.society.management.controller;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.society.management.domain.User;
import com.society.management.entity.RoleInfo;
import com.society.management.entity.UserInfo;
import com.society.management.service.RoleServices;
import com.society.management.service.UserServices;

@Controller
public class RegistrationController {
	@Autowired
	private UserServices userServices;
	@Autowired
	private RoleServices roleServices;

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("user") User user, ModelMap userMap)
			throws IllegalAccessException, InvocationTargetException {
		System.out.println("Hello");

		UserInfo userInfo = new UserInfo();
		BeanUtils.copyProperties(userInfo, user);
		RoleInfo roleInfo = new RoleInfo();
		roleInfo.setRoleName("GUEST");
		userInfo.setRoleInfo(roleInfo);
		userServices.doRegistration(userInfo);
		return "sidebar";

	}

}
