package com.society.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.society.management.entity.UserInfo;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserInfo, Integer> {

	UserInfo findById(long Id);

	List<UserInfo> findByFirstName(String firstName);

	List<UserInfo> findByMiddleName(String middleName);

	List<UserInfo> findByLastName(String lastName);

	UserInfo findByEmail(String email);
	
	UserInfo findByAadharNumber(String aadhar);

}
