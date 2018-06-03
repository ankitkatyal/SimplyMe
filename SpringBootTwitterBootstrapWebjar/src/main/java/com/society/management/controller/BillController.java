package com.society.management.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.society.management.domain.Bill;
import com.society.management.domain.BillGrid;

@Controller
public class BillController {
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ModelAndView get() {
		
		BillGrid billForm = new BillGrid();
		List<Bill> billingList=new ArrayList<>();
		billForm.setBillingList(billingList);
		
		return new ModelAndView("BillForm" , "billForm",billForm);
	}


}
