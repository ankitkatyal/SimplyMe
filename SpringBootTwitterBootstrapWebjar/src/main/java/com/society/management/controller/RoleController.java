package com.society.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.society.management.entity.RoleInfo;
import com.society.management.service.RoleServices;

@Controller
public class RoleController {

	@Autowired
	private RoleServices roleServices;

	public void saveRoleInfo(RoleInfo roleInfo) {
		roleServices.saveRoleInfo(roleInfo);

	}

}
