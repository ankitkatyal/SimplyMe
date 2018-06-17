package com.society.management.service;

import org.springframework.stereotype.Service;

import com.society.management.entity.RoleInfo;

@Service
public interface RoleServices {

	RoleInfo getRoleByRoleName(String roleName);

	void saveRoleInfo(RoleInfo roleInfo);

}
