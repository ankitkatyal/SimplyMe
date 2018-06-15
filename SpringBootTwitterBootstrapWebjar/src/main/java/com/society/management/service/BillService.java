package com.society.management.service;

import com.society.management.domain.Bill;

public interface BillService {
	
	Bill findById(int id);
	Bill findByCustomerName(String customerName);
	Bill save(Bill bill);
	void deleteBill(Integer billId);

}
