package com.society.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.society.management.entity.RoleInfo;
import com.society.management.repository.RoleRepository;
import com.society.management.service.RoleServices;

@Component
public class RoleServiceImpl implements RoleServices {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public RoleInfo getRoleByRoleName(String roleName) {
		return roleRepository.findByRoleName(roleName);
	}

	@Override
	public void saveRoleInfo(RoleInfo roleInfo) {
		roleRepository.save(roleInfo);
	}

}
