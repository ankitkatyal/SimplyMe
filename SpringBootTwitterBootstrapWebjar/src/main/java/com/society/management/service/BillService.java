package com.society.management.service;

import org.springframework.stereotype.Service;

import com.society.management.entity.Bill;

@Service
public interface BillService {

	Bill findById(int id);

	Bill findByCustomerName(String customerName);

	Bill save(Bill bill);

	void deleteBill(Integer billId);

}
