package com.society.management.service;

import org.springframework.stereotype.Service;

import com.society.management.entity.RoleInfo;

@Service
public interface RoleServices {

	void saveRoleInfo(RoleInfo roleInfo);

	RoleInfo findByRole(String roleName);

}
