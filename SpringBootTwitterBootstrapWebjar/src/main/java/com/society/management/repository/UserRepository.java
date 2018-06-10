package com.society.management.repository;

import com.society.management.entity.User;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	User findById(long Id);

	List<User> findByFirstName(String firstName);

	List<User> findByMiddleName(String middleName);

	List<User> findByLastName(String lastName);

	User findByEmail(String email);

	User findByAadhar(String aadhar);

	Boolean persist(User user);

}
