package com.society.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.society.management.entity.Bill;
import com.society.management.repository.BillRepository;
import com.society.management.service.BillService;

@Component
public class BillServiceImpl implements BillService {

	@Autowired
	private BillRepository billRepository;

	@Override
	public Bill findById(int id) {

		return billRepository.findOne(id);
	}

	@Override
	public Bill findByCustomerName(String customerName) {

		return billRepository.findByCustomerName(customerName);
	}

	@Override
	public Bill save(Bill bill) {

		return billRepository.save(bill);
	}

	@Override
	public void deleteBill(Integer billId) {

		billRepository.delete(billId);
	}

}
