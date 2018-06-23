package com.society.management.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;

import javax.validation.Valid;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import com.society.management.util.RoleEnum;

@Controller
public class RegistrationController {
	@Autowired
	private UserServices userServices;
	@Autowired
	private RoleServices roleServices;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("user") @Valid User user, ModelMap userMap)
			throws IllegalAccessException, InvocationTargetException {
		UserInfo userInfo = new UserInfo();
		BeanUtils.copyProperties(userInfo, user);
		userInfo.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userInfo.setStatInd(1);
		RoleInfo userRole = roleServices.findByRole(RoleEnum.GUEST.name());
		userInfo.setRoleInfo(new HashSet<RoleInfo>(Arrays.asList(userRole)));
		userServices.save(userInfo);
		userServices.doRegistration(userInfo);
		return "HomeMenu";
	}

}
