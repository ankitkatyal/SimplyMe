package com.society.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.society.management.entity.RoleInfo;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<RoleInfo, Integer> {

	RoleInfo findByRoleName(String roleName);

}
