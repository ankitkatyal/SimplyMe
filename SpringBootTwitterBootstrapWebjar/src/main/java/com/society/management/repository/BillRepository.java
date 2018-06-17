package com.society.management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.society.management.entity.Bill;


@Repository
public interface BillRepository extends CrudRepository<Bill, Integer> {

	
	Bill findByCustomerName(String customerName);
}
