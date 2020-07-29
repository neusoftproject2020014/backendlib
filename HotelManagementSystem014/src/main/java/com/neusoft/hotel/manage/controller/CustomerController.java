package com.neusoft.hotel.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.hotel.manage.model.CustomerModel;
import com.neusoft.hotel.manage.service.ICustomerService;

@RestController
@RequestMapping(value="/customer")
public class CustomerController {
	@Autowired
	private ICustomerService cs=null;
		
	@GetMapping(value="/add")
	public String add(CustomerModel customer) throws Exception{
		System.out.print(customer.getName());
		cs.add(customer);
		return "ok";
		
	}

	@GetMapping(value="/select")
	public CustomerModel select(String id) throws Exception{
		return cs.selectAll(id);
	}
}
