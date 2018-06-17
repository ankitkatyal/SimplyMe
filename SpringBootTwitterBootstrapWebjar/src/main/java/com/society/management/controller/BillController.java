package com.society.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.society.management.entity.Bill;
import com.society.management.service.BillService;

@RestController
public class BillController {

	@Autowired
	private BillService billService;

	@RequestMapping(value = "/bill/{id}", method = RequestMethod.GET)
	public Bill findById(@PathVariable("id") int id) {

		return billService.findById(id);
	}

	@RequestMapping(value = "/bill", method = RequestMethod.POST)
	public Bill addBill(@RequestBody Bill bill) {
		return billService.save(bill);
	}

	@RequestMapping(value = "/bill/{id}", method = RequestMethod.DELETE)
	public void deleteBill(@PathVariable("id") int id) {
		billService.deleteBill(id);
	}

}
